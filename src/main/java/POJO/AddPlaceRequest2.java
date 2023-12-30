package POJO;

import java.util.List;

public class AddPlaceRequest2 extends Object{
	private Location2 location;
	private Object accuracy;
	private Object name;
	private Object phone_number;
	private Object address;
	private List<Object> types;
	private Object website;
	private Object language;
	
	public Object getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Object accuracy) {
		this.accuracy = accuracy;
	}
	public Object getName() {
		return name;
	}
	public void setName(Object name) {
		this.name = name;
	}
	public Object getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Object phone_number) {
		this.phone_number = phone_number;
	}
	public Object getAddress() {
		return address;
	}
	public void setAddress(Object address) {
		this.address = address;
	}
	public List<Object> getTypes() {
		return types;
	}
	public void setTypes(List<Object> types) {
		this.types = types;
	}
	public Object getWebsite() {
		return website;
	}
	public void setWebsite(Object website) {
		this.website = website;
	}
	public Object getLanguage() {
		return language;
	}
	public void setLanguage(Object language) {
		this.language = language;
	}	
	public Location2 getLocation() {
		return location;
	}
	public void setLocation(Location2 location) {
		this.location = location;
	}
	
	
	public String toString()
	{
		return 	"User{" + 
				", location=" + location +
				", accuracy=" + accuracy+
				", name=" +name +
				", phone_number=" +phone_number +
				", address=" +address +
				", types=" +types +
				", website=" + website+
				", language=" + language+
				'}';
	}

}
