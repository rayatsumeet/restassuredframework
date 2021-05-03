package Employeetestcasepackage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EmployeeBasepakchage.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class xmlreq extends TestBase  {
	
	String a ="IND";
	@Test
	public void buildRequest()
	{
		logger.info("starting");
		RestAssured.baseURI="http://webservices.oorsprong.org/websamples.countryinfo";
		
		httpRequest= 	RestAssured.given();
		String b= "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\r\n" + 
				"   <soapenv:Header/>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <web:CapitalCity>\r\n" + 
				"         <web:sCountryISOCode>"+a+"</web:sCountryISOCode>\r\n" + 
				"      </web:CapitalCity>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		httpRequest.header("Content-Type","text/xml");
		httpRequest.body(b);
		
		
		
		response=	httpRequest.request(Method.POST, "/CountryInfoService.wso?wsdl");
		
		Assert.assertTrue(response.getBody().asString()!=null);
		System.out.println(response.getBody().asString());
		
	}
	
	@Test(enabled=true)
	public void validate()
	{
		String a = response.getBody().asString();
		Assert.assertTrue(a.contains("New Delhi"));
		System.out.println(response.xmlPath().get("//soap:Body/m:CapitalCityResponse/m:CapitalCityResult"));
	//	Assert.assertTrue(response.xmlPath().get("//soap:Body/m:CapitalCityResponse/m:CapitalCityResult").equals("New Delhi"));
		
		Assert.assertEquals(response.xmlPath().get("//soap:Body/m:CapitalCityResponse/m:CapitalCityResult").toString(), "New Delhi");
	}

}
