package com.poc.cashman.service;

import com.poc.cashman.dao.CashDispenseDao;
import com.poc.cashman.helper.CashmanHelper;
import com.poc.cashman.model.Denominations;
import com.poc.cashman.model.User;

public class CashDispenseService {
	public Denominations initialize(){
		CashDispenseDao dao = new CashDispenseDao();
		return dao.initialize();
	}

	public Integer calculateTotal(Denominations deno) {
		return CashmanHelper.calculateTotal(deno);
	}
	
	public String withdraw (Denominations deno) {
		CashDispenseDao dao = new CashDispenseDao();
		return dao.withdraw(deno);
	}

	public Denominations checkAvailableDenominations() {
		CashDispenseDao dao = new CashDispenseDao();
		return dao.checkAvailableDenominations();
	}

	public boolean validateUser(User user) {
		
		CashDispenseDao dao = new CashDispenseDao();
		return dao.validateUser(user);
	}
	
	
}
