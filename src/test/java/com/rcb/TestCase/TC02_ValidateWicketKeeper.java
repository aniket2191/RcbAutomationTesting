package com.rcb.TestCase;

import com.rcb.DataProvider.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import com.rcb.Utilities.TestUtilities;

public class TC02_ValidateWicketKeeper extends TestUtilities {
	
	/*
	@Test(dataProvider = "RcbTeamRole", dataProviderClass=PlayerRoleData.class)
	public void ForeignPlayersCount(Object role) {
		
		if(role.equals("Wicket-keeper"))
			++TestUtilities.wicketKeeperCount;	
			
	  }
	  */
	@Test(dataProvider = "RcbTeamRole", dataProviderClass=PlayerRoleData.class)
	public void noOfWicketKeeper(Object role) {
		
		if(role.equals("Wicket-keeper"))
			++TestUtilities.wicketKeeperCount;	
			
	  }
	
	@Test(priority = 1)
	public void atLeastOneWicketKeeper() {
		
		logger.info("************Start_TC02_ValidateWicketKeeper****************");
		
		logger.info("Validation for the at least one wicket-keeper requirement..");
		logger.info("Total Number Of Wicket-keepers : "+wicketKeeperCount);
	    assertNotEquals(0,wicketKeeperCount);
		logger.info("Team has at least one Wicket-Keeper ");
		
		logger.info("************End_TC02_ValidateWicketKeeper****************");
	}

}
