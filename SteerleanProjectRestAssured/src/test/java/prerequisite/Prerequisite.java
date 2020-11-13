package prerequisite;

import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;

public class Prerequisite {

	public static RequestSpecification getPetPreRequisite()
	{
		RequestSpecification rs = given().log().all().header("Content-Type", "application/json");
		return rs;
	}
	
	public static RequestSpecification getPetFormPreRequisite()
	{
		RequestSpecification rs = given().log().all().header("Content-Type", "application/json", "application/x-www-form-urlencoded");
		return rs;
	}
}
