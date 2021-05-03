package Employeetestcasepackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EmployeeBasepakchage.Base;

public class Derived extends Base {
	
@Test
	public void Derived()
	{
		log.info("derived log");
	System.out.println("Derived class");	
	}


}
