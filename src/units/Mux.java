package units;

public class Mux {
    private int FirstInput;
    private int SecondInput;
    private int ThirdInput;
    private int Output;
    private boolean selection1;
    private boolean selection2;



    public void set2Inputs(int FirstInput, int SecondInput, boolean selection) {
        this.FirstInput = FirstInput;
        this.SecondInput = SecondInput;
        this.selection1 = selection;
        this.selection2=false;
        select();
    }
    public void set3Inputs(int FirstInput, int SecondInput, int ThirdInput, boolean[] selections) {
        this.FirstInput = FirstInput;
        this.SecondInput = SecondInput;
        this.ThirdInput=ThirdInput;
        this.selection1=selections[0];
        this.selection2=selections[1];
        select();
    }

    private void select(){
        if(!selection1&&!selection2)
            Output=FirstInput;
        else if(selection1&&!selection2)
            Output=SecondInput;
        else
            Output=ThirdInput;
    }

    public int getOutput(){
        return Output;
    }
}
