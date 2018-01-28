package com.missingartifacts.crm.controller;

import com.missingartifacts.crm.repository.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

    private ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @RequestMapping("/contacts")
    public String getContactPersons(Model model){
        model.addAttribute("contacts", contactRepository.findAll());

        return "contacts";
    }
}
