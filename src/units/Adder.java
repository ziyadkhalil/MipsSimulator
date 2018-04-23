package units;

public class Adder {
    private int FirstOperand;
    private int SecondOperand;
    private int Output;
    public void setInputs(int FirstOperand,int SecondOperand){
        this.FirstOperand=FirstOperand;
        this.SecondOperand=SecondOperand;
        add();
    }
    public void setInputs(int FirstOperand){
        this.FirstOperand=FirstOperand;
        SecondOperand=4;
        add();
    }
    private void add(){
        Output=FirstOperand+SecondOperand;
    }

    public int getOutput() {
        return Output;
    }
}
