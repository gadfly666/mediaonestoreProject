package group3.mediaonestore.ui.loader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowLoader {

	private Stage window;
	
	private static WindowLoader loader;
	
	public static WindowLoader getLoader()
	{
		if(loader == null)
		{
			loader = new WindowLoader();
		}
		
		return loader;
	}
	
	public WindowLoader()
	{
		window = new Stage();
	}
	
	public void loadWindow(String path) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource(path));
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.show();
	}
	
}
