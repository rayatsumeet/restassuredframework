package EmployeeBasepakchage;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.log4j.Level;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

public class TestBase {
	
	
public static RequestSpecification httpRequest;

public static Response response;
	
public String id="22"; //Hard coded - Input for Get details of Single Employee & update employee
	
	
	

public static Logger logger;	

	
@BeforeClass
public void setup(){
 
	
logger=Logger.getLogger("EmployeeBasepakchage");//added Logger
	
PropertyConfigurator.configure("log4j.properties"); //added logger
		
        logger.setLevel(Level.DEBUG);
		

	}




}
