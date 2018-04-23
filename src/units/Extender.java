package units;

public class Extender {
    String input;
    String output;

    public void setInput(String input) {
        this.input = input;
        extend();
    }

    private void extend() {
        if (input.length() == 8) {
            if (input.charAt(0)=='0')
                output = "000000000000000000000000" + input;
            else
                output = "111111111111111111111111" + input;
        } else {
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
