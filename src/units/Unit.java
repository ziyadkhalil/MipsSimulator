package units;

import board.Wire;
import javafx.scene.layout.AnchorPane;

public abstract class Unit extends AnchorPane {
    public abstract void setInput(boolean input[]);
    public abstract boolean[] getOutput();
}
