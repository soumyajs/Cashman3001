package com.poc.cashman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.poc.cashman.helper.CashmanHelper;
import com.poc.cashman.model.Denominations;
import com.poc.cashman.model.User;

public class CashDispenseDao {
	public Denominations initialize() {
		
		return CashmanHelper.initialize();
	}

	public String withdraw(Denominations deno) {
		return CashmanHelper.withdrawAmount(deno);
	}

	public Denominations checkAvailableDenominations() {
		return CashmanHelper.checkAvailableDenominations();
	}

	public boolean validateUser(User user) {
		if(user.getUsername().isEmpty() || user.getPassword().isEmpty()){
			return false;
		}else{
			return true;
		}
	}

	
}
