package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;

public class Utils {

	Properties prop;
	public String getGlobalValues() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String URI = prop.getProperty("BaseURI");
		return URI;
	}
	
	public JsonPath getJsonPath(String response)
	{
		JsonPath js = new JsonPath(response);
		return js;
	}
	
	public String getPetResources()
	{
		String resources = prop.getProperty("petResource");
		return resources;
	}
	
	public String getStoreResources()
	{
		String resources = prop.getProperty("storeResource");
		return resources;
	}
	
}
