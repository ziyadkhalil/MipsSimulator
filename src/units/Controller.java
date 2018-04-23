package units;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class Controller  {
    @FXML Circle opCode5;
    @FXML Circle opCode4;
    @FXML Circle opCode3;
    @FXML Circle opCode2;
    @FXML Circle opCode1;
    @FXML Circle opCode0;
    @FXML Button button;
    @FXML TextField textField;





    private BooleanProperty br_format;
    private BooleanProperty blw;
    private BooleanProperty bsw;
    private BooleanProperty bbeq;
    private BooleanProperty bbne;
    private BooleanProperty baddi;
    private BooleanProperty bslti;
    private BooleanProperty bsltiu;
    private BooleanProperty blh;
    private BooleanProperty blhu;
    private BooleanProperty blb;
    private BooleanProperty blbu;
    private BooleanProperty bsb;
    private BooleanProperty bj;
    private BooleanProperty bsh;
    private BooleanProperty bjal;
    private BooleanProperty blui;
    private BooleanProperty bori;
    private BooleanProperty bandi;

    private BooleanProperty bopCode[];
    private BooleanProperty bregDst[];
    private BooleanProperty bALUSrc;
    private BooleanProperty bmemToReg;
    private BooleanProperty bregWrite;
    private BooleanProperty bmemRead;
    private BooleanProperty bmemWrite;
    private BooleanProperty bmemData[];
    private BooleanProperty bbranch;
    private BooleanProperty bjump;
    private BooleanProperty bunsigned;
    private BooleanProperty baluOp[];



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

    public BooleanProperty[] getBopCode() {
        return bopCode;
    }

    public void setBopCode(BooleanProperty[] bopCode) {
        this.bopCode = bopCode;
    }

    public Controller() {
        opCode= new boolean[6];
        aluOp=new boolean[3];
        memData= new boolean[2];
        regDst = new boolean[2];

        baluOp= new BooleanProperty[3];
        bmemData = new BooleanProperty[2];
        bregDst = new BooleanProperty[2];
        bopCode = new BooleanProperty[6];
        connect();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/units/Controller.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    bopCode[5].addListener((observable, oldValue, newValue) -> {
        if(newValue)
            opCode5.setFill(Paint.valueOf("Green"));
        else
            opCode5.setFill(Paint.valueOf("red"));
    });

        bopCode[4].addListener((observable, oldValue, newValue) -> {
            if(newValue)
                opCode4.setFill(Paint.valueOf("Green"));
            else
                opCode4.setFill(Paint.valueOf("red"));
        });


        bopCode[3].addListener((observable, oldValue, newValue) -> {
            if(newValue)
                opCode3.setFill(Paint.valueOf("Green"));
            else
                opCode3.setFill(Paint.valueOf("red"));
        });


        bopCode[2].addListener((observable, oldValue, newValue) -> {
            if(newValue)
                opCode2.setFill(Paint.valueOf("Green"));
            else
                opCode2.setFill(Paint.valueOf("red"));
        });



        bopCode[1].addListener((observable, oldValue, newValue) -> {
            if(newValue)
                opCode1.setFill(Paint.valueOf("Green"));
            else
                opCode1.setFill(Paint.valueOf("red"));
        });



        bopCode[0].addListener((observable, oldValue, newValue) -> {
            if(newValue )
                opCode0.setFill(Paint.valueOf("Green"));
            else
                opCode0.setFill(Paint.valueOf("red"));
        });


    }
    public void connect(){
        for(int i=0;i<6;i++)
            bopCode[i]=new SimpleBooleanProperty(true);

        bregDst[1] = new SimpleBooleanProperty(false);
        bregDst[0] = new SimpleBooleanProperty(false);
        bALUSrc = new SimpleBooleanProperty(false);
        bmemToReg = new SimpleBooleanProperty(false);
        bregWrite = new SimpleBooleanProperty(false);
        bmemRead = new SimpleBooleanProperty(false);
        bmemWrite = new SimpleBooleanProperty(false);
        bmemData[1] = new SimpleBooleanProperty(false);
        bmemData[0] = new SimpleBooleanProperty(false);
        bbranch = new SimpleBooleanProperty(false);
        bjump = new SimpleBooleanProperty(false);
        bunsigned = new SimpleBooleanProperty(false);
        baluOp[2] = new SimpleBooleanProperty(false);
        baluOp[1] = new SimpleBooleanProperty(false);
        baluOp[0] = new SimpleBooleanProperty(false);

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


        regDst[1] = jal;
        regDst[0] = r_format;
        ALUSrc = lw || sw || addi || slti || sltiu || lui || ori || andi || lh || lhu || lb || lbu || sb || sh;
        memToReg = lw || lh || lhu || lb || lbu;
        regWrite =  r_format || lw || addi || slti || sltiu || lui || ori || andi || lh || lhu || lb || lbu || jal;
        memRead = lw || lh || lhu || lb || lbu;
        memWrite = sw || sh || sb;
        memData[1] = sb || lb || lbu;
        memData[0] = sh || lh || lhu;
        branch = beq || bne;
        jump = j;
        unsigned = sltiu || lhu || lbu;
        aluOp[2] = lui || ori || andi;
        aluOp[1] = r_format || slti || sltiu || ori;
        aluOp[0] = beq || bne || slti || sltiu || andi;

        bregDst[1].setValue(jal);
        bregDst[0].setValue(r_format);
        bALUSrc.setValue(ALUSrc);
        bmemToReg.setValue(memToReg);
        bregWrite.setValue(regWrite);
        bmemRead.setValue(memRead);
        bmemWrite.setValue(memWrite);
        bmemData[1].setValue(memData[1]);
        bmemData[0].setValue(memData[0]);
        bbranch.setValue(branch);
        bjump.setValue(jump);
        bunsigned.setValue(unsigned);
        baluOp[2].setValue(aluOp[2]);
        baluOp[1].setValue(aluOp[1]);
        baluOp[0].setValue(aluOp[0]);

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

    @FXML
    public void action(){
        String x = textField.getText();
        for(int i=5;i>=0;i--)
            if (x.charAt(5-i)=='1')
                bopCode[i].setValue(true);
            else
                bopCode[i].setValue(false);
    }
}
