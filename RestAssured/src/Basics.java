import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;


public class Basics {

	@Test(enabled=false)
	public void test()
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://maps.googleapis.com";
		given().
		param("location","-33.8670522,151.1957362").
		param("radius","1500").
		param("key","AIzaSyDY3PkhFEtpLT5hJvkXHC_sgJ0tU67lYKg").
		when().
		get("/maps/api/place/nearbysearch/json").
		then().contentType(ContentType.JSON).and().statusCode(200).and().
		body("results[0].name",equalTo("Sydney")).and()
		.header("server", "scaffolding on HTTPServer2");
	}//test ends

	//Post request
	@Test(enabled=false) //post request
	public void postTest()
	{
		RestAssured.baseURI="https://reqres.in";
	
		given().
			body("{\"name\": \"amit\",\"job\": \"leader\"}").
		when().
			post("/api/users").
		then().
				statusCode(201).and().contentType(ContentType.JSON);
	}
	
	//basic get request
	@Test(enabled=false)
	public void getdata()

	{
		RestAssured.baseURI="https://reqres.in";
		String strRes;
		Response res=
		given().
		 	   param("page","1").
		when().
			  get("/api/users").
	   then().contentType(ContentType.JSON).and().statusCode(200).
	   extract().response();
	
		strRes=res.asString();
		System.out.print("Extracting the `:-" + strRes +"\n");
		
		JsonPath js= new JsonPath(res.asString());
		String var=js.get("data[0].first_name");
		
		System.out.println("This is the Json variable:-"+var);
	}

	//public void deleteRequest
	@Test(enabled=true)
	public void deletedata()
	{
		RestAssured.baseURI="https://reqres.in";
		String strRes;
		Response res=
		given().
		 	   param("page","1").
		when().
			  get("/api/users").
	   then().contentType(ContentType.JSON).and().statusCode(200).
	   extract().response();
	
		strRes=res.asString();
		System.out.print("Extracting the responce:-" + strRes +"\n");
		
		JsonPath js= new JsonPath(res.asString());
		//String var=js.get("data[0].first_name");
		//System.out.println("This record is being get deleted:-"+var);
		
		for(int i=0;i<6;i++)
		{
			System.out.println(js.get("data["+i+"].first_name"));
		}
		
	}
}//class ends


