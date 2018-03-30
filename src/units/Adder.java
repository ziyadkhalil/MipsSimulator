package units;

public class Adder {
    private int firstOperand;
    private int secondOperand;
    public Adder(int firstOperand,int secondOperand){
        this.firstOperand=firstOperand;
        this.secondOperand=secondOperand;
    }
    public Adder(int firstOperand){
        this.firstOperand=firstOperand;
        secondOperand=4;
    }
    public int add(){
        return firstOperand+secondOperand;
    }
}
