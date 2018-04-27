package units;

public class ALUController {
    boolean[] ALUOp=new boolean[3];
    boolean[] Fn = new boolean[6];

    boolean add;
    boolean sub;
    boolean slt;
    boolean sll;
    boolean srl;
    boolean and;
    boolean or;
    boolean unsigned;
    boolean nor;
    boolean jr;
    boolean mul;
    boolean[] Op=new boolean[8];


    public void setInputs(boolean[] ALUOp ,boolean[] Fn){
        this.ALUOp=ALUOp;
        this.Fn=Fn;
        //R and other instructions
        add=(!ALUOp[2]&& !ALUOp[1] && !ALUOp[0])|(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& Fn[5]&& !Fn[4]&& !Fn[3]&& !Fn[2]&& !Fn[1]&& !Fn[0]);
        sub=(!ALUOp[2]&& !ALUOp[1] && ALUOp[0])|(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& Fn[5]&& !Fn[4]&& !Fn[3]&& !Fn[2]&& Fn[1]&& !Fn[0]);
        and=(ALUOp[2]&& !ALUOp[1] && ALUOp[0])|(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& Fn[5]&& !Fn[4]&& !Fn[3]&& Fn[2]&& !Fn[1]&& !Fn[0]);
        or =(ALUOp[2]&& ALUOp[1] && !ALUOp[0])|(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& Fn[5]&& !Fn[4]&& !Fn[3]&& Fn[2]&& !Fn[1]&& Fn[0]);
        slt=(!ALUOp[2]&& ALUOp[1] && ALUOp[0])|(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& Fn[5]&& !Fn[4]&& Fn[3]&& !Fn[2]&& Fn[1]&& !Fn[0]);
        sll=(ALUOp[2]&& !ALUOp[1] && !ALUOp[0])|(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& !Fn[5]&& !Fn[4]&& !Fn[3]&& !Fn[2]&& !Fn[1]&& !Fn[0]);

        //only R instructions
        nor=(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& Fn[5]&& !Fn[4]&& !Fn[3]&& Fn[2]&& Fn[1]&& Fn[0]);
        jr=(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& !Fn[5]&& !Fn[4]&& Fn[3]&& !Fn[2]&& !Fn[1]&& !Fn[0]);
        srl=(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& !Fn[5]&& !Fn[4]&& !Fn[3]&& !Fn[2]&& Fn[1]&& !Fn[0]);
        mul=(!ALUOp[2]&&ALUOp[1]&&!ALUOp[0]&& !Fn[5]&& Fn[4]&& Fn[3]&& !Fn[2]&& !Fn[1]&& !Fn[0]);

        //only other instructions
        unsigned=(ALUOp[2]&& ALUOp[1] && ALUOp[0])||(Fn[5]&& !Fn[4]&& Fn[3]&& !Fn[2]&& Fn[1]&& Fn[0]);

        setOp();

    }

    private void setOp(){
        Op[0]=unsigned;
        Op[1]=srl;
        Op[2]=sll;
        Op[3]=or || slt;
        Op[4]=add || sub || slt;
        Op[5]=sub || slt;
        Op[6]=nor;
        Op[7]=mul;
    }
    public boolean[] getOp(){
        return Op;
    }

    public boolean getJr() {
        return jr;
    }

    public void print(){
        for(int i=6;i>=0;i--)
            System.out.print(Op[i]+" ");
        System.out.println(jr);
    }



}
