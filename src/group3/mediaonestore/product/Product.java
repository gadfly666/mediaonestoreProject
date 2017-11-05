package group3.mediaonestore.product;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {

	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty category;
	private SimpleDoubleProperty price;
	private SimpleIntegerProperty quantity;
	private SimpleStringProperty description;
	
	public Product(){
		
	}
	
	public Product(int id, String name,String category, double price,int quantity, String description){
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.category = new SimpleStringProperty(category);
		this.price = new SimpleDoubleProperty(price);
		this.quantity = new SimpleIntegerProperty(quantity);
		this.description = new SimpleStringProperty(description);
	}
	
	public int getId(){
		return id.get();
	}
	
	public String getName(){
		return name.get();
	}
	
	public String getCategory(){
		return category.get();
	}
	
	public double getPrice(){
		return price.get();
	}
	
	public int getQuantity(){
		return quantity.get();
	}
	
	public String getDescription(){
		return description.get();
	}

}

