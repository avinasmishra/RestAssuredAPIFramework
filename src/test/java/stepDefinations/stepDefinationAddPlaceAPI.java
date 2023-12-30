package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ResourceEnumAPI;
import resources.TestData;
import resources.Utils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.IOException;


public class stepDefinationAddPlaceAPI extends Utils{
	RequestSpecification reqBody;
	ResponseSpecification resspec;
	Response response;
	static String place_id;

	@Given("add input payload details with {string} {string} {string}")
	public void add_input_payload_details_with(String name, String language, String address) throws IOException {

		reqBody = given().spec(requestSpecification()).relaxedHTTPSValidation().body(new TestData().AddPlaceTestData(name,language,address));

	}
	@When("user submit {string} api with http {string} request")
	public void user_submit_api_with_http_request(String resource, String method) {
		
		
		ResourceEnumAPI resourceAPI = ResourceEnumAPI.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("POST"))
			response = reqBody.when().post(resourceAPI.getResource())
			.then().spec(responseSpecification()).extract().response();
		else if(method.equalsIgnoreCase("GET"))
			response = reqBody.when().get(resourceAPI.getResource())
					.then().spec(responseSpecification()).extract().response();
		else if(method.equalsIgnoreCase("PUT"))
			response = reqBody.when().put(resourceAPI.getResource())
					.then().spec(responseSpecification()).extract().response();
		else if(method.equalsIgnoreCase("Delete"))
			response = reqBody.when().delete(resourceAPI.getResource())
					.then().spec(responseSpecification()).extract().response();
		
	}
	@Then("verify the status code {int}")
	public void verify_the_status_code(Integer expectedCode) {
		assertEquals(response.getStatusCode(),200);

	}
	@Then("verify the {string} in response body is {string}")
	public void verify_the_in_response_body_is(String key, String value) {
		assertEquals(getJsonPath(response,key), value);

	}
	@Then("verify placeId creted and maps to {string} using {string}")
	public void verify_place_id_creted_and_maps_to_using(String expectedName, String resource) throws IOException {
		place_id = getJsonPath(response, "place_id");
		System.out.println("Place_Id: "+place_id);
		reqBody = given().spec(requestSpecification()).relaxedHTTPSValidation().queryParam("place_id", place_id);	
		user_submit_api_with_http_request(resource,"GET");

		String actualName = getJsonPath(response, "name");
		assertEquals(actualName,expectedName);
		
	}
	@Given("deletePlace payload")
	public void delete_place_payload() throws IOException {
	    reqBody = given().spec(requestSpecification()).body(new TestData().deletePlaceAPIPayload(place_id));
	    
	}
	


}
