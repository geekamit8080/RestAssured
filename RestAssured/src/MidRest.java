import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import io.restassured.response.Response;

import org.testng.annotations.Test;


public class MidRest {

	
	//Getting the api strings from properties files
	@Test
	public void get() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Amit\\Workspaces\\Eclipse IDE for Java EE Developers 441\\RestAssured\\src\\env.properies");
		prop.load(fis);
	
		RestAssured.baseURI=(String)prop.getProperty("host");

		Response respnc=
		given().
		param("location","-33.8670522,151.1957362").
		param("radius","1500").
		param("key","AIzaSyDY3PkhFEtpLT5hJvkXHC_sgJ0tU67lYKg").
		when().
		get((String)Resources.getResource("googleplaceapi")).
		then().statusCode(200).and().contentType(ContentType.JSON).and().
		body("results[0].name",equalTo("Sydney")).extract().response();
		
		System.out.println(respnc.asString());
	}
}//class ends
