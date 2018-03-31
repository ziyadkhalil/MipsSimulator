package assembler;

import java.util.ArrayList;
import java.util.Arrays;

import static assembler.InstructionFormat.*;

public class  FormatChecker {
    static final ArrayList<String> R_INSTRUCTIONS = new ArrayList<>(Arrays.asList("add","sub","mul","nor","or","add","slt","sltu","sll","srl"));
    static final ArrayList<String> I_INSTRUCTION = new ArrayList<>(Arrays.asList("beq","lw","sw","lb","lbu","sb","lh","sh","addi","slti","sltui","bne","andi","ori","lui"));
    static final ArrayList<String> J_INSTRUCTION = new ArrayList<>(Arrays.asList("j,jal,jr"));

    public static InstructionFormat getFormat(String instructionName) {
        if (R_INSTRUCTIONS.contains(instructionName))
           return  R_FORMAT;
        if (I_INSTRUCTION.contains(instructionName))
            return I_FORMAT;
        if (J_INSTRUCTION.contains(instructionName))
            return J_FORMAT;
        return null; //TODO: wrong instruction error to be handled
    }
}
