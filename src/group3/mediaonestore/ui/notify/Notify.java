package group3.mediaonestore.ui.notify;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Notify {

	public static void makeErrorAlert(String title, String mess)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setContentText(mess);
		alert.show();
	}
	
	public static Optional<ButtonType> makeConfirmAlert(String title, String mess){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setContentText(mess);
		return alert.showAndWait();
	}
	
	public static void makeInformationAlert(String title, String mess){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setContentText(mess);
		alert.show();
	}
	
}
