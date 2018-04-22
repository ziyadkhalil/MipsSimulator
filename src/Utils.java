import assembler.InstructionFormat;
import assembler.instsruction.Instruction;
import units.Controller;


public class Utils {
    public static boolean[] Haha(Instruction instruction) {
        String p = instruction.getOpCode();
        boolean[] b;
        if (!(instruction.getFormat() == InstructionFormat.R_FORMAT)) {
            b = new boolean[p.length()];
            for (int k = 0; k < p.length(); k++) {
                if (p.charAt(k) == '1') {
                    b[p.length() - k - 1] = true;
                } else {
                    b[p.length() - k - 1] = false;
                }
            }
        } else {
            b = new boolean[]{false, false, false, false, false, false};
        }
        return b;
    }

    public static void Hh_hh(Instruction instruction) {
        boolean[] b = Haha(instruction);
        String s = instruction.toString() + " = ";
        if (b[5])
            s += "opCode[5] ";
        else
            s += "!opCode[5] ";
        for (int i = 1; i < b.length; i++) {
            if (b[5 - i])
                s += "&& opCode[" + (5 - i) + "] ";
            else
                s += "&& !opCode[" + (5 - i) + "] ";
        }
        s = s.trim();
        s += ";";
        System.out.println(s);
    }


    public static boolean[] fromStringtoBoolean(String s) {
        boolean[] b = new boolean[s.length()];
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == '1') {
                b[s.length() - k - 1] = true;
            } else {
                b[s.length() - k - 1] = false;
            }
        }
        return  b;
    }


    public static String fromBooleantoString (boolean[] b){
        String s = "";
        for(int i=0;i<b.length;i++){
            if (b[b.length-i-1])
                s+='1';
            else
                s+='0';
        }
        return s;
    }
}
