package units;

public class ShiftLeft {
    String input;
    String output;

    public void setInput(String input){
        this.input=input;
        shift();
    }
    private void shift(){
        output=input+"00";
        if(output.length()>=32)
            output=input.substring(2);
    }

    public String getOutput(){
        return output;
    }

}
