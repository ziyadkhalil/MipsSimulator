import assembler.InstructionFormat;
import assembler.instsruction.Instruction;
import units.Controller;

public class Lol {
    public void Haha (String s){
        Instruction i = Instruction.createInstruction(s);
        String p =  i.getOpCode();
        boolean[] b;
        if (!(i.getFormat()== InstructionFormat.R_FORMAT)) {
            b = new boolean[p.length()];
            for(int k=0;k<p.length();k++){
                if (p.charAt(k) == '1') {
                    b[p.length() - k - 1] = true;
                } else {
                    b[p.length() - k - 1] = false;
                }
            }
        } else {
            b= new boolean[]{false, false, false, false, false,false};
        }
        for (int z=0;z<b.length;z++)
            System.out.println(b[z]);
        Controller c =  new Controller();
        c.execute();
        c.print();
    }
}
