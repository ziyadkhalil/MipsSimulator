import assembler.instsruction.Instruction;
import assembler.instsruction.RInstruction;

public class Main {
    public static void main (String[] args){
       String x = "j";
       Instruction r =  Instruction.createInstruction(x);
        System.out.println(r);
        System.out.println(r.getFormatType());
        System.out.println(r.getOpCode());
        System.out.println(r.getFormat());
        String y = "11000";
        System.out.println(Integer.parseInt(y,2));
        System.out.println(String.valueOf(12));
        System.out.println(Integer.toBinaryString(-1));
        y=Integer.toBinaryString(16);
        while(y.length()<16)
            y="0"+y;
        RInstruction h = new RInstruction("add");
        System.out.println(h.toBinary16bit(15));
        System.out.println(h.toBinary16bit(-2));
    }
}
