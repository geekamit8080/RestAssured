package TestCases;
import io.restassured.response.Response;

import java.io.IOException;

import org.testng.annotations.Test;

import FrameWork.FrameWorkCommonFunc;

public class GetRequest extends FrameWorkCommonFunc{

	FrameWorkCommonFunc fc = new FrameWorkCommonFunc();
	
	@Test
	public void getRequest1(){
		String url,firstId=null;
		Response rec=null;
		try {
			url=fc.InitUrl();
			if(!url.isEmpty()){
				rec=fc.getRequest("/api/users?page=2");
				System.out.println("extracted responce"+rec.toString());
				
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}//class GetRequest ends 
