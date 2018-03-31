package assembler.instsruction;

import assembler.instsruction.FormatType;
import assembler.instsruction.Instruction;

import java.util.ArrayList;
import java.util.Arrays;

import static assembler.instsruction.FormatType.*;

public class JInstruction extends Instruction {
    private final ArrayList<String> J_TYPE = new ArrayList<>(Arrays.asList("j","jal","jr"));
    private final ArrayList<String> J_TYPE_OP_CODE = new ArrayList<>(Arrays.asList("000010","000011","001000"));

    private FormatType format;
    private String opCode;
    public JInstruction(String name) {
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
        this.format=J;
    }

    @Override
    protected void setOpCode() {
        int i=0;
        i= J_TYPE.indexOf(this.toString());
        opCode=J_TYPE_OP_CODE.get(i);
    }
}
