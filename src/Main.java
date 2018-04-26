import assembler.Assembler;
import assembler.InstructionLine;
import assembler.instsruction.IInstruction;
import assembler.instsruction.Instruction;
import assembler.instsruction.RInstruction;
import com.sun.javafx.geom.Path2D;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import units.ALUController;
import units.Controller;
import board.Processor;


import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main extends Application {
    public static void main (String[] args) throws FileNotFoundException {
        Processor Processor=new Proseccor();
        Processor.process();
        launch(args);
        //Assembler a = new Assembler();
      //  a.assemble();
       // int h = 's';
       // System.out.println(Integer.toBinaryString(h));
//        Controller c = new Controller();
//        boolean[] a = {true,true,true,true,true,true};
//        c.execute(a);
//        String[] inst = {
//                "add","lw","sw","beq","bne","addi","slti","sltiu","lui","ori","andi","lh","lhu","lb","lbu","sb","sh","j","jal"
//        };
//        for (String s:
//             inst) {
//            Utils.Hh_hh(Instruction.createInstruction(s));
//        }


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = new Pane(new Controller());
        primaryStage.setTitle("Oh Hai User");
        primaryStage.setScene(new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height));
        primaryStage.setMaximized(true);
        primaryStage.show();
        SVGPath S = new SVGPath();


    }
}

