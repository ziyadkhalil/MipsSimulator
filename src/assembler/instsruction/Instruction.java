package assembler.instsruction;

import assembler.FormatChecker;
import assembler.InstructionFormat;

public abstract class Instruction {
    InstructionFormat format;
    String name;
    public Instruction(String name) {
        this.name = name;
        this.format= FormatChecker.getFormat(name);
    }

    public InstructionFormat getFormat() {
        return format;
    }

    @Override
    public String toString(){
        return name;
    }
    public abstract FormatType getFormatType();
    public abstract byte[] toBinary();

}
