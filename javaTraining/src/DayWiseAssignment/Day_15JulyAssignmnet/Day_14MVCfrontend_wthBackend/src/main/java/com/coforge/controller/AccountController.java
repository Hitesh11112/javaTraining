package com.coforge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.entities.Account;
import com.coforge.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService service;

	// no more ArrayList, no more @PostConstruct dummy data -
	// the database is now the single source of truth

    @RequestMapping("/accounts")
    public ModelAndView getAllAccounts(Model model) {

    	ModelAndView mv  = new ModelAndView();
        mv.addObject("accountList", service.getAllAccount());
        mv.setViewName("list"); //(/WEB-INF/views/list.jsp)

        return mv;
    }

    @RequestMapping("/accounts/add")
    public String addAccountString(Model model) {
    	model.addAttribute("account", new Account());
    	return "add-account";
    }

    @RequestMapping(value="/accounts/create", method=RequestMethod.POST)
    public String createAccount(@ModelAttribute Account account, Model model) {
    	service.addAccount(account);
    	return "redirect:/accounts";
    }

    @RequestMapping("/accounts/update/{accNo}")
    public String updateAccountForm(@PathVariable("accNo") long accNo, Model model) {

    	Account acc = service.getAccountByNo(accNo);
    	model.addAttribute("account", acc);
    	return "update-account";
    }

    @RequestMapping(value="/accounts/modify", method=RequestMethod.POST)
    public String updateAccount(@ModelAttribute("account") Account account) {

    	service.updateAccount(account);
    	return "redirect:/accounts";
    }

    @RequestMapping("/accounts/info/{accNo}")
    public String getAccountInfo(@PathVariable("accNo") long accNo, Model model) {

    	Account account = service.getAccountByNo(accNo);
    	model.addAttribute("account", account);

    	return "info-account";
    }

    @RequestMapping(value = "/accounts/delete/{accNo}")
    public String deleteAccount(@PathVariable("accNo") long accNo) {

        service.deleteAccount(accNo);

        return "redirect:/accounts";
    }

}
