package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks 
{
	//execute this code only when place id is null
	//write a code that will generate place id
	
	@Before("@DeletePlace")
	public void beforeScenarioGetExecute() throws IOException
	{
		stepDefinationAddPlaceAPI sdm = new stepDefinationAddPlaceAPI();
		if(stepDefinationAddPlaceAPI.place_id==null)
		{
			sdm.add_input_payload_details_with("Ram", "French", "Asia");
			sdm.user_submit_api_with_http_request("AddPlaceAPI", "post");
			sdm.verify_place_id_creted_and_maps_to_using("Ram", "getPlaceAPI");
			
		}

	}
}
