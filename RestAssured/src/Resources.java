
public class Resources {

	public static String getResource(String reqUrl)
	{
		String url=null;
		
		switch(reqUrl)
		{
		case "googleplaceapi":
			url="/maps/api/place/nearbysearch/json/";
			break;
		}
		
		return url;
	}
}
