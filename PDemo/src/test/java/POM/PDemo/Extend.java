package POM.PDemo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extend {


	public static void main(String cp[])
	{	
		ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("C:\\Users\\Amit\\Workspaces\\Eclipse IDE for Java EE Developers 441\\PDemo\\Logs\\extent.html");
		
		//Extent Reports
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		
		//Test
		ExtentTest test=extent.createTest("Testcase1");
		
		//Log info
		int a=5,b=6;
		test.log(Status.INFO, "first step of test case");
	
		extent.flush();
		System.out.println("Completed");
		System.out.println("Yes");
	}//main ends 
	
}//class ends 
