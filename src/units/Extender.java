package units;

public class Extender {
    private String input;
    private String output;
    private boolean Unsigned;


    public void setInput(String input) {
        this.input = input;
        this.Unsigned=Unsigned;
        System.out.println("what?"+input);
        extendSigned();
    }
    public void setInput(String input,boolean Unsigned) {
        this.input = input;
        this.Unsigned=Unsigned;
        System.out.println("what?"+input);
        extend();
    }

    private void extend() {
        output=input;
        if (input.length() == 8) {
            if (Unsigned||input.charAt(0)=='0')
                output = "000000000000000000000000" + input;
            else
                output = "111111111111111111111111" + input;
        } else if (input.length()==16) {
            if (Unsigned || input.charAt(0)=='0')
                output = "0000000000000000" + input;
            else
                output = "1111111111111111" + input;
        }
    }
    private void extendSigned() {
        output=input;
        if (input.length() == 8) {
            if (input.charAt(0)=='0')
                output = "000000000000000000000000" + input;
            else
                output = "111111111111111111111111" + input;
        } else if (input.length()==16) {
            if (input.charAt(0)=='0')
                output = "0000000000000000" + input;
            else
                output = "1111111111111111" + input;
        }
    }

    public String getOutput() {
        return output;
    }
}
