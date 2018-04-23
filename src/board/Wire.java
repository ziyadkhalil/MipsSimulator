package board;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.AnchorPane;

public class Wire extends AnchorPane {
    String wireName;
    Unit from;
    Unit to;
    BooleanProperty flag = new SimpleBooleanProperty(false);

    public boolean isFlag() {
        return flag.get();
    }

    public BooleanProperty flagProperty() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag.set(flag);
    }

    public Wire(Unit input, Unit output) {

    }
}
