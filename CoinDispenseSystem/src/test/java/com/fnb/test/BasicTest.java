package com.fnb.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fnb.coindispensesystem.data.DenominationBreakdownImpl;
import com.fnb.coindispensesystem.data.UserRepository;
import com.fnb.coindispensesystem.model.NotesBreackdown;

public class BasicTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	/**
	 * Calculate dinomination using positive data
	 */
	@Test
	public void testCalculateDenomination(){
		BigDecimal testDecimal = new BigDecimal(50.00);
		DenominationBreakdownImpl dbi = new DenominationBreakdownImpl();
		
		List<NotesBreackdown> lst = new ArrayList<>();
		
		lst=dbi.calculateDenomination(testDecimal);
		
//		for (List<String> alist:lst){
//			
//		}	
			
	}
	
	public void tesFindUser(){
		UserRepository ur = new UserRepository();
		String usename= "Benny";
		ur.findUser(username, password)
	}
	
}
