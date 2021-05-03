package Employeetestcasepackage;

import org.testng.Assert;
import Employeeutilitypackage.RestUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EmployeeBasepakchage.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;

public class reqres extends TestBase  {
	
//	public void  d()
//	{
//		abb();
//	}
	
	int a ;
	@BeforeClass
	public  void testingData()
	{
		logger.info("insidetesting data checking data is there");
		RestAssured.baseURI ="https://reqres.in/";
		
		httpRequest= 	RestAssured.given();
		
	response= 	httpRequest.request(Method.GET,"/api/unknown/2");

	Assert.assertTrue(response.getBody().asString()!=null);
	
 a = response.jsonPath().get("data.id");

System.out.println(a);

	//System.out.println(response.getBody().asString());


		
		
	}
	
	//TestBase.testingData();
	
	@Test(enabled = true)
	void checkdata()
	{
		logger.info("inside method check data checking the data");
	String n=	response.getBody().asString();
	Assert.assertTrue(n.contains("id")); 	;
	Assert.assertTrue(n.contains("name"))	;
	Assert.assertTrue (n.contains("year"))	;
	Assert.assertTrue (n.contains("color"))	;
	Assert.assertTrue(n.contains("pantone_value"));
	Assert.assertEquals(response.jsonPath().get("data.pantone_value"), "17-2031");
	Assert.assertEquals(response.jsonPath().get("data.id"), 2);

	}
	
	@Test(enabled = true)
	void printheader()
	{
	Headers h= 	response.getHeaders();
	
	for(Header h1: h)
	{
		System.out.println(h1.getName()+ " " + h1.getValue());
	}
	
	
	}                   
		
	@Test(enabled =true)
	void checkstatuscode() {
		logger.info("checking status code to be 200");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(enabled= false)
	void checktime()
	{
		logger.info("checking time taken ======");
		
		Assert.assertTrue(response.getTime() < 1000);
	}
	@AfterClass	
	void teardown()
	{
		logger.info("end of test cases");
		
		
	}
	

}
