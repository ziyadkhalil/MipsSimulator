package assembler.instsruction;

import assembler.instsruction.FormatType;
import assembler.instsruction.Instruction;
import java.util.ArrayList;
import java.util.Arrays;
import static assembler.instsruction.FormatType.*;

public class RInstruction extends Instruction {
    private ArrayList<String> R_INSTRUCTION_ARITHMETIC_TYPE = new ArrayList<>(Arrays.asList("add","sub","mul","nor","or","slt","and","sltu"));
    private ArrayList<String> R_INSTRUCTION_ARITHMETIC_OP_CODE = new ArrayList<>(Arrays.asList("100000","101011","mul","100111","100101","101010","100100","101011"));

    private ArrayList<String> R_INSTRUCTION_SHIFTING_TYPE = new ArrayList<>(Arrays.asList("sll","srl"));
    private ArrayList<String> R_INSTRUCTION_SHIFTING_OP_CODE = new ArrayList<>(Arrays.asList("000000","000010"));

    private FormatType formatType;
    private String opCode;

    public RInstruction(String name) {
        super(name);
        this.setFormatType();
        this.setOpCode();

    }

    @Override
    public FormatType getFormatType() {
        return formatType;
    }

    @Override
    public String getOpCode() {
       return opCode;
    }

    @Override
    public void setFormatType() {
        if (R_INSTRUCTION_ARITHMETIC_TYPE.contains(this.toString()))
            this.formatType=R_ARITHMETIC;
        if(R_INSTRUCTION_SHIFTING_TYPE.contains(this.toString()))
            this.formatType=R_SHIFTING;
    }

    @Override
    protected void setOpCode() {
        int i=0;
        if(this.getFormatType()==R_ARITHMETIC) {
            i=R_INSTRUCTION_ARITHMETIC_TYPE.indexOf(this.toString());
            opCode = R_INSTRUCTION_ARITHMETIC_OP_CODE.get(i);
        }
        if (this.getFormatType()==R_SHIFTING) {
            i=R_INSTRUCTION_SHIFTING_TYPE.indexOf(this.toString());
            opCode=R_INSTRUCTION_SHIFTING_OP_CODE.get(i);
        }

    }
}
