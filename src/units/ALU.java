package units;

import utils.MipsUtils;
public class ALU {
    private int opInt;
    private long firstLong;
    private long secondLong;
    private long shamtLong;
    private long outputLong;
    private boolean zeroFlag;
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

    public void setInputs(String Op, String First, String Second, String shamt){
        this.opInt=Integer.parseInt(Op,2);           //no negative to handle
        firstLong=MipsUtils.stringToLong(First);
        secondLong=MipsUtils.stringToLong(Second);
        shamtLong=MipsUtils.stringToLong(shamt);

        switch (opInt){
            case 64:
                outputLong=~(firstLong|secondLong);
                break;
            case 56:
                outputLong=(firstLong<secondLong)? 1:0;
                break;
            case 48:
                outputLong=firstLong-secondLong;
                break;
            case 16:
                outputLong=firstLong+secondLong;
                break;
            case 8:
                outputLong=firstLong|secondLong;
                break;
            case 4:
                outputLong=secondLong<<shamtLong;          //Read Data1 =0
                break;
            case 2:
                outputLong=secondLong>>shamtLong;          //Read Data1 =0
                break;
            case 1:
                outputLong=firstLong*secondLong;
                break;
            case 0:
                outputLong=firstLong&secondLong;
                break;
        }
        zeroFlag=(firstLong-secondLong==0);
    }

    public String getOutput(){

        return MipsUtils.extend32(Integer.toBinaryString((int)outputLong));
    }
    public boolean getZeroFlag(){
        return zeroFlag;
    }

}
