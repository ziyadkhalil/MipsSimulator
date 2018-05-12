package board;

import assembler.Assembler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import units.InstructionMemory;
import units.MemElemet;
import units.Register;
import units.Wire;
import z.MipsTextArea;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;


public class MainController implements Initializable {
    Assembler assembler;
    InstructionMemory instructionMemory;
    ObservableList<Wire> controlWires;
    ObservableList<Wire> dataPathsWires;
    PrintStream printStream ;
    @FXML
    Processor CircuitController;
    @FXML TableView<Register> registersTableView;
    @FXML TableColumn registerNameColumn;
    @FXML TableColumn registerValueColumn;
    @FXML TableView<Wire> controlsWiresTableView;
    @FXML TableColumn wireNameControlsColumn;
    @FXML TableColumn wireValueControlsColumn;
    @FXML TableView<Wire> dataPathsWiresTableView;
    @FXML TableColumn wireNameDataPathsColumn;
    @FXML TableColumn wireValueDataPathsColumn;
    @FXML  public ListView instructionsList;
    @FXML Button runButton;
    @FXML Button nextStep;
    @FXML MipsTextArea codeArea;
    @FXML MenuItem saveMenuButton;
    @FXML TableView<MemElemet> dataMemoryTable;
    @FXML TableColumn dataMemoryAddressColumn;
    @FXML TableColumn dataMemoryDataColumn;
    private boolean fileNotSaved;
    FileChooser fileChooser = new FileChooser();
    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        injectMenu();



    runButton.setOnAction(event -> {

        File file = new File("input.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                printStream = new PrintStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String[] lines = codeArea.getText().split("\n");
            for (String line:
                    lines) {
                printStream.println(line);
            }
            printStream.close();
        assembler=new Assembler();
        assembler.setInput(file);
            try {
                assembler.assemble();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            instructionMemory = new InstructionMemory();
            instructionMemory.setInstructions(assembler.getInstructions());
            instructionMemory.setInitialLocation(assembler.getInitialLocation());
            CircuitController.injectInstructionMemory(instructionMemory);
            CircuitController.injectMainController(this);
            controlWires = Wire.initControlWires(CircuitController.getBooleanWires(),CircuitController.getStringWires());
            dataPathsWires = Wire.initDataPathsWires(CircuitController.getBooleanWires(),CircuitController.getStringWires());
            populateRegistersTable();
            populateWiresTable();
            populateInstructionsList();
            CircuitController.stepByStep();
            populateDataMemTableView();
    });
    nextStep.setOnAction(e->{
        CircuitController.stepByStep();
    });

    }

    private void populateDataMemTableView() {
        MemElemet memElemet = new MemElemet(CircuitController.getDataMemory().getMemory());
        System.out.println(CircuitController.getDataMemory().getMemory());
        CircuitController.getDataMemory().getMemory().forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println("ss2:   "+s +s2);
            }
        });
        dataMemoryTable.setItems(memElemet.getMemElements());
        dataMemoryAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        dataMemoryDataColumn.setCellValueFactory(new PropertyValueFactory<>("dataValue"));


    }

    private void injectMenu() {
        saveMenuButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Text");
            fileChooser.setInitialFileName("Untitled1");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.setSelectedExtensionFilter(extFilter);
            File file = fileChooser.showSaveDialog(((AnchorPane) runButton.getParent()).getScene().getWindow());
            String filename = file.getName()+".txt";
            try {
                file.renameTo(new File(file.getParent(),filename));
                printStream = new PrintStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (file != null) {
                String[] lines = codeArea.getText().split("\n");
                for (String line:
                     lines) {
                    printStream.println(line);
                }
                printStream.close();
            }
        });
    }

    private void saveText() {
    }

    private void populateInstructionsList() {
        instructionsList.setItems(instructionMemory.getInstructions());
    }

    private void populateWiresTable() {
        controlsWiresTableView.setItems(controlWires);
        wireNameControlsColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        wireValueControlsColumn.setCellValueFactory(new PropertyValueFactory<>("stringValue"));

        dataPathsWiresTableView.setItems(dataPathsWires);
        wireNameDataPathsColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        wireValueDataPathsColumn.setCellValueFactory(new PropertyValueFactory<>("stringValue"));
    }

    private void populateRegistersTable() {
        this.registersTableView.setItems(CircuitController.getRegisters());
        this.registerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.registerValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));


    }
}
