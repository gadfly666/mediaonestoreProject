package group3.mediaonestore.staff;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Staff {
	
	private SimpleStringProperty name;
	private SimpleStringProperty birthDay;
	private SimpleStringProperty idNumber;
	private SimpleStringProperty phoneNumber;
	
	private SimpleDoubleProperty salary;
	
	private String username;
	private String password;
	
	private SimpleBooleanProperty isAdmin;
	
	public Staff(String name, String birthDay, String idNumber, String phoneNumber, double salary, String username, String password){
		this.name = new SimpleStringProperty(name);
		this.birthDay = new SimpleStringProperty(birthDay);
		this.idNumber = new SimpleStringProperty(idNumber);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.salary = new SimpleDoubleProperty(salary);
		this.username =	username;
		this.password = password;
		this.isAdmin = new SimpleBooleanProperty(false);

	}
	
	public String getName(){
		return name.get();
	}
	
	public void setName(String name){
		this.name.setValue(name);
	}
	
	public String getBirthDay(){
		return birthDay.get();
	}
	
	public void setBirthDay(String birthDay){
		this.birthDay.setValue(birthDay);
	}
	
	public String getIdNumber(){
		return idNumber.get();
	}
	
	public void setIdNumber(String idNumber){
		this.idNumber.setValue(idNumber);
	}
	
	public String getPhoneNumber(){
		return phoneNumber.get();
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber.setValue(phoneNumber);
	}
	
	public double getSalary(){
		return salary.get();
	}
	
	public void setSalary(double salary){
		this.salary.setValue(salary);
	}
	
	public boolean getAdmin(){
		return isAdmin.get();
	}
	
	public void setAdmin(boolean isAdmin){
		this.isAdmin.setValue(isAdmin);
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
}
