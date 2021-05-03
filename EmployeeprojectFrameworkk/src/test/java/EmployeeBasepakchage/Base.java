package EmployeeBasepakchage;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base {
	
	public Logger log;
	@BeforeClass
	public void base()
	{
		
	System.out.println("base class");	

	 log = Logger.getLogger("Base.class");
	
	PropertyConfigurator.configure("log4j.properties");
	log.setLevel(Level.DEBUG);
	log.info("from base");
	
	}

}
