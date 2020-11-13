package restAPITesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import prerequisite.Prerequisite;
import resources.MyPayload;
import resources.Utils;

public class Pet extends Utils{

int ID;
	
	@Test(priority=1)
	public void addPet() throws IOException
	{
		RestAssured.baseURI = getGlobalValues();
		
		String resp = Prerequisite.getPetPreRequisite().body(MyPayload.getData(200, "doggie8821")).when()
		.post(getPetResources()).then().assertThat().statusCode(200).extract().response().asString();
	
		JsonPath js = getJsonPath(resp);
		ID = js.getInt("id");
		
	}
	
	@Test(priority=2)
	public void updatePet()
	{
	
		String resp = Prerequisite.getPetPreRequisite().body(MyPayload.getData(200 , "doggie8832")).when()
		.put(getPetResources()).then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = getJsonPath(resp);
		String updatedName = js.getString("name");
		Assert.assertEquals(updatedName, "doggie8832");
		
	}
	
	@Test(priority=3)
	public void getPetByStatus()
	{
		String getResp = Prerequisite.getPetPreRequisite().queryParam("status", "available")
		.when().get(getPetResources()+"/findByStatus").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = getJsonPath(getResp);
		int idCount = js.getInt("id.size()");
		for(int i=0; i<idCount; i++)
		{
			String names = js.getString("name["+i+"]");
			if(names.contains("doggie"))
			{
				Assert.assertTrue(true);
				break;
			}
			
		}
		
	}
	
	@Test(priority=4)
	public void updatePetWithFormData()
	{
		String updateResp = Prerequisite.getPetFormPreRequisite().pathParam("petId", ID).formParam("name", "doggie8843")
		.formParam("status", "sold").when().post(getPetResources()+"/{petId}").then().extract().response().asString();
		
		JsonPath js = getJsonPath(updateResp);
		int code = js.getInt("code");
		Assert.assertEquals(code, 200);
	}
	
	
	@Test(priority=5)
	public void deletePet()
	{
		String delResp = Prerequisite.getPetPreRequisite().pathParam("petId", ID).when().delete(getPetResources()+"/{petId}").then().extract()
		.response().asString();

		JsonPath js = getJsonPath(delResp);
		int code = js.getInt("code");
		Assert.assertEquals(code, 200);
	}

	
}
