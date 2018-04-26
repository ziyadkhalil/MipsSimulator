package units;

import utils.MipsUtils;

public class Adder {
    private long firstOperand;
    private long secondOperand;
    private long output;
    public void setInputs(String first,String second){
        this.firstOperand= MipsUtils.stringToLong(first);
        this.secondOperand=MipsUtils.stringToLong(second);
        add();
    }
    public void setInputs(String first){
        this.firstOperand=MipsUtils.stringToLong(first);
        secondOperand=4;
        add();
    }
    private void add(){
        output=firstOperand+secondOperand;
    }

    public String getOutput() {
        return Long.toBinaryString(output);
    }
}
