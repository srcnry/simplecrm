package com.missingartifacts.crm.controller;

import com.missingartifacts.crm.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/customers")
    public String getCustomers(Model model){
        model.addAttribute("customers", customerRepository.findAll());

        return "customers";
    }
}
