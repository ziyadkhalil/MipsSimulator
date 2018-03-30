package units;

public class Mux {
    int firstInput;
    int secondInput;
    boolean selection;

    public Mux(int firstInput, int secondInput, boolean selection) {
        this.firstInput = firstInput;
        this.secondInput = secondInput;
        this.selection = selection;
    }
    public int select(){
        if(selection) return secondInput;
        return firstInput;
    }
}
