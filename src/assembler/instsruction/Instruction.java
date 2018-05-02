package assembler.instsruction;

import assembler.InstructionFormat;

import java.util.ArrayList;
import java.util.Arrays;

import static assembler.InstructionFormat.I_FORMAT;
import static assembler.InstructionFormat.J_FORMAT;
import static assembler.InstructionFormat.R_FORMAT;

public abstract class Instruction {
    static final ArrayList<String> R_INSTRUCTIONS = new ArrayList<>(Arrays.asList("add","sub","mul","nor","or","and","slt","sltu","sll","srl","jr"));
    static final ArrayList<String> I_INSTRUCTION = new ArrayList<>(Arrays.asList("beq","lw","sw","lb","lbu","sb","lh","sh","addi","slti","sltiu","bne","andi","ori","lui","lhu"));
    static final ArrayList<String> J_INSTRUCTION = new ArrayList<>(Arrays.asList("j","jal"));
    private InstructionFormat format;
    private String name;
    public Instruction(String name) {
        this.name = name;
        this.format= getFormat(name);
    }


    public InstructionFormat getFormat() {
        return format;
    }

    @Override
    public String toString(){
        return name;
    }
    private static InstructionFormat getFormat(String instructionName) {
        if (R_INSTRUCTIONS.contains(instructionName))
            return  R_FORMAT;
        if (I_INSTRUCTION.contains(instructionName))
            return I_FORMAT;
        if (J_INSTRUCTION.contains(instructionName))
            return J_FORMAT;
        return null; //TODO: wrong instruction error to be handled
    }
    public static Instruction createInstruction (String instructionNme){
        Instruction inst;
        switch (Instruction.getFormat(instructionNme)){
            case R_FORMAT:
                inst = new RInstruction(instructionNme);
                break;
            case I_FORMAT:
                inst = new IInstruction(instructionNme);
                break;
            case J_FORMAT:
                inst = new JInstruction(instructionNme);
                break;
            default:
                inst = null;


        }
        return inst;
    }
    public abstract FormatType  getFormatType();
    public abstract String getOpCode();
    protected abstract void setFormatType();
    protected abstract void setOpCode();


}
