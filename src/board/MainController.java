package board;

import assembler.Assembler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import units.InstructionMemory;
import units.Register;
import units.Wire;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    Assembler assembler;
    InstructionMemory instructionMemory;
    ObservableList<Wire> controlWires;
    ObservableList<Wire> dataPathsWires;
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
    @FXML ListView instructionsList;
    @FXML Button runButton;
    @FXML Button debugButton;
    private Thread t;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    assembler=new Assembler();
        try {
            assembler.assemble();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        instructionMemory = new InstructionMemory();
    instructionMemory.setInstructions(assembler.getInstructions());
    instructionMemory.setInitialLocation(assembler.getInitialLocation());
    CircuitController.injectInstructionMemory(instructionMemory);
    controlWires = Wire.initControlWires(CircuitController.getBooleanWires(),CircuitController.getStringWires());
    dataPathsWires = Wire.initDataPathsWires(CircuitController.getBooleanWires(),CircuitController.getStringWires());
    populateRegistersTable();
    populateWiresTable();
    populateInstructionsList();
    debugButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        }
    });

    runButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        CircuitController.process();
        populateRegistersTable();
        }
    });

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
