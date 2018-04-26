package units;

import java.util.ArrayList;
import java.util.Arrays;

public class RegMem {

    private static final Register $zero = new Register("$zero");
    private static final Register $at = new Register("$at");
    private static final Register $v0 = new Register("$v0");
    private static final Register $v1 = new Register("$v1");
    private static final Register $a0 = new Register("$a0");
    private static final Register $a1 = new Register("$a1");
    private static final Register $a2 = new Register("$a2");
    private static final Register $a3 = new Register("$a3");
    private static final Register $t0 = new Register("$t0");
    private static final Register $t1 = new Register("$t1");
    private static final Register $t2 = new Register("$t2");
    private static final Register $t3 = new Register("$t3");
    private static final Register $t4 = new Register("$t4");
    private static final Register $t5 = new Register("$t5");
    private static final Register $t6 = new Register("$t6");
    private static final Register $t7 = new Register("$t7");
    private static final Register $s0 = new Register("$s0");
    private static final Register $s1 = new Register("$s1");
    private static final Register $s2 = new Register("$s2");
    private static final Register $s3 = new Register("$s3");
    private static final Register $s4 = new Register("$s4");
    private static final Register $s5 = new Register("$s5");
    private static final Register $s6 = new Register("$s6");
    private static final Register $s7 = new Register("$s7");
    private static final Register $t8 = new Register("$t8");
    private static final Register $t9 = new Register("$t9");
    private static final Register $k0 = new Register("$k0");
    private static final Register $k1 = new Register("$k1");
    private static final Register $gp = new Register("$gp");
    private static final Register $sp = new Register("$sp");
    private static final Register $fp = new Register("$fp");
    private static final Register $ra = new Register("$ra");
    private static final ArrayList<Register>  Registers=new ArrayList<>(Arrays.asList($zero,$at,$v0,$v1,$a0,$a1,$a2,$a3,$t0,$t1,$t2,$t3,$t4,$t5,$t6,$t7,$s0,$s1,$s2,$s3,$s4,$s5,$s6,$s7,$t8,$t9,$k0,$k1,$gp,$sp,$fp,$ra));

   private String readReg1;
   private String readReg2;
   private String writeReg;
   private String readData1;
   private String readData2;
   private String writeData;
   //boolean currentlyWriting



   public void read(String readReg1,String readReg2,String writeReg){
       this.readReg1=readReg1;
       this.readReg2=readReg2;
       this.writeReg=writeReg;

       readData1=Registers.get(Integer.parseInt(readReg1,2)).getValue();
       readData2=Registers.get(Integer.parseInt(readReg2,2)).getValue();

   }

   public void write(boolean regWrite,String writeData){
       if(regWrite){
          this.writeData=writeData;
          Registers.get(Integer.parseInt(writeReg,2)).setValue(writeData);
       }
   }

    public String getReadData1() {
        return readData1;
    }

    public String getReadData2() {
        return readData2;
    }
}