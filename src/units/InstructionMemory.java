package units;

import assembler.InstructionLine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class InstructionMemory {
    private int initialLocation;
    private ObservableList<InstructionLine> instructions = FXCollections.observableArrayList();


    public ObservableList<InstructionLine> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<InstructionLine> instructions) {
        this.instructions.setAll(instructions);
    }


    public int getInitialLocation() {
        return initialLocation;
    }

    public void setInitialLocation(int initialLocation) {
        this.initialLocation = initialLocation;
    }
}
