package restAPITesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import prerequisite.Prerequisite;
import resources.MyPayload;
import resources.Utils;

public class Store extends Utils{

int ID;
	
	@Test(priority=6)
	public void addOrderForPet() throws IOException
	{
		RestAssured.baseURI = getGlobalValues();;
		
		String placeOrderResponse = Prerequisite.getPetPreRequisite().body(MyPayload.getDataStore(6))
		.when().post(getStoreResources()).then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = getJsonPath(placeOrderResponse);
		ID = js.getInt("id");
		
	}
	
	@Test(priority=7)
	public void getPurchaseOrderByID()
	{
		String getResponse = Prerequisite.getPetPreRequisite().pathParam("orderId", ID)
		.when().get(getStoreResources()+"/{orderId}").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = getJsonPath(getResponse);
		String Status = js.getString("status");
		Assert.assertEquals(Status, "placed");
	}
	
	@Test(priority=8)
	public void removePurchaseOrderByID()
	{
		String deleteResponse = Prerequisite.getPetPreRequisite().pathParam("orderId", ID)
				.when().delete(getStoreResources()+"/{orderId}").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = getJsonPath(deleteResponse);
		int Code = js.getInt("code");
		Assert.assertEquals(Code, 200);
	}
	
}

