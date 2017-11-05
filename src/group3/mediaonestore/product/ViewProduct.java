package group3.mediaonestore.product;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewProduct implements Initializable{

	@FXML
	private TableView<Product> productTable;
	@FXML
	private TableColumn<Product, Integer> idCol;
	@FXML
	private TableColumn<Product, String> nameCol;
	@FXML
	private TableColumn<Product, String> categoryCol;
	@FXML
	private TableColumn<Product, Double> priceCol;
	@FXML
	private TableColumn<Product, Integer> quantityCol;
	@FXML
	private TableColumn<Product, String> descriptionCol;

	private ObservableList<Product> productList;
	
	private ProductDataHandler handler;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		handler = new ProductDataHandler();
		productList = FXCollections.observableArrayList();
		initCol();
		loadProduct();
	}
	
	private void loadProduct(){
		HashMap<Integer, Product> productMap = handler.readProductData();
		productList.addAll(productMap.values());
		productTable.getItems().addAll(productList);
	}
	
	private void initCol(){
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
	}
	
	@FXML
	private void handleEditButton(){
		
	}
	
	@FXML
	private void handleSaveButton(){
		
	}
	
}
