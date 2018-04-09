package units;

public class ALUController {
    boolean ALUop[];
    boolean funct[];
    public boolean op[]=new boolean[4];
    public void execute(boolean funct[],boolean ALUop[]){
        this.funct=funct;
        this.ALUop=ALUop;
        op[3]=ALUop[0] && !ALUop[0];
        op[2]= ALUop[0] || (ALUop[1] && funct[1]);
        op[1]= (!ALUop[1] || !funct[2]);
        op[0]= ((funct[0]||funct[3]) && ALUop[1]);
    }


}
