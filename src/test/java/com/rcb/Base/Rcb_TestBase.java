package com.rcb.Base;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rcb_TestBase {

	public Logger logger;
	

  @BeforeClass
  public void setUp() {
	  
   logger=Logger.getLogger("RcbLog");
   PropertyConfigurator.configure(".//propertyfile/log4j.properties");
   logger.setLevel(Level.DEBUG);
   
  }
}
