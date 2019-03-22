package board;

import assembler.Assembler;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import units.InstructionMemory;
import units.MemElemet;
import units.Register;
import units.Wire;
import utils.MipsUtils;
import z.MipsTextArea;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;


public class MainController implements Initializable {
    private static final String ZERO_ERROR = "INSTRUCTION MEMORY IS NOT INITIALIZED" ;
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
    @FXML ComboBox valuesRepresentation;
    @FXML Button debugButton;
    @FXML TextField initInstructionMemTextField;
    @FXML Label cyclesCountLabel;
    private boolean fileNotSaved;
    FileChooser fileChooser = new FileChooser();
    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        injectMenu();
        valuesRepresentation.setItems(FXCollections.observableArrayList(Arrays.asList("Binary","Decimal","Hexadecimal")));
    runButton.setOnAction(event -> {
        if(initInstructionMemTextField.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,ZERO_ERROR, ButtonType.OK);
            alert.showAndWait();
            return;
        }
            CircuitController.resetIterator();
            CircuitController.setCyclesCount(0);
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
        assembler.setInitialLocation(Integer.parseInt(initInstructionMemTextField.getText()));
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
            populateDataMemTableView();
            nextStep.fire();
    });
    debugButton.setOnAction(event->{
        if(initInstructionMemTextField.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,ZERO_ERROR, ButtonType.OK);
            alert.showAndWait();
            return;
        }
        CircuitController.resetIterator();
        CircuitController.setCyclesCount(0);

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
        assembler.setInitialLocation(Integer.parseInt(initInstructionMemTextField.getText()));
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
        populateDataMemTableView();
        CircuitController.process();
    });
    nextStep.setOnAction(e->{
        CircuitController.stepByStep();
        valuesRepresentation.fireEvent(e);
    });
    valuesRepresentation.setOnAction(e->{
        switch(((ComboBox) e.getSource()).getSelectionModel().getSelectedIndex()){
            case 0:
                setTableValuesToBinary();
                break;
            case 1:
                setTableValuesToDecimal();
                break;
            case 2:
                setTableValuesToHex();
                break;
                default:
                    setTableValuesToBinary();
        }
    });
    }

    public void populateDataMemTableView() {
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
    //    dataMemoryDataColumn.setCellValueFactory(new PropertyValueFactory<>("dataValue"));




    }

    public void setTableValuesToDecimal (){
        registerValueColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                return new SimpleIntegerProperty((int)Long.parseLong(((Register)param.getValue()).getValue(),2));
            }
        });
        dataMemoryDataColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                return new SimpleIntegerProperty((int)Long.parseLong(((MemElemet) param.getValue()).getDataValue().toString(),2));
            }
        });
        dataMemoryAddressColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                return new SimpleIntegerProperty((int)Long.parseLong(((MemElemet) param.getValue()).getAddress().toString(),2));
            }
        });
        wireValueDataPathsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                return new SimpleIntegerProperty((int)Long.parseLong(((Wire) param.getValue()).getStringValue().toString(),2));
            }
        });
        registersTableView.refresh();
        dataMemoryTable.refresh();
        dataPathsWiresTableView.refresh();
    }
    public void setTableValuesToHex () {
        registerValueColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                return new SimpleStringProperty(MipsUtils.extendHex(Integer.toHexString((int)Long.parseLong(((Register)param.getValue()).valueProperty().getValue(),2))));
            }
        });
        dataMemoryDataColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                return new SimpleStringProperty(MipsUtils.extendHex(Integer.toHexString((int)Long.parseLong(((MemElemet) param.getValue()).dataValueProperty().getValue(),2))));
            }
        });
        dataMemoryAddressColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                return new SimpleStringProperty(MipsUtils.extendHex(Integer.toHexString((int)Long.parseLong(((MemElemet) param.getValue()).addressProperty().getValue(),2))));
            }
        });
        wireValueDataPathsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                return new SimpleStringProperty(MipsUtils.extendHex(Integer.toHexString((int)Long.parseLong(((Wire) param.getValue()).stringValueProperty().getValue(),2))));
            }
        });
        registersTableView.refresh();
        dataMemoryTable.refresh();
        dataPathsWiresTableView.refresh();
    }
    public void setTableValuesToBinary () {
        registerValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        dataMemoryDataColumn.setCellValueFactory(new PropertyValueFactory<>("dataValue"));
        dataMemoryAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        wireValueDataPathsColumn.setCellValueFactory(new PropertyValueFactory<>("stringValue"));
        registersTableView.refresh();
        dataMemoryTable.refresh();
        dataPathsWiresTableView.refresh();
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
