package group3.mediaonestore.staff;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import group3.mediaonestore.ui.notify.Notify;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStaffController implements Initializable{

	@FXML
	private TextField _name;
	@FXML
	private DatePicker _birthDay;
	@FXML
	private TextField _idNumber;
	@FXML
	private TextField _phoneNumber;
	@FXML
	private TextField _salary;
	@FXML
	private TextField _username;
	@FXML
	private PasswordField _password;
	@FXML
	private CheckBox _isAdmin;
	
	private StaffDataHandler handler;
	
	@FXML
	private void handleSaveButton(ActionEvent event){
		String name = _name.getText();
		String birthDay = _birthDay.getValue().toString();
		String idNumber = _idNumber.getText();
		String phoneNumber = _phoneNumber.getText();
		double salary = Double.parseDouble(_salary.getText());
		String username = _username.getText();
		String password = _password.getText();
		
		Staff staff = new Staff(name, birthDay, idNumber, phoneNumber, salary, username, password);
		HashMap<String, Staff> staffMap = handler.getStaffMap();
		
		if(staffMap.containsKey(username)){
			Notify.makeErrorAlert("Save error", "Username had been token");
		} else {
			if(_isAdmin.isSelected()){
				staff.setAdmin(true);
			} else {
				staff.setAdmin(false);
			}
			
			handler.addStaff(username, staff);
			handler.writeStaffData();
		}
		
	}
	
	@FXML
	private void handleCancelButton(ActionEvent event){
		((Stage)_name.getScene().getWindow()).close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handler = new StaffDataHandler();
	}
	
}
