package board;

import assembler.Assembler;
<<<<<<< HEAD
import assembler.InstructionLine;
import javafx.beans.property.*;
=======
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import units.*;
import utils.MipsUtils;
import java.io.FileNotFoundException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Processor {
    private ArrayList<SVGPath> StringPaths;
    private ArrayList<SVGPath> UnitsPaths;
    private Map<SVGPath,BooleanProperty> booleanWires=new HashMap<>();
    private Map<Label,StringProperty> StringWires=new HashMap<>();


    //Units SVGPaths

=======
import java.net.URL;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class Processor implements Initializable{
    private static final String ZERO_ERROR = "CANNOT WRITE IN REGISTER ZERO!" ;
    private ArrayList<SVGPath> stringPaths;
    private ArrayList<SVGPath> unitsPaths;
    private Map<SVGPath,BooleanProperty> booleanWires=new HashMap<>();
    private Map<Label,StringProperty> stringWires =new HashMap<>();
   private ObservableList<Wire> wires = FXCollections.observableArrayList();



    //Units SVGPaths
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
    @FXML
    SVGPath BranchAdderPath;
    @FXML
    SVGPath BranchOrPath;
    @FXML
    SVGPath BranchMux2Path;
    @FXML
    SVGPath BNEAndPath;
    @FXML
    SVGPath BEQAndPath;
    @FXML
    SVGPath PCAdderPath;
    @FXML
    SVGPath BranchMux1Path;
    @FXML
    SVGPath MemMux1Path;
    @FXML
    SVGPath ShamtMuxPath;
    @FXML
    SVGPath MemMux2Path;
    @FXML
    SVGPath ALUSrcMuxPath;
    @FXML
    SVGPath WriteRegMuxPath;
    @FXML
    SVGPath RegWriteAndPath;
    @FXML
    SVGPath PCShifterPath;
    @FXML
    SVGPath BranchShifterPath;
    @FXML
    SVGPath ControllerPath;
    @FXML
    SVGPath RegMemPath;
    @FXML
    SVGPath InstructionMemPath;
    @FXML
    SVGPath ALUPath;
    @FXML
    SVGPath ALUControlPath;
    @FXML
    SVGPath NormalExtenderPath;
    @FXML
    SVGPath MemExtenderPath;
    @FXML
    SVGPath PCMuxPath;
    @FXML
    SVGPath PCPath;
<<<<<<< HEAD
=======
    @FXML
    SVGPath DataMemPath;
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc


    //StringPaths
    @FXML
    SVGPath ALUOpPath;
    @FXML
    SVGPath MemDataPath;
    @FXML
    SVGPath RegDstPath;
    @FXML
    SVGPath PCInputPath;
    @FXML
    SVGPath PCMuxInput0Path;
    @FXML
    SVGPath PCAdderOutputPath;
    @FXML
    SVGPath PCShifterOutputPath;
    @FXML
    SVGPath PCMuxInput1Path;
    @FXML
    SVGPath Adder4Path;
    @FXML
    SVGPath ALUInput2Path;
    @FXML
    SVGPath WriteRegPath;
    @FXML
    SVGPath MemExtenderOutputPath;
    @FXML
    SVGPath MemReadDataPath;
    @FXML
    SVGPath ShamtPath;
    @FXML
    SVGPath ALUControlOpPath;
    @FXML
    SVGPath RegReadData2Path;
    @FXML
    SVGPath MemMux1OutputPath;
    @FXML
    SVGPath RegWriteDataPath;
    @FXML
    SVGPath ALUOutputPath;
    @FXML
    SVGPath PCOutputPath;
    @FXML
    SVGPath PCShifterInputPath;
    @FXML
    SVGPath BranchShifterInputPath;
    @FXML
    SVGPath BranchAdderInput2Path;
    @FXML
    SVGPath BranchMux1OutputPath;
    @FXML
    SVGPath BranchAdderOutputPath;
    @FXML
    SVGPath Mux16Path;
    @FXML
    SVGPath ALUInput1Path;
    @FXML
    SVGPath JAL31Path;





    //BooleanWires and their SVGPaths
    @FXML
    SVGPath JumpPath;
<<<<<<< HEAD
    private BooleanProperty JumpWire = new SimpleBooleanProperty();
    @FXML
    SVGPath BNEPath;
    private BooleanProperty BNEWire = new SimpleBooleanProperty();
    @FXML
    SVGPath BEQPath;
    private BooleanProperty BEQWire = new SimpleBooleanProperty();
    @FXML
    SVGPath MemToRegPath;
    private BooleanProperty MemToRegWire = new SimpleBooleanProperty();
    @FXML
    SVGPath MemWritePath;
    private BooleanProperty MemWriteWire = new SimpleBooleanProperty();
    @FXML
    SVGPath ALUSrcPath;
    private BooleanProperty ALUSrcWire = new SimpleBooleanProperty();
    @FXML
    SVGPath UnsignedPath;
    private BooleanProperty UnsignedWire = new SimpleBooleanProperty();
    @FXML
    SVGPath LUIPath;
    private BooleanProperty LUIWire = new SimpleBooleanProperty();
    @FXML
    SVGPath MemReadPath;
    private BooleanProperty MemReadWire = new SimpleBooleanProperty();
    @FXML
    SVGPath RegWritePath;
    private BooleanProperty RegWriteWire = new SimpleBooleanProperty();
    @FXML
    SVGPath BranchMuxSelectorPath;
    private BooleanProperty BranchMuxSelectorWire = new SimpleBooleanProperty();
    @FXML
    SVGPath BranchOrInput1Path;
    private BooleanProperty BranchOrInput1Wire = new SimpleBooleanProperty();
    @FXML
    SVGPath BranchOrInput2Path;
    private BooleanProperty BranchOrInput2Wire = new SimpleBooleanProperty();
    @FXML
    SVGPath RegWriteAndOutputPath;
    private BooleanProperty RegWriteAndOutputWire = new SimpleBooleanProperty();
    @FXML
    SVGPath ALUZeroPath;
    private BooleanProperty ALUZeroWire = new SimpleBooleanProperty();
    @FXML
    SVGPath JRPath;
    private BooleanProperty JRWire = new SimpleBooleanProperty();
=======
    private BooleanProperty JumpWire = new SimpleBooleanProperty(true,"Jump");
    @FXML
    SVGPath BNEPath;
    private BooleanProperty BNEWire = new SimpleBooleanProperty(true,"BNE");
    @FXML
    SVGPath BEQPath;
    private BooleanProperty BEQWire = new SimpleBooleanProperty(true,"BEQ");
    @FXML
    SVGPath MemToRegPath;
    private BooleanProperty MemToRegWire = new SimpleBooleanProperty(true,"MemToReg");
    @FXML
    SVGPath MemWritePath;
    private BooleanProperty MemWriteWire = new SimpleBooleanProperty(true,"MemWrite");
    @FXML
    SVGPath ALUSrcPath;
    private BooleanProperty ALUSrcWire = new SimpleBooleanProperty(true,"ALUSrc");
    @FXML
    SVGPath UnsignedPath;
    private BooleanProperty UnsignedWire = new SimpleBooleanProperty(true,"Unsigned");
    @FXML
    SVGPath LUIPath;
    private BooleanProperty LUIWire = new SimpleBooleanProperty(true,"LUI");
    @FXML
    SVGPath MemReadPath;
    private BooleanProperty MemReadWire = new SimpleBooleanProperty(true,"MemRead");
    @FXML
    SVGPath RegWritePath;
    private BooleanProperty RegWriteWire = new SimpleBooleanProperty(true,"RegWrite");
    @FXML
    SVGPath BranchMuxSelectorPath;
    private BooleanProperty BranchMuxSelectorWire = new SimpleBooleanProperty(false,"BranchMuxSelectorWire");
    @FXML
    SVGPath BranchOrInput1Path;
    private BooleanProperty BranchOrInput1Wire = new SimpleBooleanProperty(false,"BranchOrInput1");
    @FXML
    SVGPath BranchOrInput2Path;
    private BooleanProperty BranchOrInput2Wire = new SimpleBooleanProperty(false,"BranchOrInput2");
    @FXML
    SVGPath RegWriteAndOutputPath;
    private BooleanProperty RegWriteAndOutputWire = new SimpleBooleanProperty(false,"RegWriteAndOutput");
    @FXML
    SVGPath ALUZeroPath;
    private BooleanProperty ALUZeroWire = new SimpleBooleanProperty(false,"ALUZero");
    @FXML
    SVGPath JRPath;
    private BooleanProperty JRWire = new SimpleBooleanProperty(true,"JR");
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc



    //StringProperties AND their Labels



    @FXML
    Label MemDataLabel;
<<<<<<< HEAD
    private StringProperty MemDataWire = new SimpleStringProperty();
    @FXML
    Label ALUOpLabel;
    private StringProperty ALUOpWire = new SimpleStringProperty();
    @FXML
    Label RegDstLabel;
    private StringProperty RegDstWire = new SimpleStringProperty();
    @FXML
    Label InstructionRsLabel;
    private StringProperty InstructionRsWire = new SimpleStringProperty();
    @FXML
    Label InstructionRtLabel;
    private StringProperty InstructionRtWire = new SimpleStringProperty();
    @FXML
    Label InstructionRdLabel;
    private StringProperty InstructionRdWire = new SimpleStringProperty();
    @FXML
    Label InstructionConstLabel;
    private StringProperty InstructionConstWire = new SimpleStringProperty();
    @FXML
    Label InstructionShamtLabel;
    private StringProperty InstructionShamtWire = new SimpleStringProperty();
    @FXML
    Label InstructionOpLabel;
    private StringProperty InstructionOpWire = new SimpleStringProperty();
    @FXML
    Label PCInputLabel;
    private StringProperty PCInputWire = new SimpleStringProperty();
    @FXML
    Label PCOutputLabel;
    private StringProperty PCOutputWire = new SimpleStringProperty();
    @FXML
    Label PCMuxIn1Label;
    private StringProperty PCMuxIn1Wire = new SimpleStringProperty();
    @FXML
    Label PCMuxIn0Label;
    private StringProperty PCMuxIn0Wire = new SimpleStringProperty();
    @FXML
    Label InstructionShiftLabel;
    private StringProperty InstructionShiftWire = new SimpleStringProperty();
    @FXML
    Label JumpAddressLabel;
    private StringProperty JumpAddressWire = new SimpleStringProperty();
    @FXML
    Label PCAdderOutLabel;
    private StringProperty PCAdderOutWire = new SimpleStringProperty();
    @FXML
    Label BranchAdderOutLabel;
    private StringProperty BranchAdderOutWire = new SimpleStringProperty();
    @FXML
    Label BranchMux1OutLabel;
    private StringProperty BranchMux1OutWire = new SimpleStringProperty();
    @FXML
    Label BranchShifterInLabel;
    private StringProperty BranchShifterInWire = new SimpleStringProperty();
    @FXML
    Label BranchShifterOutLabel;
    private StringProperty BranchShifterOutWire = new SimpleStringProperty();
    @FXML
    Label ALUControllerOutLabel;
    private StringProperty ALUControllerOutWire = new SimpleStringProperty();
    @FXML
    Label ShamtLabel;
    private StringProperty ShamtWire = new SimpleStringProperty();
    @FXML
    Label ALUResultLabel;
    private StringProperty ALUResultWire = new SimpleStringProperty();
    @FXML
    Label ALUIn1Label;
    private StringProperty ALUIn1Wire = new SimpleStringProperty();
    @FXML
    Label ALUIn2Label;
    private StringProperty ALUIn2Wire = new SimpleStringProperty();
    @FXML
    Label ExtenderOutLabel;
    private StringProperty ExtenderOutWire = new SimpleStringProperty();
    @FXML
    Label ExtenderMemOutLabel;
    private StringProperty ExtenderMemOutWire = new SimpleStringProperty();
    @FXML
    Label ReadDataReg1Label;
    private StringProperty ReadDataReg1Wire = new SimpleStringProperty();
    @FXML
    Label ReadDataReg2Label;
    private StringProperty ReadDataReg2Wire = new SimpleStringProperty();
    @FXML
    Label WriteDataRegLabel;
    private StringProperty WriteDataRegWire = new SimpleStringProperty();
    @FXML
    Label WriteRegLabel;
    private StringProperty WriteRegWire = new SimpleStringProperty();
    @FXML
    Label WriteDataMemLabel;
    private StringProperty WriteDataMemWire = new SimpleStringProperty();
    @FXML
    Label ReadDataMemLabel;
    private StringProperty ReadDataMemWire = new SimpleStringProperty();
    @FXML
    Label MemMux1OutLabel;
    private StringProperty MemMux1OutWire = new SimpleStringProperty();
    @FXML
    Label InstructionFnLabel;
    private StringProperty InstructionFnWire = new SimpleStringProperty();
=======
    private StringProperty MemDataWire = new SimpleStringProperty(true,"MemData");
    @FXML
    Label ALUOpLabel;
    private StringProperty ALUOpWire = new SimpleStringProperty(true,"ALUOp");
    @FXML
    Label RegDstLabel;
    private StringProperty RegDstWire = new SimpleStringProperty(true,"RegDst");
    @FXML
    Label InstructionRsLabel;
    private StringProperty InstructionRsWire = new SimpleStringProperty(false,"Instruction RS");
    @FXML
    Label InstructionRtLabel;
    private StringProperty InstructionRtWire = new SimpleStringProperty(false,"Instruction RT");
    @FXML
    Label InstructionRdLabel;
    private StringProperty InstructionRdWire = new SimpleStringProperty(false,"Instruction RD");
    @FXML
    Label InstructionConstLabel;
    private StringProperty InstructionConstWire = new SimpleStringProperty(false, "Instruction Const");
    @FXML
    Label InstructionShamtLabel;
    private StringProperty InstructionShamtWire = new SimpleStringProperty(false,"Instruction Shamt");
    @FXML
    Label InstructionOpLabel;
    private StringProperty InstructionOpWire = new SimpleStringProperty(false,"OpCode");
    @FXML
    Label PCInputLabel;
    private StringProperty PCInputWire = new SimpleStringProperty(false,"PCInput");
    @FXML
    Label PCOutputLabel;
    private StringProperty PCOutputWire = new SimpleStringProperty(false,"PCOutput");
    @FXML
    Label PCMuxIn1Label;
    private StringProperty PCMuxIn1Wire = new SimpleStringProperty(false,"PCMuxInput1");
    @FXML
    Label PCMuxIn0Label;
    private StringProperty PCMuxIn0Wire = new SimpleStringProperty(false,"PCMuxInput0");
    @FXML
    Label InstructionShiftLabel;
    private StringProperty InstructionShiftWire = new SimpleStringProperty(false,"InstructionShiftWire");
    @FXML
    Label JumpAddressLabel;
    private StringProperty JumpAddressWire = new SimpleStringProperty(false,"JumpAddress");
    @FXML
    Label PCAdderOutLabel;
    private StringProperty PCAdderOutWire = new SimpleStringProperty(false,"PCAdderOutput");
    @FXML
    Label BranchAdderOutLabel;
    private StringProperty BranchAdderOutWire = new SimpleStringProperty(false,"BranchAdderOutput");
    @FXML
    Label BranchMux1OutLabel;
    private StringProperty BranchMux1OutWire = new SimpleStringProperty(false,"BranchMux1Output");
    @FXML
    Label BranchShifterInLabel;
    private StringProperty BranchShifterInWire = new SimpleStringProperty(false,"BranchShifterInput");
    @FXML
    Label BranchShifterOutLabel;
    private StringProperty BranchShifterOutWire = new SimpleStringProperty(false,"BranchShifterOutput");
    @FXML
    Label ALUControllerOutLabel;
    private StringProperty ALUControllerOutWire = new SimpleStringProperty(true,"ALUControllerOutput");
    @FXML
    Label ShamtLabel;
    private StringProperty ShamtWire = new SimpleStringProperty(false,"Shamt");
    @FXML
    Label ALUResultLabel;
    private StringProperty ALUResultWire = new SimpleStringProperty(false,"ALUResult");
    @FXML
    Label ALUIn1Label;
    private StringProperty ALUIn1Wire = new SimpleStringProperty(false,"ALUInput1");
    @FXML
    Label ALUIn2Label;
    private StringProperty ALUIn2Wire = new SimpleStringProperty(false,"ALUInput2");
    @FXML
    Label ExtenderOutLabel;
    private StringProperty ExtenderOutWire = new SimpleStringProperty(false,"ImmediateExtenderOutput");
    @FXML
    Label ExtenderMemOutLabel;
    private StringProperty ExtenderMemOutWire = new SimpleStringProperty(false,"MemExtenderOutput");
    @FXML
    Label ReadDataReg1Label;
    private StringProperty ReadDataReg1Wire = new SimpleStringProperty(false,"Reg1ReadData");
    @FXML
    Label ReadDataReg2Label;
    private StringProperty ReadDataReg2Wire = new SimpleStringProperty(false,"Reg2ReadData");
    @FXML
    Label WriteDataRegLabel;
    private StringProperty WriteDataRegWire = new SimpleStringProperty(false,"RegWriteData");
    @FXML
    Label WriteRegLabel;
    private StringProperty WriteRegWire = new SimpleStringProperty(false,"WriteReg");
    @FXML
    Label WriteDataMemLabel;
    private StringProperty WriteDataMemWire = new SimpleStringProperty(false,"MemWriteData");
    @FXML
    Label ReadDataMemLabel;
    private StringProperty ReadDataMemWire = new SimpleStringProperty(false,"MemReadData");
    @FXML
    Label MemMux1OutLabel;
    private StringProperty MemMux1OutWire = new SimpleStringProperty(false,"MemMux1Output");
    @FXML
    Label InstructionFnLabel;
    private StringProperty InstructionFnWire = new SimpleStringProperty(false,"Instruction Fn");
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc



    //    units
<<<<<<< HEAD
    private Assembler assembler=new Assembler();
=======
    public InstructionMemory instructionMemory;
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
    private Controller controller=new Controller();
    private ALUController aluController=new ALUController();
    private Mux ALUMux=new Mux();
    private Mux ShamtMux=new Mux();
    private ALU alu=new ALU();
    private Mux WriteRegMux=new Mux();
    private RegMem regMem =new RegMem();
    private Extender extender=new Extender();
    private DataMemory dataMemory=new DataMemory();
    private Extender MemExtender=new Extender();
    private Adder PCAdder= new Adder();
    private ShiftLeft PCShifter=new ShiftLeft();
    private ShiftLeft BranchShifter=new ShiftLeft();
    private Adder BranchAdder=new Adder();
    private Mux BranchMux1= new Mux();
    private Mux BranchMux2=new Mux();
    private Mux PCMux=new Mux();
    private Mux MemMux1=new Mux();
    private Mux MemMux2=new Mux();

    //Variables
    private String instruction;
<<<<<<< HEAD
    private  String PCAddress= MipsUtils.extend32(Integer.toBinaryString(assembler.getInitialLocation()));
=======
    private  String PCAddress;
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
    private static int i;
    private boolean buttonPressed=false;
    private Thread t;

    public void process()  {


       // Integer.toBinaryString(Integer.parseInt(PCAddress,2)+4);
        PCInputWire.setValue(PCAddress);
        PCOutputWire.setValue(PCAddress);

        //Instruction Processing stages
        for(i=0;i<instructionMemory.getInstructions().size();i=methodRa23a()) {
            setButtonPressed(false);
            fetch();
            decode();
            excute();
            toMemory();
            setPC();
            try {
                writeBack();
            }  catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR,ZERO_ERROR, ButtonType.OK);
                alert.showAndWait();
                return;
            }
            System.out.println("INSTRUCTION:  "+i);
            printRegisters(); //for Testing
<<<<<<< HEAD
        }
    }

    private int methodRa23a() {
=======

        }
    }

    public int methodRa23a() {
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
        PCOutputWire.setValue(PCInputWire.getValue());
        return (Integer.parseUnsignedInt(PCOutputWire.getValue(),2)-Integer.parseUnsignedInt(PCAddress,2))/4;
    }

<<<<<<< HEAD
    private void fetch(){
        System.out.println("address: " + PCOutputWire.getValue());
        instruction= assembler.getInstructions().get(i).getCode();  //TODO get it from InstructionMem
=======
    public void fetch(){
        System.out.println("address: " + PCOutputWire.getValue());
        instruction= instructionMemory.getInstructions().get(i).getCode();
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
        //instructionWires
        InstructionOpWire.setValue(instruction.substring(0,6));
        InstructionRsWire.setValue(instruction.substring(6,11));
        InstructionRtWire.setValue(instruction.substring(11,16));
        InstructionRdWire.setValue(instruction.substring(16,21));
        InstructionConstWire.setValue(instruction.substring(16));
        InstructionShamtWire.setValue(instruction.substring(21,26));
        InstructionShiftWire.setValue(instruction.substring(6));
        InstructionFnWire.setValue(instruction.substring(26,32));
    }

<<<<<<< HEAD
    private void decode(){
=======
    public void decode()  {
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc


        //controller
        controller.setInput(MipsUtils.fromStringtoBoolean(InstructionOpWire.getValue()));
        controller.execute();
        JumpWire.set(controller.isJump());
        BNEWire.set(controller.isBne());
        BEQWire.set(controller.isBeq());
        MemToRegWire.set(controller.isMemToReg());
        UnsignedWire.set(controller.isUnsigned());
        MemWriteWire.set(controller.isMemWrite());
        MemReadWire.set(controller.isMemRead());
        ALUSrcWire.set(controller.isALUSrc());
        RegWriteWire.set(controller.isRegWrite());
        LUIWire.set(controller.isLui());
        MemDataWire.setValue(MipsUtils.fromBooleantoString(controller.getMemData()));
        ALUOpWire.setValue(MipsUtils.fromBooleantoString(controller.getAluOp()));
        RegDstWire.setValue(MipsUtils.fromBooleantoString(controller.getRegDst()));

        //WriteRegMux
        WriteRegMux.set3Inputs(InstructionRtWire.getValue(),Integer.toBinaryString(31),InstructionRdWire.getValue(),controller.getRegDst());
        WriteRegWire.setValue(WriteRegMux.getOutput());

        //RegMem
<<<<<<< HEAD
        regMem.read(InstructionRsWire.getValue(),InstructionRtWire.getValue(),WriteRegWire.getValue());
=======

            regMem.read(InstructionRsWire.getValue(),InstructionRtWire.getValue(),WriteRegWire.getValue());

>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
        ReadDataReg1Wire.setValue(regMem.getReadData1());
        ReadDataReg2Wire.setValue(regMem.getReadData2());

        //Extender
        extender.setInput(InstructionConstWire.getValue());
        ExtenderOutWire.setValue(extender.getOutput());
    }
<<<<<<< HEAD

    private void excute(){
=======
    public void excute(){
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
        //ALUController
        ALUOpWire.setValue(MipsUtils.fromBooleantoString(controller.getAluOp()));
        aluController.setInputs(controller.getAluOp(),MipsUtils.fromStringtoBoolean(InstructionFnWire.getValue()));
        ALUControllerOutWire.setValue(MipsUtils.fromBooleantoString(aluController.getOp()));
        JRWire.setValue(aluController.getJr());

        //ALUMux
        ALUMux.set2Inputs(ReadDataReg2Wire.getValue(),ExtenderOutWire.getValue(),ALUSrcWire.get());
        ALUIn2Wire.setValue(ALUMux.getOutput());

        //ShamtMux
        ShamtMux.set2Inputs(InstructionShamtWire.getValue(),"00000000000000000000000000010000",LUIWire.get());
        ShamtWire.setValue(ShamtMux.getOutput());

        //alu
<<<<<<< HEAD
        ALUIn1Wire=ReadDataReg1Wire;
=======
        ALUIn1Wire.setValue(ReadDataReg1Wire.getValue());
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
        alu.setInputs(ALUControllerOutWire.getValue(),ALUIn1Wire.getValue(),ALUIn2Wire.getValue(),ShamtWire.getValue());
        ALUZeroWire.setValue(alu.getZeroFlag());
        ALUResultWire.setValue(alu.getOutput());
    }
<<<<<<< HEAD

    private void toMemory(){
=======
    public void toMemory(){
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
        //DataMemory
        WriteDataMemWire.setValue(ReadDataReg2Wire.getValue());

        dataMemory.setAddress(ALUResultWire.getValue());
        dataMemory.injectFlags(MemWriteWire.get(),MemReadWire.get(),MemDataWire.getValue());
        dataMemory.setDataToWrite(WriteDataMemWire.getValue());
        dataMemory.execute();
        ReadDataMemWire.setValue(dataMemory.getDataRead());

        //MemExtender
        MemExtender.setInput(ReadDataMemWire.getValue(),UnsignedWire.get());
        ExtenderMemOutWire.setValue(MemExtender.getOutput());
    }
<<<<<<< HEAD

    private void setPC(){
=======
    public void setPC(){
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
        //PCAdder
        PCAdder.setInputs(PCOutputWire.getValue());
        PCAdderOutWire.setValue(PCAdder.getOutput());

        //PCShifter
        PCShifter.setInput(InstructionShiftWire.getValue());
        JumpAddressWire.setValue(PCAdderOutWire.getValue().substring(0,4)+PCShifter.getOutput());

        //BranchShifter
        BranchShifterInWire.setValue(ExtenderOutWire.getValue());
        BranchShifter.setInput(BranchShifterInWire.getValue());
        BranchShifterOutWire.setValue(BranchShifter.getOutput());

        //BranchAdder
        BranchAdder.setInputs(PCAdderOutWire.getValue(),BranchShifterOutWire.getValue());
        BranchAdderOutWire.setValue(BranchAdder.getOutput());

        //BranchMux1
        BranchOrInput1Wire.setValue(BNEWire.getValue()&&!ALUZeroWire.getValue());
        BranchOrInput2Wire.setValue(BEQWire.getValue()&&ALUZeroWire.getValue());
        BranchMuxSelectorWire.setValue(BranchOrInput1Wire.getValue()||BranchOrInput2Wire.getValue());
        BranchMux1.set2Inputs(PCAdderOutWire.getValue(),BranchAdderOutWire.getValue(),BranchMuxSelectorWire.getValue());
        BranchMux1OutWire.setValue(BranchMux1.getOutput());

        //BranchMux2
        BranchMux2.set2Inputs(BranchMux1OutWire.getValue(),JumpAddressWire.getValue(),JumpWire.get());

        //PCMux
        PCMuxIn0Wire.setValue(BranchMux2.getOutput());
        PCMuxIn1Wire.setValue(ReadDataReg1Wire.getValue());
        PCMux.set2Inputs(PCMuxIn0Wire.getValue(),PCMuxIn1Wire.getValue(),JRWire.get());
        PCInputWire.setValue(PCMux.getOutput());
    }
<<<<<<< HEAD

    private void writeBack(){
=======
    public void writeBack() throws Exception {
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
        //MemMux1
        MemMux1.set2Inputs(ALUResultWire.getValue(),ExtenderMemOutWire.getValue(),MemToRegWire.get());
        MemMux1OutWire.setValue(MemMux1.getOutput());

        //MemMux2
        PCAdderOutWire.setValue(PCAdderOutWire.getValue());
        MemMux2.set2Inputs(MemMux1OutWire.getValue(),PCAdderOutWire.getValue(),MipsUtils.fromStringtoBoolean(RegDstWire.getValue())[0]);

        //regMem
        WriteDataRegWire.setValue(MemMux2.getOutput());
        RegWriteAndOutputWire.setValue(!JRWire.getValue()&&RegWriteWire.getValue());
        regMem.write(RegWriteAndOutputWire.get(),WriteDataRegWire.getValue());
    }
    public void printRegisters(){ //TESTING METHOD
        regMem.printRegisters();
    }
<<<<<<< HEAD

    private void initialize(){
        setBooleanWires();
        setStringWires();
        setStringPaths();
        setUnitsPaths();
    }

    private void setStringPaths() {
        StringPaths=new ArrayList<>(Arrays.asList(JAL31Path,ALUInput1Path,ALUOpPath,BranchShifterInputPath,BranchMux1OutputPath,BranchAdderOutputPath,Mux16Path,ALUOutputPath,PCOutputPath,BranchAdderInput2Path,MemExtenderOutputPath,MemReadDataPath,ShamtPath,ALUControlOpPath,RegReadData2Path,MemMux1OutputPath,RegWriteDataPath,Adder4Path,ALUInput2Path,WriteRegPath,MemDataPath,RegDstPath,PCInputPath,PCMuxInput0Path,PCMuxInput1Path,PCAdderOutputPath,PCShifterInputPath,PCShifterOutputPath));
    }

    private void setUnitsPaths() {
        UnitsPaths=new ArrayList<>(Arrays.asList(BranchMux1Path,BranchOrPath,BranchMux2Path,BNEAndPath,BEQAndPath,PCAdderPath,ShamtMuxPath,RegMemPath,ControllerPath,BranchShifterPath,RegWriteAndPath,PCShifterPath,WriteRegMuxPath,ALUSrcMuxPath,MemMux1Path,MemMux2Path,BranchAdderPath,PCPath,PCMuxPath,MemExtenderPath,NormalExtenderPath,ALUControlPath,ALUPath,InstructionMemPath));
=======
    private void setStringPaths() {
        stringPaths=new ArrayList<>(Arrays.asList(
                JAL31Path,ALUInput1Path,ALUOpPath,BranchShifterInputPath,BranchMux1OutputPath,BranchAdderOutputPath,
                Mux16Path,ALUOutputPath,PCOutputPath,BranchAdderInput2Path,MemExtenderOutputPath,MemReadDataPath,ShamtPath,ALUControlOpPath,
                RegReadData2Path,MemMux1OutputPath,RegWriteDataPath,Adder4Path,ALUInput2Path,WriteRegPath,MemDataPath,RegDstPath,PCInputPath,
                PCMuxInput0Path,PCMuxInput1Path,PCAdderOutputPath,PCShifterInputPath,PCShifterOutputPath
        ));
    }

    private void setUnitsPaths() {
        unitsPaths=new ArrayList<>(Arrays.asList(
                BranchMux1Path,BranchOrPath,BranchMux2Path,BNEAndPath,BEQAndPath,PCAdderPath,ShamtMuxPath,RegMemPath,
                ControllerPath,BranchShifterPath,RegWriteAndPath,PCShifterPath,WriteRegMuxPath,ALUSrcMuxPath,MemMux1Path,MemMux2Path,BranchAdderPath,
                PCPath,PCMuxPath,MemExtenderPath,NormalExtenderPath,ALUControlPath,ALUPath,InstructionMemPath,DataMemPath
        ));
>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
    }

    private void setBooleanWires(){
        booleanWires.put(JumpPath,JumpWire);
        booleanWires.put(BNEPath,BNEWire);
        booleanWires.put(BEQPath,BEQWire);
        booleanWires.put(MemToRegPath,MemToRegWire);
        booleanWires.put(MemWritePath,MemWriteWire);
        booleanWires.put(ALUSrcPath,ALUSrcWire);
        booleanWires.put(UnsignedPath,UnsignedWire);
        booleanWires.put(LUIPath,LUIWire);
        booleanWires.put(MemReadPath,MemReadWire);
        booleanWires.put(RegWritePath,RegWriteWire);
        booleanWires.put(BranchMuxSelectorPath,BranchMuxSelectorWire);
        booleanWires.put(BranchOrInput1Path,BranchOrInput1Wire);
        booleanWires.put(BranchOrInput2Path,BranchOrInput2Wire);
        booleanWires.put(RegWriteAndOutputPath,RegWriteAndOutputWire);
        booleanWires.put(ALUZeroPath,ALUZeroWire);
        booleanWires.put(JRPath,JRWire);
    }

    private void setStringWires() {
<<<<<<< HEAD
        StringWires.put(MemDataLabel,MemDataWire);
        StringWires.put(ALUOpLabel,ALUOpWire);
        StringWires.put(RegDstLabel,RegDstWire);
        StringWires.put(InstructionRsLabel,InstructionRsWire);
        StringWires.put(InstructionRtLabel,InstructionRtWire);
        StringWires.put(InstructionRdLabel,InstructionRdWire);
        StringWires.put(InstructionShamtLabel,InstructionShamtWire);
        StringWires.put(InstructionOpLabel,InstructionOpWire);
        StringWires.put(InstructionConstLabel,InstructionConstWire);
        StringWires.put(PCInputLabel,PCInputWire);
        StringWires.put(PCOutputLabel,PCInputWire);
        StringWires.put(PCMuxIn1Label,PCMuxIn1Wire);
        StringWires.put(PCMuxIn0Label,PCMuxIn0Wire);
        StringWires.put(InstructionShiftLabel,InstructionShiftWire);
        StringWires.put(JumpAddressLabel,JumpAddressWire);
        StringWires.put(PCAdderOutLabel,PCAdderOutWire);
        StringWires.put(BranchAdderOutLabel,BranchAdderOutWire);
        StringWires.put(BranchMux1OutLabel,BranchMux1OutWire);
        StringWires.put(BranchShifterInLabel,BranchShifterInWire);
        StringWires.put(BranchShifterOutLabel,BranchShifterOutWire);
        StringWires.put(ALUControllerOutLabel,ALUControllerOutWire);
        StringWires.put(ShamtLabel,ShamtWire);
        StringWires.put(ALUResultLabel,ALUResultWire);
        StringWires.put(ALUIn1Label,ALUIn1Wire);
        StringWires.put(ALUIn2Label,ALUIn2Wire);
        StringWires.put(ExtenderOutLabel,ExtenderOutWire);
        StringWires.put(ExtenderMemOutLabel,ExtenderMemOutWire);
        StringWires.put(ReadDataReg1Label,ReadDataReg1Wire);
        StringWires.put(ReadDataReg2Label,ReadDataReg2Wire);
        StringWires.put(WriteDataRegLabel,WriteDataRegWire);
        StringWires.put(WriteRegLabel,WriteRegWire);
        StringWires.put(WriteDataMemLabel,WriteDataMemWire);
        StringWires.put(ReadDataMemLabel,ReadDataMemWire);
        StringWires.put(MemMux1OutLabel,MemMux1OutWire);
        StringWires.put(InstructionFnLabel,InstructionFnWire);

    }


    private void addListeners(){

    }

}

=======
        stringWires.put(MemDataLabel,MemDataWire);
        stringWires.put(ALUOpLabel,ALUOpWire);
        stringWires.put(RegDstLabel,RegDstWire);
        stringWires.put(InstructionRsLabel,InstructionRsWire);
        stringWires.put(InstructionRtLabel,InstructionRtWire);
        stringWires.put(InstructionRdLabel,InstructionRdWire);
        stringWires.put(InstructionFnLabel,InstructionFnWire);
        stringWires.put(InstructionShamtLabel,InstructionShamtWire);
        stringWires.put(InstructionOpLabel,InstructionOpWire);
        stringWires.put(InstructionConstLabel,InstructionConstWire);
        stringWires.put(PCInputLabel,PCInputWire);
        stringWires.put(PCOutputLabel,PCInputWire);
        stringWires.put(PCMuxIn1Label,PCMuxIn1Wire);
        stringWires.put(PCMuxIn0Label,PCMuxIn0Wire);
        stringWires.put(InstructionShiftLabel,InstructionShiftWire);
        stringWires.put(JumpAddressLabel,JumpAddressWire);
        stringWires.put(PCAdderOutLabel,PCAdderOutWire);
        stringWires.put(BranchAdderOutLabel,BranchAdderOutWire);
        stringWires.put(BranchMux1OutLabel,BranchMux1OutWire);
        stringWires.put(BranchShifterInLabel,BranchShifterInWire);
        stringWires.put(BranchShifterOutLabel,BranchShifterOutWire);
        stringWires.put(ALUControllerOutLabel,ALUControllerOutWire);
        stringWires.put(ShamtLabel,ShamtWire);
        stringWires.put(ALUResultLabel,ALUResultWire);
        stringWires.put(ALUIn1Label,ALUIn1Wire);
        stringWires.put(ALUIn2Label,ALUIn2Wire);
        stringWires.put(ExtenderOutLabel,ExtenderOutWire);
        stringWires.put(ExtenderMemOutLabel,ExtenderMemOutWire);
        stringWires.put(ReadDataReg1Label,ReadDataReg1Wire);
        stringWires.put(ReadDataReg2Label,ReadDataReg2Wire);
        stringWires.put(WriteDataRegLabel,WriteDataRegWire);
        stringWires.put(WriteRegLabel,WriteRegWire);
        stringWires.put(WriteDataMemLabel,WriteDataMemWire);
        stringWires.put(ReadDataMemLabel,ReadDataMemWire);
        stringWires.put(MemMux1OutLabel,MemMux1OutWire);


    }


    private void addListeners(){
        booleanWires.forEach((SVGPath svgPath, BooleanProperty booleanProperty)->booleanProperty.addListener((observable, oldValue, newValue) -> {
                    if (newValue) {
                        svgPath.setId("onWire");
                    } else {
                        svgPath.setId("offWire");
                    }
                }));
        unitsPaths.forEach(svgPath -> svgPath.setId("units"));
//        stringWires.forEach((label, stringProperty) -> stringProperty.addListener(((observable, oldValue, newValue) -> {
//            label.setText(String.valueOf(Integer.parseInt(newValue,2)));
//        })));
    }
    private void flushWires(){
        booleanWires.forEach((SVGPath svgPath, BooleanProperty booleanProperty)->booleanProperty.setValue(true));
        booleanWires.forEach((SVGPath svgPath, BooleanProperty booleanProperty)->booleanProperty.setValue(false));

//        stringWires.forEach((label, stringProperty) -> {
//            stringProperty.setValue("11111");
//        });
    }



    public void injectInstructionMemory(InstructionMemory instructionMemory) {
        this.instructionMemory = instructionMemory;
        PCAddress = MipsUtils.extend32(Integer.toBinaryString(instructionMemory.getInitialLocation()));

    }

    public Map<SVGPath, BooleanProperty> getBooleanWires() {
        return booleanWires;
    }

    public Map<Label, StringProperty> getStringWires() {
        return stringWires;
    }

    public ObservableList getRegisters() {
        return regMem.getRegisters();
    }

    public void setButtonPressed(boolean buttonPressed) {
        this.buttonPressed = buttonPressed;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBooleanWires();
        setStringWires();
        setStringPaths();
        setUnitsPaths();
        addListeners();
        flushWires();
    }


}

>>>>>>> 41e9e7c1ef21a2870401dd6c82cff2d2314ca0fc
