package group3.mediaonestore.ui.login;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import group3.mediaonestore.staff.Staff;
import group3.mediaonestore.staff.StaffDataHandler;
import group3.mediaonestore.ui.notify.Notify;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{

	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	
	private HashMap<String, Staff> staffMap;
	
	private StaffDataHandler handler;
	
	@FXML
	private void staffLoginButton(ActionEvent event){
		Staff staff = getStaff();
		
		if(staff!= null){
			if(staff.getAdmin()){
				
			}else{
				
			}
		}
	}
	
	@FXML
	private void customerLoginButton(ActionEvent event){
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handler = new StaffDataHandler();
	}
	
	private Staff getStaff(){
		String username = usernameField.getText();
		String password = passwordField.getText();
		
		staffMap = handler.readStaffData();
		
		Staff staff = null;
		
		if(staffMap.containsKey(username)){
			if(password.equals(staffMap.get(username).getPassword())){
				staff = staffMap.get(username);
			}else{
				Notify.makeErrorAlert("Login error", "Wrong password!");
			}
		}else {
			Notify.makeErrorAlert("Login error", "Wrong username!");
		}
		
		return staff;
	}
	
}
