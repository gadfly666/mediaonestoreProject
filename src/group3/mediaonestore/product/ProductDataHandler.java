package group3.mediaonestore.product;

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

public class ProductDataHandler {

	private final String CONFIG_FILE = "product.txt";
	
	public HashMap<Integer, Product> readProductData(){
		Gson gson = new Gson();
		Type mapType = new TypeToken<Map<Integer, Product>>(){}.getType();
		HashMap<Integer, Product> productMap =  new HashMap<>();
		try {
			productMap = gson.fromJson(new FileReader(CONFIG_FILE), mapType);
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return productMap;
	}
	
	public void writeProductData(int id, Product product){
		HashMap<Integer, Product> productMap = readProductData();
		Gson gson = new Gson();
		FileWriter writer = null;
		if(productMap == null){
			productMap = new HashMap<>();
		}
		productMap.put(id, product);
		try {
			writer = new FileWriter(CONFIG_FILE);
			String jsonString = gson.toJson(productMap);
			writer.write(jsonString);
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				writer.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
