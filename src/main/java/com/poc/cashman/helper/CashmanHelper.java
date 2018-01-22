package com.poc.cashman.helper;

import java.util.HashMap;
import java.util.Map;

import com.poc.cashman.model.Denominations;

public class CashmanHelper {

	private static Map<String, Integer> currencyMap;

	public static Denominations initialize() {

		currencyMap = new HashMap<String, Integer>();
		currencyMap.put("20", 10);
		currencyMap.put("40", 10);
		currencyMap.put("50", 10);
		currencyMap.put("60", 10);
		currencyMap.put("70", 10);
		currencyMap.put("80", 10);
		currencyMap.put("100", 10);
		currencyMap.put("110", 10);
		currencyMap.put("150", 10);
		currencyMap.put("200", 10);
		

		return checkAvailableDenominations();
	}

	public static Denominations checkAvailableDenominations() {
		Denominations deno = new Denominations();

		deno.setTwennty(currencyMap.get("20"));
		deno.setForty(currencyMap.get("40"));
		deno.setFifty(currencyMap.get("50"));
		deno.setSixty(currencyMap.get("60"));
		deno.setSeventy(currencyMap.get("70"));
		deno.setEighty(currencyMap.get("80"));
		deno.setHundred(currencyMap.get("100"));
		deno.setHundredTen(currencyMap.get("110"));
		deno.setHundredFifty(currencyMap.get("150"));
		deno.setTwoHundred(currencyMap.get("200"));
		
		return deno;
	}

	public static Integer calculateTotal(Denominations deno) { 
		return (deno.getTwennty()*20) + (deno.getFifty()*50)+ (deno.getForty()*40)+(deno.getSixty()*60)+(deno.getSeventy()*70)+(deno.getEighty()*80)+(deno.getHundred()*100)+(deno.getHundredTen()*110)+(deno.getHundredFifty()*150)+(deno.getTwoHundred()*200);
	}
	
	

	public static String withdrawAmount(Denominations deno) {
		StringBuilder sb = null;
		int amount = deno.getAmount();
		int[] rupees = { 200, 150, 110, 100, 80, 70, 60, 50, 40, 20 };
		int[] count = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		for (int i = 0; i < rupees.length; i++) {
			if ((rupees[i] < amount || rupees[i] == amount) ){
				
				if(rupees[i] == 200 && currencyMap.get("50") > 3 && currencyMap.get("20") > 8){
					continue;
				}
				else if(currencyMap.get(String.valueOf(rupees[i])) >= amount / rupees[i]){
					count[i] = amount / rupees[i];
					amount = amount % rupees[i];
				}else if(currencyMap.get(String.valueOf(rupees[i])) < amount / rupees[i]){
					count[i] = currencyMap.get(String.valueOf(rupees[i]));
					amount = amount - (rupees[i] * currencyMap.get(String.valueOf(rupees[i])));
				}
				
				
			}else{
				continue;
			}
		}
		if(count.length >0){
			sb= new StringBuilder();
			sb.append("You have successfully withdrawn the amount ");
			sb.append(deno.getAmount());
			sb.append(" Followimg are the denominations...<br>" );
			for (int i = 0; i < count.length; i++) {
				if (count[i] != 0) {
					sb.append(rupees[i] + " * " + count[i] + " = " + (rupees[i] * count[i]));
					sb.append("</br>");
					if(rupees[i] == 200){
						currencyMap.put("200", currencyMap.get("200") -  count[i]);					
					}else if(rupees[i] == 150){
						currencyMap.put("150", currencyMap.get("150") -  count[i]);	
					}else if(rupees[i] == 110){
						currencyMap.put("110", currencyMap.get("110") -  count[i]);	
					}else if(rupees[i] == 100){
						currencyMap.put("100", currencyMap.get("100") -  count[i]);	
					}else if(rupees[i] == 80){
						currencyMap.put("80", currencyMap.get("80") -  count[i]);	
					}else if(rupees[i] == 70){
						currencyMap.put("70", currencyMap.get("70") -  count[i]);	
					}else if(rupees[i] == 60){
						currencyMap.put("60", currencyMap.get("60") -  count[i]);	
					}else if(rupees[i] == 50){
						currencyMap.put("50", currencyMap.get("50") -  count[i]);	
					}else if(rupees[i] == 40){
						currencyMap.put("40", currencyMap.get("40") -  count[i]);	
					}else if(rupees[i] == 20){
						currencyMap.put("20", currencyMap.get("20") -  count[i]);	
					}
				}
			}
		}else{
			throw new RuntimeException("Unable to dispense this amount");
		}
		return sb.toString();
	}
	
	
}
