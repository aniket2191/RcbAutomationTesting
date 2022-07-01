package com.rcb.TestCase;
import com.rcb.DataProvider.*;
import com.rcb.Utilities.TestUtilities;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;



public class TC01_ValidateForeignPlayers extends TestUtilities{


	
	@Test(dataProvider = "RcbTeam_Country", dataProviderClass=PlayerCountryData.class)
	public void ForeignPlayersCount(Object country) {
		
		if(!country.equals("India"))
			++TestUtilities.foreignPlayerCount;
				
	  }	
	@Test(priority = 1)
	public void teamHas4ForeignPlayers() {
		
		logger.info("************Start_TC01_ValidateForeignPlayers****************");
		
		logger.info("Validation for team has only four foreign players requirement..");
		logger.info("Total Number Of foreign Players : "+foreignPlayerCount);
		assertEquals(4, TestUtilities.foreignPlayerCount);
		logger.info("Team has Only four foreign Players.. ");
		
		logger.info("************End_TC01_ValidateForeignPlayers****************");
					
	}
  
  
}

