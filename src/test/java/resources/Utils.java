package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification request;
	ResponseSpecification response;

	public RequestSpecification requestSpecification() throws IOException
	{
		if(request==null)
		{
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			request = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
					.setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.build();

			return request;
		}
		return request;
	}

	public ResponseSpecification responseSpecification()
	{
		response = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.expectStatusCode(200).build();

		return response;				
	}

	public String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Avinash\\RestAssuredAPI\\RestAssuredAPIFramework\\src\\test\\java\\resources\\Global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
		
	}

}
