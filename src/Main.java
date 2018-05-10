import assembler.Assembler;
import assembler.InstructionLine;
import assembler.instsruction.IInstruction;
import assembler.instsruction.Instruction;
import assembler.instsruction.RInstruction;
import board.Processor;
import com.sun.javafx.geom.Path2D;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import units.ALUController;
import units.Controller;
import units.DataMemory;
import utils.MipsUtils;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main extends Application {
    public static void main (String[] args) throws FileNotFoundException {

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Oh Hai User");
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/mainScene.FXML"));
        Pane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();

//        DataMemory dataMemory = new DataMemory();
//        dataMemory.setAddress("100");
//        dataMemory.setDataToWrite("00001111000011111111000000001111");
//        dataMemory.injectFlags(true,false,"00");
//        dataMemory.execute();
//        dataMemory.injectFlags(true,false,"10");
//        dataMemory.setDataToWrite("00000000000000000000000011111111");
//        dataMemory.setAddress("111");
//        dataMemory.execute();
//        dataMemory.injectFlags(false,true,"00");
//        dataMemory.setAddress("100");
//        dataMemory.execute();
//        System.out.println(dataMemory.getDataRead());

    }
}

