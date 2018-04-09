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
    private boolean bne;
    private boolean addi;
    private boolean slti;
    private boolean sltiu;
    private boolean lh;
    private boolean lhu;
    private boolean lb;
    private boolean lbu;
    private boolean sb;
    private boolean j;
    private boolean sh;
    private boolean jal;


    public void execute(boolean[] opCode){
        this.opCode=opCode;
        r_format = !opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && !opCode[1] && !opCode[0];
        lw = opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && opCode[1] && opCode[0];
        sw = opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && opCode[1] && opCode[0];
        beq = !opCode[5] && !opCode[4] && !opCode[3] && opCode[2] && !opCode[1] && !opCode[0];
        bne = !opCode[5] && !opCode[4] && !opCode[3] && opCode[2] && !opCode[1] && opCode[0];
        addi = !opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && !opCode[1] && !opCode[0];
        slti = !opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && opCode[1] && !opCode[0];
        sltiu = !opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && opCode[1] && opCode[0];
        lh = opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && !opCode[1] && opCode[0];
        lhu = opCode[5] && !opCode[4] && !opCode[3] && opCode[2] && !opCode[1] && opCode[0];
        lb = opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && !opCode[1] && !opCode[0];
        lbu = opCode[5] && !opCode[4] && !opCode[3] && opCode[2] && !opCode[1] && !opCode[0];
        sb = opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && !opCode[1] && !opCode[0];
        sh = opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && !opCode[1] && opCode[0];
        j = !opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && opCode[1] && !opCode[0];
        jal = !opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && opCode[1] && opCode[0];
    }
    public void print (){
        System.out.println("Reg Dst: "+regDst+"\t"+"ALUSrc: "+ALUSrc+"\t"+"MemToReg: "+memToReg+"\t"+"MemWrite: "+memWrite+"\t"+"MemRead: "+memRead+"\t"+"Branch: "+branch+"\t"+ALUOp[1]+"\t"+ALUOp[0]+"\t"+"RegWrite: "+regWrite);
    }

}
