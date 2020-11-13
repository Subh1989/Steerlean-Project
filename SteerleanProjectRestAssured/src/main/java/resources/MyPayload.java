package resources;

public class MyPayload {

	public static String getData(int ID, String petName)
	{

		String s = "{\r\n" + 
				"  \"id\": "+ID+",\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \"string\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \""+petName+"\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \"string\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 0,\r\n" + 
				"      \"name\": \"string\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \"available\"\r\n" + 
				"}";
		
		return s;
	}
	
	public static String getDataStore(int ID)
	{
		String a = "{\r\n" + 
				"  \"id\": "+ID+",\r\n" + 
				"  \"petId\": 0,\r\n" + 
				"  \"quantity\": 0,\r\n" + 
				"  \"shipDate\": \"2020-11-12T13:16:51.592Z\",\r\n" + 
				"  \"status\": \"placed\",\r\n" + 
				"  \"complete\": true\r\n" + 
				"}";
		return a;
	}
}
