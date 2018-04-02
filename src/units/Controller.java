package units;

public class Controller {
    Boolean opCode[] = new Boolean[6];
    Boolean regDst;
    Boolean branch;
    Boolean memRead;
    Boolean memToReg;
    Boolean ALUOp[];
    Boolean memWrite;
    public Controller(Boolean opCode[]){
        this.opCode=opCode;
    }
    public void execute(){

    }
}
