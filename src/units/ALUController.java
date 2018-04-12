package units;

public class ALUController {
    Boolean[] ALUOp=new Boolean[3];
    Boolean[] Fn = new Boolean[6];

    Boolean add;
    Boolean sub;
    Boolean slt;
    Boolean sll;
    Boolean srl;
    Boolean and;
    Boolean or;
    Boolean mul;
    Boolean nor;
    Boolean jr;
    Boolean[] Op=new Boolean[7];
    Boolean ra;

    public ALUController(Boolean[] ALUOp, Boolean[]Fn){
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

        //only other instructions
        mul=(ALUOp[2]&& ALUOp[1] && ALUOp[0]);

        setOp();

    }

    private void setOp(){
        ra=jr;
        Op[0]=mul;
        Op[1]=srl;
        Op[2]=sll;
        Op[3]=or | slt;
        Op[4]=add | sub | slt;
        Op[5]=sub | slt;
        Op[6]=nor;
    }

    public void print(){
        for(int i=6;i>=0;i--)
            System.out.print(Op[i]+" ");
        System.out.println(ra);
    }


}
