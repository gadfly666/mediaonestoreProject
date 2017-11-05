package group3.mediaonestore.staff;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewStaffController implements Initializable{

	@FXML
	private TableView<Staff> staffTable;
	@FXML
	private TableColumn<Staff, String> nameCol;
	@FXML
	private TableColumn<Staff, String> birthDayCol;
	@FXML
	private TableColumn<Staff, String> idNumberCol;
	@FXML
	private TableColumn<Staff, String> phoneNumberCol;
	@FXML
	private TableColumn<Staff, Double> salaryCol;
	@FXML
	private TableColumn<Staff, Boolean> isAdminCol;
	
	private ObservableList<Staff> staffList;
	
	private StaffDataHandler handler;
	
	@FXML
	private void handleEditButton(ActionEvent event){
		
	}
	
	@FXML
	private void handlerSaveButton(ActionEvent event){
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		staffList = FXCollections.observableArrayList();
		handler = new StaffDataHandler();
		initColumn();
		loadStaff();
	}
	
	private void initColumn(){
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		birthDayCol.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
		idNumberCol.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
		phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
		isAdminCol.setCellValueFactory(new PropertyValueFactory<>("isAdmin"));
	}
	
	private void loadStaff(){
		HashMap<String , Staff> staffMap = handler.readStaffData();
		staffList.addAll(staffMap.values());
		staffTable.getItems().addAll(staffList);
	}
	
}
