package board;

import assembler.Assembler;
import assembler.InstructionLine;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import units.*;
import utils.MipsUtils;

import java.io.FileNotFoundException;

public class Processor {
    @FXML SVGPath Jump;
    BooleanProperty JumpWire=new SimpleBooleanProperty();
    @FXML SVGPath BNE;
    BooleanProperty BNEWire=new SimpleBooleanProperty();
    @FXML SVGPath BEQ;
    BooleanProperty BEQWire=new SimpleBooleanProperty();
    @FXML SVGPath MemToReg;
    BooleanProperty MemToRegWire=new SimpleBooleanProperty();
    @FXML SVGPath MemData;
    @FXML SVGPath MemWrite;
    BooleanProperty MemWriteWire=new SimpleBooleanProperty();
    @FXML SVGPath ALUSrc;
    BooleanProperty ALUSrcWire=new SimpleBooleanProperty();
    @FXML SVGPath Unsigned;
    BooleanProperty UnsignedWire=new SimpleBooleanProperty();
    @FXML SVGPath RegDst;
    @FXML SVGPath LUI;
    BooleanProperty LUIWire=new SimpleBooleanProperty();
    @FXML SVGPath MemRead;
    BooleanProperty MemReadWire=new SimpleBooleanProperty();
    @FXML SVGPath ALUOp;
    @FXML SVGPath RegWrite;
    BooleanProperty RegWriteWire=new SimpleBooleanProperty();
    @FXML SVGPath PCInput;
    @FXML SVGPath PCMuxInput0;
    @FXML SVGPath PCAdderOutput;
    @FXML SVGPath PCShifterOutput;
    @FXML SVGPath PCMuxInput1;
    @FXML SVGPath BranchMuxSelector;
    BooleanProperty BranchMuxSelectorWire=new SimpleBooleanProperty();
    @FXML SVGPath BranchOrInput1;
    BooleanProperty BranchOrInput1Wire=new SimpleBooleanProperty();
    @FXML SVGPath BranchOrInput2;
    BooleanProperty BranchOrInput2Wire=new SimpleBooleanProperty();
    @FXML SVGPath Adder4;
    @FXML SVGPath ALUInput2;
    @FXML SVGPath WriteReg;
    @FXML SVGPath RegWriteAndOutput;
    BooleanProperty RegWriteAndOutputWire=new SimpleBooleanProperty();
    @FXML SVGPath MemExtenderOutput;
    @FXML SVGPath MemReadData;
    @FXML SVGPath Shamt;
    @FXML SVGPath ALUControlOp;
    @FXML SVGPath RegReadData2;
    @FXML SVGPath ALUZero;
    BooleanProperty ALUZeroWire=new SimpleBooleanProperty();
    @FXML SVGPath MemMux1Output;
    @FXML SVGPath RegWriteData;
    @FXML SVGPath ALUOutput;
    @FXML SVGPath PCOutput;
    @FXML SVGPath JR;
    BooleanProperty JRWire=new SimpleBooleanProperty();
    @FXML SVGPath PCShifterInput;
    @FXML SVGPath BranchShifterInput;
    @FXML SVGPath BranchAdderInput2;
    @FXML SVGPath BranchMux1Output;
    @FXML SVGPath BranchAdderOutput;
    @FXML SVGPath Mux16;
    @FXML Label MemDataString;
    StringProperty MemDataStringWire=new SimpleStringProperty();
    @FXML Label ALUOpString;
    StringProperty ALUOpStringWire=new SimpleStringProperty();
    @FXML Label RegDstString;
    StringProperty RegDstStringWire=new SimpleStringProperty();
    @FXML Label InstructionRs;
    StringProperty InstructionRsWire=new SimpleStringProperty();
    @FXML Label InstructionRt;
    StringProperty InstructionRtWire=new SimpleStringProperty();
    @FXML Label InstructionRd;
    StringProperty InstructionRdWire=new SimpleStringProperty();
    @FXML Label InstructionConst;
    StringProperty InstructionConstWire=new SimpleStringProperty();
    @FXML Label InstructionShamt;
    StringProperty InstructionShamtWire=new SimpleStringProperty();
    @FXML Label InstructionOp;
    StringProperty InstructionOpWire=new SimpleStringProperty();
    @FXML Label PCInputString;
    StringProperty PCInputStringWire=new SimpleStringProperty();
    @FXML Label PCOutputString;
    StringProperty PCOutputStringWire=new SimpleStringProperty();
    @FXML Label PCMuxIn1;
    StringProperty PCMuxIn1Wire=new SimpleStringProperty();
    @FXML Label PCMuxIn0;
    StringProperty PCMuxIn0Wire=new SimpleStringProperty();
    @FXML Label InstructionShift;
    StringProperty InstructionShiftWire=new SimpleStringProperty();
    @FXML Label JumpAddress;
    StringProperty JumpAddressWire=new SimpleStringProperty();
    @FXML Label PCAdderOut;
    StringProperty PCAdderOutWire=new SimpleStringProperty();
    @FXML Label BranchAdderOut;
    StringProperty BranchAdderOutWire=new SimpleStringProperty();
    @FXML Label BranchMux1Out;
    StringProperty BranchMux1OutWire=new SimpleStringProperty();
    @FXML Label BranchShifterIn;
    StringProperty BranchShifterInWire=new SimpleStringProperty();
    @FXML Label BranchShifterOut;
    StringProperty BranchShifterOutWire=new SimpleStringProperty();
    @FXML Label ALUControllerOut;
    StringProperty ALUControllerOutWire=new SimpleStringProperty();
    @FXML Label ShamtString;
    StringProperty ShamtStringWire=new SimpleStringProperty();
    @FXML Label ALUResult;
    StringProperty ALUResultWire=new SimpleStringProperty();
    @FXML Label ALUIn1;
    StringProperty ALUIn1Wire=new SimpleStringProperty();
    @FXML Label ALUIn2;
    StringProperty ALUIn2Wire=new SimpleStringProperty();
    @FXML Label ExtenderOut;
    StringProperty ExtenderOutWire=new SimpleStringProperty();
    @FXML Label ExtenderMemOut;
    StringProperty ExtenderMemOutWire=new SimpleStringProperty();
    @FXML Label ReadDataReg1;
    StringProperty ReadDataReg1Wire=new SimpleStringProperty();
    @FXML Label ReadDataReg2;
    StringProperty ReadDataReg2Wire=new SimpleStringProperty();
    @FXML Label WriteDataReg;
    StringProperty WriteDataRegWire=new SimpleStringProperty();
    @FXML Label WriteRegLabel;
    StringProperty WriteRegStringWire=new SimpleStringProperty();
    @FXML Label WriteDataMem;
    StringProperty WriteDataMemWire=new SimpleStringProperty();
    @FXML Label ReadDataMem;
    private StringProperty ReadDataMemWire=new SimpleStringProperty();
    @FXML Label MemMux1Out;
    private StringProperty MemMux1OutWire=new SimpleStringProperty();
    @FXML Label PCAdderOutt;
    @FXML Label InstructionFn;
    StringProperty InstructionFnWire=new SimpleStringProperty();

//    units
    private Assembler Assembler=new Assembler();
    private Controller Controller=new Controller();
    private ALUController ALUController=new ALUController();
    private Mux ALUMux=new Mux();
    private Mux ShamtMux=new Mux();
    private ALU ALU=new ALU();
    private Mux WriteRegMux=new Mux();
    private RegMem RegMem =new RegMem();
    private Extender Extender=new Extender();
    private DataMemory DataMemory=new DataMemory();
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
    private  String PCAddress= MipsUtils.extend32(Integer.toBinaryString(Assembler.getInitialLocation()));
    private static int i;

    public void process() throws FileNotFoundException {
        Assembler.assemble();
        //Integer.toBinaryString(Integer.parseInt(PCAddress,2)+4)
        PCInputStringWire.setValue(PCAddress);
        PCOutputStringWire.setValue(PCAddress);
        for(i=0;i<Assembler.getInstructions().size();i=methodRa23a()) {
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
        PCOutputStringWire.setValue(PCInputStringWire.getValue());
        return (Integer.parseUnsignedInt(PCOutputStringWire.getValue(),2)-Integer.parseUnsignedInt(PCAddress,2))/4;
    }

    private void fetch(){
        System.out.println("address: " + PCOutputStringWire.getValue());
        instruction= Assembler.getInstructions().get(i).getCode();  //TODO get it from InstructionMem
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
        Controller.setInput(MipsUtils.fromStringtoBoolean(InstructionOpWire.getValue()));
        Controller.execute();
        JumpWire.set(Controller.isJump());
        BNEWire.set(Controller.isBne());
        BEQWire.set(Controller.isBeq());
        MemToRegWire.set(Controller.isMemToReg());
        UnsignedWire.set(Controller.isUnsigned());
        MemWriteWire.set(Controller.isMemWrite());
        MemReadWire.set(Controller.isMemRead());
        ALUSrcWire.set(Controller.isALUSrc());
        RegWriteWire.set(Controller.isRegWrite());
        LUIWire.set(Controller.isLui());
        MemDataStringWire.setValue(MipsUtils.fromBooleantoString(Controller.getMemData()));
        ALUOpStringWire.setValue(MipsUtils.fromBooleantoString(Controller.getAluOp()));
        RegDstStringWire.setValue(MipsUtils.fromBooleantoString(Controller.getRegDst()));

        //WriteRegMux
        WriteRegMux.set3Inputs(InstructionRtWire.getValue(),Integer.toBinaryString(31),InstructionRdWire.getValue(),Controller.getRegDst());
        WriteRegStringWire.setValue(WriteRegMux.getOutput());

        //RegMem
        RegMem.read(InstructionRsWire.getValue(),InstructionRtWire.getValue(),WriteRegStringWire.getValue());
        ReadDataReg1Wire.setValue(RegMem.getReadData1());
        ReadDataReg2Wire.setValue(RegMem.getReadData2());

        //Extender
        Extender.setInput(InstructionConstWire.getValue());
        ExtenderOutWire.setValue(Extender.getOutput());
    }

    private void excute(){
        //ALUController
        ALUOpStringWire.setValue(MipsUtils.fromBooleantoString(Controller.getAluOp()));
        ALUController.setInputs(Controller.getAluOp(),MipsUtils.fromStringtoBoolean(InstructionFnWire.getValue()));
        ALUControllerOutWire.setValue(MipsUtils.fromBooleantoString(ALUController.getOp()));
        JRWire.setValue(ALUController.getJr());

        //ALUMux
        ALUMux.set2Inputs(ReadDataReg2Wire.getValue(),ExtenderOutWire.getValue(),ALUSrcWire.get());
        ALUIn2Wire.setValue(ALUMux.getOutput());

        //ShamtMux
        ShamtMux.set2Inputs(InstructionShamtWire.getValue(),"00000000000000000000000000010000",LUIWire.get());
        ShamtStringWire.setValue(ShamtMux.getOutput());

        //ALU
        ALUIn1Wire=ReadDataReg1Wire;
        ALU.setInputs(ALUControllerOutWire.getValue(),ALUIn1Wire.getValue(),ALUIn2Wire.getValue(),ShamtStringWire.getValue());
        ALUZeroWire.setValue(ALU.getZeroFlag());
        ALUResultWire.setValue(ALU.getOutput());
    }

    private void toMemory(){
        //DataMemory
        WriteDataMemWire.setValue(ReadDataReg2Wire.getValue());
        DataMemory.setAddress(ALUResultWire.getValue());
        DataMemory.injectFlags(MemWriteWire.get(),MemReadWire.get(),MemDataStringWire.getValue());
        DataMemory.setDataToWrite(WriteDataMemWire.getValue());
        DataMemory.execute();
        ReadDataMemWire.setValue(DataMemory.getDataRead());

        //MemExtender
        MemExtender.setInput(ReadDataMemWire.getValue(),UnsignedWire.get());
        ExtenderMemOutWire.setValue(MemExtender.getOutput());
    }

    private void setPC(){
        //PCAdder
        PCAdder.setInputs(PCOutputStringWire.getValue());
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
        PCInputStringWire.setValue(PCMux.getOutput());
    }

    private void writeBack(){
        //MemMux1
        MemMux1.set2Inputs(ALUResultWire.getValue(),ExtenderMemOutWire.getValue(),MemToRegWire.get());
        MemMux1OutWire.setValue(MemMux1.getOutput());

        //MemMux2
        PCAdderOutWire.setValue(PCAdderOutWire.getValue());
        MemMux2.set2Inputs(MemMux1OutWire.getValue(),PCAdderOutWire.getValue(),MipsUtils.fromStringtoBoolean(RegDstStringWire.getValue())[0]);

        //RegMem
        WriteDataRegWire.setValue(MemMux2.getOutput());
        RegWriteAndOutputWire.setValue(!JRWire.getValue()&&RegWriteWire.getValue());
        RegMem.write(RegWriteAndOutputWire.get(),WriteDataRegWire.getValue());
    }
    public void printRegisters(){ //TESTING METHOD
        RegMem.printRegisters();
    }
    private void addListeners(){

    }

}

