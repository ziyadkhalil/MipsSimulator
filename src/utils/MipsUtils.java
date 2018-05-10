package utils;

import assembler.InstructionFormat;
import assembler.instsruction.Instruction;
import units.Controller;


public class MipsUtils {
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
        System.out.println(s);
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
    public static String setBits(String bits, int length) {
        for (int n = bits.length(); n < length; n++) {
            bits = '0' + bits;
        }
        return bits;
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
    public static String fromBooleantoString (boolean b){
        if(b)
            return "1";
        return "0";
    }

    public static long stringToLong(String s){
        if(s.charAt(0)=='0')
            return Long.parseLong(s,2);
        else
            return (-2147483648+Long.parseLong(s.substring(1),2));
    }

    public static String extend32(String s) {

        while (s.length() < 32)
            s = "0" + s;
        if(s.length()>32)
            s=s.substring(0,32);
        return s;
    }
    public static String extend64 (String s ){
            if (s.charAt(0)=='0')
                while (s.length()<64)
                    s='0'+s;
            else
                while (s.length()<64)
                    s='1'+s;
            return s;
    }
}
