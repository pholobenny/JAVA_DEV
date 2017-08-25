package com.fnb.coindispensesystem.data;

/**
 * @author Benny Pholo
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fnb.coindispensesystem.model.NotesBreackdown;
import com.fnb.coindispensesystem.service.DenominationBreakdown;

public class DenominationBreakdownImpl implements DenominationBreakdown{

	/*public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Amount:");		

	}*/

	@Override
	public List<NotesBreackdown> calculateDenomination(BigDecimal notes) {
		
		List<NotesBreackdown> resultsList =new ArrayList<>();
		NotesBreackdown nb = new NotesBreackdown();
		//bigDecimal no
		int[] rand = { 100, 50, 20, 10, 5, 2, 1 };
		int[] coin = { 50, 25, 05 };
		int[] count = { 0, 0, 0, 0, 0, 0, 0 };
		int[] count_cents = { 0, 0, 0 };
		int rand_d = 0;
		int coin_d = 0;

		BigDecimal amount_due = new BigDecimal(25.50);
		notes = notes.subtract(amount_due);
		System.out.println("*********"+notes.doubleValue());
		notes.doubleValue();
		String str = notes.toString();
		System.out.println(str);
		if (str.contains(".")){
		String strArray[] = str.split("\\.");
		 rand_d = Integer.parseInt(strArray[0]);
		 coin_d = Integer.parseInt(strArray[1]);
		}else{
		  rand_d = Integer.parseInt(str);
		//coin_d = Integer.parseInt(strArray[1]);
		}
		System.out.println(rand_d + " - " + coin_d);
		System.out.println("*****************************");
		// amount = money.

		for (int i = 0; i < rand.length; i++) {
			if (rand[i] < rand_d || rand[i] == rand_d) {
				count[i] = rand_d / rand[i];
				rand_d = rand_d % rand[i];
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				System.out.println(count[i] + " x R" + rand[i]);
				
				String cnt=String.valueOf(count[i]);
				String rnd= String.valueOf(rand[i]);
				
				nb = new NotesBreackdown(cnt, " x R" +rnd);
				
				//String results= count[i] + " x R" + rand[i];
				resultsList.add(nb);
				
			}
		}

		// Coins
		for (int i = 0; i < coin.length; i++) {
			if (coin[i] < coin_d || coin[i] == coin_d) {
				count_cents[i] = coin_d / coin[i];
				coin_d = coin_d % coin[i];
			}
		}
		for (int i = 0; i < count_cents.length; i++) {
			if (count_cents[i] != 0) {
				System.out.println(count_cents[i] + " x " + coin[i] + "c");
				String cntc= String.valueOf(count_cents[i]);
				String con= String.valueOf(coin[i]);				
				nb = new NotesBreackdown(cntc," x " +con+ "c");				
				//String results = count_cents[i] + " x " + coin[i] + "c";
				resultsList.add(nb);
			}
		}
		System.out.println("********List values********");
		System.out.println(resultsList.get(0));
		System.out.println("********List values********");
		
		
		return resultsList;
	}
}
