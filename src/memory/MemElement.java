package memory;
import assembler.instsruction.*;
public class MemElement {
    private int address;
    private int IntValue;
//    private InstructionLine instructionValue;
    private String label;
//
//
//    public MemElement(int address, InstructionLine instructionValue, String label) {
//        this.address = address;
//        this.instructionValue = instructionValue;
//        this.label = label;
//    }
//    public MemElement(int address, InstructionLine instructionValue) {
//        this.address = address;
//        this.instructionValue = instructionValue;
//    }

    public MemElement(int address, int IntValue, String label) {

        this.address = address;
        this.IntValue = IntValue;
        this.label = label;
    }

    public MemElement(int address, int IntValue) {

        this.address = address;
        this.IntValue = IntValue;
    }

    public MemElement(int address, String label) {
        this.address = address;
        this.label = label;
    }

    public int getAddress() {
        return address;
    }

    public int getIntValue() {
        return IntValue;
    }

//    public InstructionLine getInstructionValue() {
//        return instructionValue;
//    }

    public String getLabel() {
        return label;
    }

    public void setIntValue(int intValue) {
        this.IntValue = intValue;
    }
    public void resetIntValue(int intValue) {
        IntValue = 0;
    }
}
