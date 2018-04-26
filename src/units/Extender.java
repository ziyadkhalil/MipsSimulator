package units;

public class Extender {
    private String input;
    private String output;
    private boolean Unsigned;


    public void setInput(String input,boolean Unsigned) {
        this.input = input;
        this.Unsigned=Unsigned;
        extend();
    }

    private void extend() {
        if (input.length() == 8) {
            if (Unsigned||input.charAt(0)=='0')
                output = "000000000000000000000000" + input;
            else
                output = "111111111111111111111111" + input;
        } else {
            if (Unsigned || input.charAt(0)=='0')
                output = "0000000000000000" + input;
            else
                output = "1111111111111111" + input;
        }
    }

    public String getOutput() {
        return output;
    }
}
