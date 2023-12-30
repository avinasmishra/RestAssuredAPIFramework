package resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlaceRequest;
import POJO.Location;

public class TestData {

	public AddPlaceRequest AddPlaceTestData(String name, String language,String address)
	{
		AddPlaceRequest ap = new AddPlaceRequest();
		ap.setAccuracy(50);
		ap.setName(name);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setWebsite("http://google.com");
		ap.setPhone_number("(+91) 983 893 3937");

		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);

		ap.setLocation(location);

		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		ap.setTypes(myList);
		return ap;

	}
	public String deletePlaceAPIPayload(String placeId)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+placeId+"\"\r\n"
				+ "}";
	}

}
