import assembler.Assembler;
import assembler.InstructionLine;
import assembler.instsruction.IInstruction;
import assembler.instsruction.Instruction;
import assembler.instsruction.RInstruction;
import units.ALUController;
import units.Controller;

import java.io.FileNotFoundException;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {

        //Assembler a = new Assembler();
      //  a.assemble();
       // int h = 's';
       // System.out.println(Integer.toBinaryString(h));
        String[] inst = {
                "add","lw","sw","beq","bne","addi","slti","sltiu","lh","lhu","lb","lbu","sb","sh","j","jal"
        };
        for (String s:
             inst) {
            Utils.Hh_hh(Instruction.createInstruction(s));
        }


    }

}

