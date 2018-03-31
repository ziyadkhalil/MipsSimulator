package assembler.instsruction;

import assembler.instsruction.FormatType;
import assembler.instsruction.Instruction;

import java.util.ArrayList;
import java.util.Arrays;

import static assembler.instsruction.FormatType.*;

public class IInstruction extends Instruction {
    private final ArrayList<String> I_INSTRUCTION_ARITHMETIC_TYPE=new ArrayList<>(Arrays.asList("addi","sltui","slti","lui","ori","andi"));
    private final ArrayList<String> I_INSTRUCTION_ARITHMETIC_OP_CODE=new ArrayList<>(Arrays.asList("001000","001011","001010","001111","001101","001100"));

    private final ArrayList<String> I_INSTRUCTION_FLOW_CONTROL_TYPE=new ArrayList<>(Arrays.asList("beq","bne"));
    private final ArrayList<String> I_INSTRUCTION_FLOW_CONTROL_OP_CODE=new ArrayList<>(Arrays.asList("000100","000101"));

    private final ArrayList<String> I_INSTRUCTION_LOAD_STORE_TYPE=new ArrayList<>(Arrays.asList("lw","sw","lh","lhu","sh","lb","lbu","sb"));
    private final ArrayList<String> I_INSTRUCTION_LOAD_OP_CODE=new ArrayList<>(Arrays.asList("100011","101011","100001","100101","101001","100000","100100","101000"));

    private FormatType format;
    private String opCode;



    public IInstruction(String name) {
        super(name);
        this.setFormatType();
        this.setOpCode();

    }

    @Override
    public FormatType getFormatType() {
        return format;
    }

    @Override
    public String getOpCode() {
        return opCode;

    }

    @Override
    public void setFormatType() {
        if(I_INSTRUCTION_ARITHMETIC_TYPE.contains(this.toString()))
            format =I_ARITHMETIC;
        if(I_INSTRUCTION_LOAD_STORE_TYPE.contains(this.toString()))
            format =I_LOAD_STORE;
        if(I_INSTRUCTION_FLOW_CONTROL_TYPE.contains(this.toString()))
            format =I_FLOW_CONTROL;
    }

    @Override
    protected void setOpCode() {
        int i=0;
        if(this.getFormatType()==I_ARITHMETIC) {
            i=I_INSTRUCTION_ARITHMETIC_TYPE.indexOf(this.toString());
            opCode = I_INSTRUCTION_ARITHMETIC_OP_CODE.get(i);
        }
        if (this.getFormatType()==I_FLOW_CONTROL) {
            i=I_INSTRUCTION_FLOW_CONTROL_TYPE.indexOf(this.toString());
            opCode=I_INSTRUCTION_FLOW_CONTROL_OP_CODE.get(i);
        }
        if (this.getFormatType()==I_LOAD_STORE) {
            i=I_INSTRUCTION_LOAD_STORE_TYPE.indexOf(this.toString());
            opCode=I_INSTRUCTION_LOAD_OP_CODE.get(i);
        }
    }
}
