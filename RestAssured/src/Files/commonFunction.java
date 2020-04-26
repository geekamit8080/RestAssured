package Files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;

public class commonFunction {

public Object returnXmlPath()
{
	String abc = "json";
	if(abc.equalsIgnoreCase("JSON"))
	{
	XmlPath xmlPath=new XmlPath(abc);
	return xmlPath;
	}
	else
	{
		JsonPath jsonPath= new JsonPath(abc);
		return jsonPath;
	}
}
}
