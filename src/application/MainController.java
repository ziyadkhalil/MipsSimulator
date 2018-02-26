package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
	@FXML
    public void onAddItem (ActionEvent event) {
		try {
			FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("AddTerm.fxml"));
			Parent root1=(Parent) fxmlloader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
