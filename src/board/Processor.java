package board;

import assembler.Assembler;
import assembler.InstructionLine;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import units.*;
import utils.MipsUtils;
import java.io.FileNotFoundException;
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



    //StringProperties AND their Labels



    @FXML
    Label MemDataLabel;
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



    //    units
    private Assembler assembler=new Assembler();
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
    private  String PCAddress= MipsUtils.extend32(Integer.toBinaryString(assembler.getInitialLocation()));
    private static int i;

    public void process() throws FileNotFoundException {

        //initializing the ArrayLists and Maps
        initialize();

        assembler.assemble();
        //Integer.toBinaryString(Integer.parseInt(PCAddress,2)+4)
        PCInputWire.setValue(PCAddress);
        PCOutputWire.setValue(PCAddress);

        //Instruction Processing stages
        for(i=0;i<assembler.getInstructions().size();i=methodRa23a()) {
            fetch();
            decode();
            excute();
            toMemory();
            setPC();
            writeBack();
            System.out.println("INSTRUCTION:  "+i);
            printRegisters(); //for Testing
        }
    }

    private int methodRa23a() {
        PCOutputWire.setValue(PCInputWire.getValue());
        return (Integer.parseUnsignedInt(PCOutputWire.getValue(),2)-Integer.parseUnsignedInt(PCAddress,2))/4;
    }

    private void fetch(){
        System.out.println("address: " + PCOutputWire.getValue());
        instruction= assembler.getInstructions().get(i).getCode();  //TODO get it from InstructionMem
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

    private void decode(){


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
        regMem.read(InstructionRsWire.getValue(),InstructionRtWire.getValue(),WriteRegWire.getValue());
        ReadDataReg1Wire.setValue(regMem.getReadData1());
        ReadDataReg2Wire.setValue(regMem.getReadData2());

        //Extender
        extender.setInput(InstructionConstWire.getValue());
        ExtenderOutWire.setValue(extender.getOutput());
    }

    private void excute(){
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
        ALUIn1Wire=ReadDataReg1Wire;
        alu.setInputs(ALUControllerOutWire.getValue(),ALUIn1Wire.getValue(),ALUIn2Wire.getValue(),ShamtWire.getValue());
        ALUZeroWire.setValue(alu.getZeroFlag());
        ALUResultWire.setValue(alu.getOutput());
    }

    private void toMemory(){
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

    private void setPC(){
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

    private void writeBack(){
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

