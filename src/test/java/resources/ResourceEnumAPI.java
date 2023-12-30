package resources;

public enum ResourceEnumAPI {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;

	ResourceEnumAPI(String resource) {
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
