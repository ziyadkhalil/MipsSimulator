package units;

public class Mux {
    private String firstInput;
    private String secondInput;
    private String thirdInput;
    private String output;
    private boolean selection1;
    private boolean selection2;



    public void set2Inputs(String firstInput, String secondInput, boolean selection) {
        this.firstInput = firstInput;
        this.secondInput = secondInput;
        this.selection1 = selection;
        this.selection2=false;
        select();
    }
    public void set3Inputs(String firstInput, String secondInput, String thirdInput, boolean[] selections) {
        this.firstInput = firstInput;
        this.secondInput = secondInput;
        this.thirdInput=thirdInput;
        this.selection1=selections[0];
        this.selection2=selections[1];
        select();
    }

    private void select(){
        if(!selection1&&!selection2)
            output=firstInput;
        else if(selection1&&!selection2)
            output=secondInput;
        else
            output=thirdInput;
    }

    public String getOutput(){
        return output;
    }
}
