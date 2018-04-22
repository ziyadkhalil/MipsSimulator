package units;

public class ALU {
    private int OpInt;
    private int FirstInt;
    private int SecondtInt;
    private int Output;
    private int ZeroFlag;
    /*
    Operations guide
    nor=64
    slt=56
    sub=48
    add=16
    or=8
    sll=4
    srl=2
    mul=1
    and=0
    */

    public void setInputs(String Op, String First, String Second, int Shamt){
        this.OpInt=Integer.parseInt(Op);
        this.FirstInt=Integer.parseInt(First);
        this.SecondtInt=Integer.parseInt(Second);

        switch (OpInt){
            case 64:
                Output=~(FirstInt|SecondtInt);
                break;
            case 56:
                Output=(FirstInt<SecondtInt)? 1:0;
                break;
            case 48:
                Output=FirstInt-SecondtInt;
                break;
            case 16:
                Output=FirstInt+SecondtInt;
                break;
            case 8:
                Output=FirstInt|SecondtInt;
                break;
            case 4:
                Output=SecondtInt<<Shamt;          //Read Data1 =0
                break;
            case 2:
                Output=SecondtInt>>Shamt;          //Read Data1 =0
                break;
            case 1:
                Output=FirstInt*SecondtInt;
                break;
            case 0:
                Output=FirstInt&SecondtInt;
                break;
        }
        ZeroFlag=(FirstInt-SecondtInt==0)?1:0;
    }

    public int getOutput(){
        return Output;
    }
    public int getZeroFlag(){
        return ZeroFlag;
    }
}
