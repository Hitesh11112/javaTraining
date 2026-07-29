package com.coforge.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.entities.Account;

@Controller
//@ResponseBody
public class AccountController {
	
	ArrayList<Account> accountList = new ArrayList<>();

	@PostConstruct
	public void init() {
		accountList.add(new Account(100001L, "Rahul Sharma", "SBI", "MG Road, Bengaluru", 50000.00));
		accountList.add(new Account(100002L, "Priya Singh", "HDFC", "Connaught Place, Delhi", 75000.50));
		accountList.add(new Account(100003L, "Amit Kumar", "ICICI", "FC Road, Pune", 32000.75));
		accountList.add(new Account(100004L, "Sneha Reddy", "Axis Bank", "Banjara Hills, Hyderabad", 89000.00));
		accountList.add(new Account(100005L, "Vikram Patel", "PNB", "SG Highway, Ahmedabad", 45000.25));
		accountList.add(new Account(100006L, "Neha Gupta", "Canara Bank", "Park Street, Kolkata", 61000.00));
		accountList.add(new Account(100007L, "Arjun Verma", "Bank of Baroda", "Civil Lines, Lucknow", 27500.00));
		accountList.add(new Account(100008L, "Pooja Nair", "Kotak Mahindra", "Marine Drive, Mumbai", 99000.80));
		accountList.add(new Account(100009L, "Rohit Mehta", "Union Bank", "Sector 17, Chandigarh", 41000.60));
		accountList.add(new Account(100010L, "Anjali Joshi", "Indian Bank", "Anna Salai, Chennai", 56000.90));
	}
	
    @RequestMapping("/accounts")
    public ModelAndView getAllAccounts(Model model) {    	
    	
    	ModelAndView mv  = new ModelAndView();
        mv.addObject("accountList",accountList);
        mv.setViewName("list"); //(/WEB-INF/views/list.jsp)
        
        return mv;
    }
    @RequestMapping("/accounts/add")
    public String addAccountString(Model model) {
    	model.addAttribute("account",new Account());
    	return "add-account";
    }
    
    @RequestMapping(value="/accounts/create",method=RequestMethod.POST)
    public String createAccount(@ModelAttribute Account account, Model model) {
    	accountList.add(account);
    	return "redirect:/accounts";
    }
    
    @RequestMapping("/accounts/update/{accNo}")
    public String updateAccountForm(@PathVariable("accNo") long accNo, Model model) {
    	
    	Account acc = null;
    	for(Account ac : accountList) {
    		if(ac.getAccNo() == accNo) {
    			acc=ac;
    			break;
    		}
    	}
    	model.addAttribute("account",acc);
    	return "update-account";
    }
    
    @RequestMapping(value="/accounts/modify",method=RequestMethod.POST)
    public String updateAccount(@ModelAttribute("account") Account account) {
    	
    	for(Account ac : accountList) {
    		if(ac.getAccNo() == account.getAccNo()) {
	    		ac.setAccHolderName(account.getAccHolderName());
	    		ac.setBankName(account.getBankName());
	    		//TODO: address also 
	    		ac.setBalance(account.getBalance());
	    		break;
    		}
    	}
    	
    	return "redirect:/accounts";
    }
    
    @RequestMapping("/accounts/info/{accNo}")
    public String getAccountInfo(@PathVariable("accNo") long accNo, Model model) {
    	
    	Account account = null;
    	for(Account ac : accountList) {
    		if(accNo == ac.getAccNo()) {
    			account=ac;
    			break;
    		}
    	}
    	model.addAttribute("account",account);
    	
    	return "info-account";
    }
    
    @RequestMapping(value = "/accounts/delete/{accNo}")
    public String deleteAccount(@PathVariable("accNo") long accNo) {

        Account account = null;
        for (Account ac : accountList) {
            if (accNo == ac.getAccNo()) {
                account = ac;
                break;
            }
        }

        accountList.remove(account);

        return "redirect:/accounts";
    }
    
    
}