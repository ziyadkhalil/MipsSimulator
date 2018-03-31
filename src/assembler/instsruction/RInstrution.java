package assembler.instsruction;

public class RInstrution extends Instruction  {
    public RInstrution(String name) {
        super(name);
    }

    @Override
    public FormatType getFormatType() {
        return null;
    }

    @Override
    public byte[] toBinary() {
        return new byte[0];
    }
}
