package group3.mediaonestore.staff;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class StaffDataHandler{

	private final String CONFIG_FILE = "config.txt";
	
	private HashMap<String, Staff> staffMap;
	
	public StaffDataHandler(){
		staffMap = new HashMap<>();
		readStaffData();
	}
	
	public HashMap<String, Staff> readStaffData(){
		Gson gson = new Gson();
		Type mapType = new TypeToken<Map<String, Staff>>(){}.getType();
		try {
			staffMap = gson.fromJson(new FileReader(CONFIG_FILE), mapType);
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return staffMap;
	}
	
	public void writeStaffData(){
		Gson gson = new Gson();
		try {
			gson.toJson(staffMap,new FileWriter(CONFIG_FILE));
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addStaff(String username, Staff staff){
		staffMap.put(username, staff);
	}
	
	public HashMap<String , Staff> getStaffMap(){
		return staffMap;
	}
	
}
