package FrameWork;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;



//Basic frame work oprtational functions which is building block of this framework//

/**
 * 
 * @author Amit
 * @version 1.0
 * <a> getBaseUrl </a>
 * Function get valid Base Url from program  
 */

public class FrameWorkCommonFunc {

	/**
	 * 
	 * @author Amit
	 * @version 1.0
	 * <a> InitUrl </a>
	 * Function InitUrl to initalize the base url in properties file  
	 */
	public String InitUrl() throws IOException
	{
		Properties prop = new Properties();
		FileReader reader=new FileReader("C:\\Users\\Amit\\Workspaces\\Eclipse IDE for Java EE Developers 441\\BasicRestFramework\\endpoint.properies");
		prop.load(reader);
		RestAssured.baseURI=prop.getProperty("baseUrl");
		Response res= given(). 
				when().get(prop.getProperty("baseUrl")).then(). 
				statusCode(200).extract().response();
		if(res.asString().length()<1){
			System.out.println("Base Url "+prop.getProperty("baseUrl")+" is not correct");
			return prop.getProperty("baseUrl");
		}
		else
		{
			System.out.println("Base Url "+(String)prop.getProperty("baseUrl")+"is valid");	
			return prop.getProperty("baseUrl");
		}
	}

	/**
	 * 
	 * @author Amit
	 * @version 1.0
	 * <a> putRequest </a>
	 * Function putRequest and return the responce  
	 */
	public Response putRequest(String request,String reqbody)
	{
		Response rec=null;
		try
		{
			String baseUrl=InitUrl();
			RestAssured.baseURI=baseUrl;
			rec = 
					given().body(reqbody).
					when().put(request).then().statusCode(200).and().contentType(ContentType.JSON). 
					extract().response();

			if(rec.asString().length()<1)
			{
				System.out.println("Failed to put the request check with request" + request + "and responce body"+reqbody);
				return null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rec;
	}

	/**
	 * 
	 * @author Amit
	 * @version 1.0
	 * <a> getRequest </a>
	 * Function putRequest and return the responce  
	 * @throws IOException 
	 */
	public Response getRequest(String request) 
	{
		Response rec=null;

		try
		{
			String BaseUrl=InitUrl();
			RestAssured.baseURI=BaseUrl;

			rec = given().
					when().get(request).
					then().contentType(ContentType.JSON).and().statusCode(200).extract().response();

			if(rec.asString().length()<1)
			{
				System.out.println("Failed get Request check with base url:-"+BaseUrl+"and get request"+ request);
				return null;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return rec;
	}

	/**
	 * 
	 * @author Amit
	 * @version 1.0
	 * <a> getJsonVal </a>
//	 * Function getJsonVal returns the exact string value from expected Json path  
	 * @throws IOException 
	 */
	public String getJsonVal(Response res,String JsonPath){

		String expectedVal=null;

		JsonPath js= new JsonPath(res.asString());
		expectedVal=js.get(JsonPath);

		if(expectedVal.isEmpty()){
			System.out.println("Wrong Json path:" + JsonPath + "or not expected responce:" + res.asString() + "generated");
			return null;
		}
		System.out.println("Return string:-" + expectedVal);
		return expectedVal;
	}
	
	//Just for temp delete it letter 
	public static void main(String cp[]) throws IOException
	{
		FrameWorkCommonFunc fc= new FrameWorkCommonFunc();
		Response rec=fc.getRequest("/api/users?page=2");
		System.out.println(rec.asString());

	}
}//class ends
