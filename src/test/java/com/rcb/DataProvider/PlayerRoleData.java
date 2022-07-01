package com.rcb.DataProvider;

import com.rcb.Utilities.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class PlayerRoleData {
	@Test
	  @DataProvider(name="RcbTeamRole")
	  public Iterator<Object> readRcbRoleData() throws FileNotFoundException {
		 	
		  JsonPath jsonPath= JsonPath.given(new FileReader(new File(TestUtilities.filePath)));
		  List<Object> lst= jsonPath.getList("player.role");	   	  
		  return lst.iterator();
		  
	  }


}
