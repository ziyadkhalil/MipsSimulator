package assembler;


import assembler.instsruction.Instruction;
import units.Register;

import java.util.Map;

import static utils.MipsUtils.setBits;

public class InstructionLine {

    private static Map<String,String> labels;
    private Instruction instruction;
    private String rt;
    private String rs;
    private String rd;
    private int constant;                    //case: I/J format
    private String code;
    private String index;

    public InstructionLine(String line,String index) {
        this.index=index;
        instruction=Instruction.createInstruction(line.substring(0,line.indexOf(" ")));
        line=line.substring(line.indexOf(" ")+1).trim();
        switch (instruction.getFormatType()) {
            case J:
                setJ(line);
                break;
            case R_SHIFTING:
                setR_SHIFTING(line);
                break;
            case I_ARITHMETIC:
                setI_ARITHMETIC(line);
                break;
            case I_LOAD_STORE:
                setI_LOAD_STORE(line);
                break;
            case R_ARITHMETIC:
                setR_ARITHMETIC(line);
                break;
            case I_FLOW_CONTROL:
                setI_FLOW_CONTROL(line);
                break;
            case R_JUMPING:
                ssetR_JUMPING(line);
                break;
        }
    }

    private void ssetR_JUMPING(String line){
        rs = Register.getCodeAssembler(line.trim());
        code="000000"+setBits(rs,5)+"000000000000000"+instruction.getOpCode();
    }

    private void setJ(String line) {

        constant = Integer.parseInt(labels.get(line));
        String x = Integer.toBinaryString(constant);
        x=setBits(x,28);
        x=x.substring(0,26);
        code=instruction.getOpCode()+x;
    }

    private void setI_LOAD_STORE(String line) {
        rt = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
        line = line.substring(line.indexOf(",") + 1);
        String shamount = line.substring(0, line.indexOf("(")).trim();
        constant = Integer.parseInt(shamount);
        line = line.substring(line.indexOf("(")+1,line.indexOf(")"));
        rs = Register.getCodeAssembler(line.trim());
        code=instruction.getOpCode()+setBits(rs,5)+setBits(rt,5)+setBitsConst(constant,16);
    }

    private void setI_ARITHMETIC(String line) {
        if(instruction.getOpCode().equals("001111")){
            rt = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
            line = line.substring(line.indexOf(",") + 1).trim();
            constant = Integer.parseInt(line);
            code=instruction.getOpCode()+"00000"+setBits(rt,5)+setBitsConst(constant,16);
        }
        else{
            rt = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
            line = line.substring(line.indexOf(",") + 1).trim();
            rs = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
            line = line.substring(line.indexOf(",") + 1).trim();
            constant = Integer.parseInt(line);
            code=instruction.getOpCode()+setBits(rs,5)+setBits(rt,5)+setBitsConst(constant,16);
        }
    }

    private void setI_FLOW_CONTROL(String line) {
        rs = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
        System.out.println("rs: "+rs);
        line = line.substring(line.indexOf(",") + 1);
        rt = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
        System.out.println( "rt: "+rt);
        line = line.substring(line.indexOf(",") + 1).trim(); //label
        System.out.println(line);
        String x = labels.get(line); //gets address location of the label from static map labels
        constant = (Integer.parseInt(x)- Integer.parseInt(index) - 4)/4 ;    //label address - PC - 4
        code = instruction.getOpCode()+setBits(rs,5)+setBits(rt,5)+setBitsConst(constant,16);

        //TODO after the PC thing
        // constant=(pc-MemoryArray.Indexof(getMemElementOfLabel(label))/4
    }

    private void setR_SHIFTING(String line) {
        rd = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
        line = line.substring(line.indexOf(",") + 1);
        rt = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
        line = line.substring(line.indexOf(",") + 1).trim();
        constant = Integer.parseInt(line);

        code="000000"+"00000"+setBits(rt,5)+setBits(rd,5)+setBitsConst(constant,5)+instruction.getOpCode();
    }

    private void setR_ARITHMETIC(String line) {
        rd = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
        line = line.substring(line.indexOf(",") + 1);
        rs = Register.getCodeAssembler(line.substring(0, line.indexOf(",")).trim());
        line = line.substring(line.indexOf(",") + 1);
        rt = Register.getCodeAssembler(line.trim());

        code="000000"+setBits(rs,5)+setBits(rt,5)+setBits(rd,5)+"00000"+instruction.getOpCode();
    }

    private String setBits(String bits, int length) {
        for (int n = bits.length(); n < length; n++) {
            bits = '0' + bits;
        }
        return bits;
    }

    private String setBitsConst(int constant, int length){
        String bits;
        if(constant>=0)
            bits=setBits(Integer.toBinaryString(constant), length);
        else
            bits=Integer.toBinaryString(constant).substring(32-length);
        return bits;
    }

    public static void injectLabels(Map<String,String> labels){
        InstructionLine.labels=labels;
    }


    public String getCode() {
        return code;
    }
    public Instruction getInstruction() {
        return instruction;
    }
    public String getRd() {
        return rd;
    }
    public String getRs() {
        return rs;
    }
    public String getRt() {
        return rt;
    }
    public int getConstant() {
        return constant;
    }

}

