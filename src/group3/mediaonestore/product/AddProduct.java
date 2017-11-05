package group3.mediaonestore.product;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import group3.mediaonestore.ui.notify.Notify;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddProduct implements Initializable {

	@FXML
	private AnchorPane rootPane;
	@FXML
	private TextField nameField, priceField, quantityField;
	@FXML
	private TextArea descriptionArea;
	@FXML
	private ComboBox<String> categoryBox;
	
	private ObservableList<String> categoryList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		categoryList = FXCollections.observableArrayList();
		categoryList.addAll("Book", "Music Disc", "Movie Disc");
		categoryBox.setItems(categoryList);
		
	}
	
	@FXML
	public void handleSaveButton(ActionEvent event){
		ProductDataHandler handler = new ProductDataHandler();
		HashMap<Integer, Product> productMap = handler.readProductData();
		if(validateInput()){
			int counter = 0;
			if(productMap != null){
				counter = productMap.size();
			}
			int id = counter++;
			String name = nameField.getText();
			String category = categoryBox.getSelectionModel().getSelectedItem();
			double price = Double.parseDouble(priceField.getText());
			int quantity = Integer.parseInt(quantityField.getText());
			String description = descriptionArea.getText();
			
			Product product = new Product(id, name, category, price, quantity, description);
			handler.writeProductData(id, product);
		}
	}
	
	@FXML
	public void handleCancelButton(ActionEvent event){
		((Stage)rootPane.getScene().getWindow()).close();
	}
	
	private boolean validateInput(){
		String errorMessage = "";
		
		if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }

        if (priceField.getText() == null || priceField.getText().length() == 0) {
            errorMessage += "No valid price!\n";
        }

        if (quantityField.getText() == null || quantityField.getText().length() == 0) {
            errorMessage += "No valid quantity!\n";
        }

        if (descriptionArea.getText() == null || descriptionArea.getText().length() == 0) {
            errorMessage += "No email description!\n";
        }

        if (categoryBox.getSelectionModel().isEmpty()) {
            errorMessage += "Please select the category!\n";
        }
        
        if(errorMessage.length() == 0){
        	return true;
        }else {
        	Notify.makeErrorAlert("Invalid fields ", errorMessage);
        	return false;
        }
	}
	
}
