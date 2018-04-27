package units;


public class Controller  {
    private boolean r_format;
    private boolean lw;
    private boolean sw;
    private boolean beq;
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
    private boolean lui;
    private boolean ori;
    private boolean andi;

    private boolean opCode[];
    private boolean regDst[];
    private boolean ALUSrc;
    private boolean memToReg;
    private boolean regWrite;
    private boolean memRead;
    private boolean memWrite;
    private boolean memData[];
    private boolean branch;
    private boolean jump;
    private boolean unsigned;
    private boolean aluOp[];

    public Controller() {
        opCode= new boolean[6];
        aluOp=new boolean[3];
        memData= new boolean[2];
        regDst = new boolean[2];
    }

    public void execute(){
        r_format = !opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && !opCode[1] && !opCode[0];
        lw = opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && opCode[1] && opCode[0];
        sw = opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && opCode[1] && opCode[0];
        beq = !opCode[5] && !opCode[4] && !opCode[3] && opCode[2] && !opCode[1] && !opCode[0];
        bne = !opCode[5] && !opCode[4] && !opCode[3] && opCode[2] && !opCode[1] && opCode[0];
        addi = !opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && !opCode[1] && !opCode[0];
        slti = !opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && opCode[1] && !opCode[0];
        sltiu = !opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && opCode[1] && opCode[0];
        lui = !opCode[5] && !opCode[4] && opCode[3] && opCode[2] && opCode[1] && opCode[0];
        ori = !opCode[5] && !opCode[4] && opCode[3] && opCode[2] && !opCode[1] && opCode[0];
        andi = !opCode[5] && !opCode[4] && opCode[3] && opCode[2] && !opCode[1] && !opCode[0];
        lh = opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && !opCode[1] && opCode[0];
        lhu = opCode[5] && !opCode[4] && !opCode[3] && opCode[2] && !opCode[1] && opCode[0];
        lb = opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && !opCode[1] && !opCode[0];
        lbu = opCode[5] && !opCode[4] && !opCode[3] && opCode[2] && !opCode[1] && !opCode[0];
        sb = opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && !opCode[1] && !opCode[0];
        sh = opCode[5] && !opCode[4] && opCode[3] && !opCode[2] && !opCode[1] && opCode[0];
        j = !opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && opCode[1] && !opCode[0];
        jal = !opCode[5] && !opCode[4] && !opCode[3] && !opCode[2] && opCode[1] && opCode[0];


        regDst[1] = r_format ;
        regDst[0] = jal;
        ALUSrc = lw || sw || addi || slti || sltiu || lui || ori || andi || lh || lhu || lb || lbu || sb || sh;
        memToReg = lw || lh || lhu || lb || lbu;
        regWrite =  r_format || lw || addi || slti || sltiu || lui || ori || andi || lh || lhu || lb || lbu || jal;
        memRead = lw || lh || lhu || lb || lbu;
        memWrite = sw || sh || sb;
        memData[1] = sb || lb || lbu;
        memData[0] = sh || lh || lhu;
        branch = beq || bne;
        jump = j;
        unsigned = lhu || lbu;
        aluOp[2] = lui || ori || andi || sltiu;
        aluOp[1] = r_format || slti || sltiu || ori;
        aluOp[0] = beq || bne || slti || sltiu || andi;

    }
    public void print (){
     //   System.out.println("Reg Dst: "+regDst+"\t"+"ALUSrc: "+ALUSrc+"\t"+"MemToReg: "+memToReg+"\t"+"MemWrite: "+memWrite+"\t"+"MemRead: "+memRead+"\t"+"Branch: "+branch+"\t"+ALUOp[1]+"\t"+ALUOp[0]+"\t"+"RegWrite: "+regWrite);
    }

    public void setInput(boolean[] input) {
        opCode=input;
    }

    public boolean[] getOutput() {
        return new boolean[0];
    }

    public boolean isR_format() {
        return r_format;
    }

    public boolean isLw() {
        return lw;
    }

    public boolean isSw() {
        return sw;
    }

    public boolean isBeq() {
        return beq;
    }

    public boolean isBne() {
        return bne;
    }

    public boolean isAddi() {
        return addi;
    }

    public boolean isSlti() {
        return slti;
    }

    public boolean isSltiu() {
        return sltiu;
    }

    public boolean isLh() {
        return lh;
    }

    public boolean isLhu() {
        return lhu;
    }

    public boolean isLb() {
        return lb;
    }

    public boolean isLbu() {
        return lbu;
    }

    public boolean isSb() {
        return sb;
    }

    public boolean isJ() {
        return j;
    }

    public boolean isSh() {
        return sh;
    }

    public boolean isJal() {
        return jal;
    }

    public boolean isLui() {
        return lui;
    }

    public boolean isOri() {
        return ori;
    }

    public boolean isAndi() {
        return andi;
    }

    public boolean[] getOpCode() {
        return opCode;
    }

    public boolean[] getRegDst() {
        return regDst;
    }

    public boolean isALUSrc() {
        return ALUSrc;
    }

    public boolean isMemToReg() {
        return memToReg;
    }

    public boolean isRegWrite() {
        return regWrite;
    }

    public boolean isMemRead() {
        return memRead;
    }

    public boolean isMemWrite() {
        return memWrite;
    }

    public boolean[] getMemData() {
        return memData;
    }

    public boolean isBranch() {
        return branch;
    }

    public boolean isJump() {
        return jump;
    }

    public boolean isUnsigned() {
        return unsigned;
    }

    public boolean[] getAluOp() {
        return aluOp;
    }
}
