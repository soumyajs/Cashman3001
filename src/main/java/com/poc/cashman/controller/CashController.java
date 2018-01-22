package com.poc.cashman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import com.poc.cashman.model.Denominations;
import com.poc.cashman.model.User;
import com.poc.cashman.service.CashDispenseService;

@Controller
public class CashController {
	
	@PostConstruct
    public void init(){
		CashDispenseService service = new CashDispenseService();
		service.initialize();
        
    }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		User user = new User();
		model.addAttribute("userForm", user);
		return "login";

	} 
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateLogin(@ModelAttribute("userForm") User user, 
			@ModelAttribute("withdrawForm") Denominations denom,
			BindingResult result, Model model) {
		CashDispenseService service = new CashDispenseService();
		
		
		if(service.validateUser(user)){
			model.addAttribute("userName", user.getUsername());
			model.addAttribute("denominations", service.checkAvailableDenominations());
			model.addAttribute("total", service.calculateTotal(service.checkAvailableDenominations()));
			return "welcome";
		}else{
			model.addAttribute("error", "Please provide username and password");
			return "login";
		}
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdrawAmount(@ModelAttribute("withdrawForm") Denominations deno,
			BindingResult result, Model model) {
		try{
		CashDispenseService service = new CashDispenseService();
		model.addAttribute("result", service.withdraw(deno));
		model.addAttribute("denominations", service.checkAvailableDenominations());
		model.addAttribute("total", service.calculateTotal(service.checkAvailableDenominations()));
		
		}catch(RuntimeException ex){
			model.addAttribute("error", ex.getMessage());
		}				
		return "welcome";
	}
}
