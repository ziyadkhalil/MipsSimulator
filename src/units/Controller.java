package units;

public class Controller {
    boolean opCode[];
    boolean regDst;
    boolean ALUSrc;
    boolean branch;
    boolean memRead;
    boolean memToReg;
   public boolean ALUOp[] = new boolean[2];
    boolean memWrite;
    boolean regWrite;
    boolean r_format;
    boolean lw;
    boolean sw;
    boolean beq;


    public void execute(boolean[] opCode){
        this.opCode=opCode;
        r_format = !opCode[0] && !opCode[1] && !opCode[2] && !opCode[3] && !opCode[4] && !opCode[5];
        lw = opCode[0] && opCode[1] && !opCode[2] && !opCode[3] && !opCode[4] && opCode[5];
        sw = opCode[0] && opCode[1] && !opCode[2] && opCode[3] && !opCode[4] && opCode[5];
        beq = !opCode[0] && !opCode[1] && opCode[2] && !opCode[3] && !opCode[4] && !opCode[5];
        regDst = r_format;
        ALUSrc = lw || sw;
        memToReg = lw;
        regWrite = r_format || lw;
        memRead = lw;
        memWrite = sw;
        branch = beq;
        ALUOp[0] = beq;
        ALUOp[1] = r_format;
    }
    public void print (){
        System.out.println("Reg Dst: "+regDst+"\t"+"ALUSrc: "+ALUSrc+"\t"+"MemToReg: "+memToReg+"\t"+"MemWrite: "+memWrite+"\t"+"MemRead: "+memRead+"\t"+"Branch: "+branch+"\t"+ALUOp[1]+"\t"+ALUOp[0]+"\t"+"RegWrite: "+regWrite);
    }

}
