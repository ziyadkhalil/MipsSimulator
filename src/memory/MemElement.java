package memory;
import assembler.InstructionLine;

import java.util.ArrayList;

public class MemElement {
    private int address;
    private int IntValue;
    private InstructionLine instructionValue;
    private String label;
    public  static ArrayList<MemElement> Instructions=new ArrayList<>();


    public MemElement(int address, int IntValue) {

        this.address = address;
        this.IntValue = IntValue;
    } 

    public MemElement(int address, String label) {
        this.address = address;
        this.label = label;
        Instructions.add(this);
    }

    public static int getAddressOfLabel(String label) {
        MemElement[] Instructs =(MemElement[])Instructions.toArray();
        for (int i = 0; i < Instructs.length; i++)
            if (Instructs[i].label.equals(label))
                return Instructs[i].address;
        return 0;
    }

    public int getAddress() {
        return address;
    }

    public int getIntValue() {
        return IntValue;
    }

    public InstructionLine getInstructionValue() {
        return instructionValue;
    }

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
