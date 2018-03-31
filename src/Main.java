import assembler.instsruction.Instruction;

public class Main {
    public static void main (String[] args){
       String x = "j";
       Instruction r =  Instruction.createInstruction(x);
        System.out.println(r);
        System.out.println(r.getFormatType());
        System.out.println(r.getOpCode());
        System.out.println(r.getFormat());
    }
}
