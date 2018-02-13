package com.missingartifacts.crm.controller;

import com.missingartifacts.crm.repository.ActivityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivityController {

    private ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @RequestMapping("/activities")
    public String getContactActivities(Model model){
        model.addAttribute("activities", activityRepository.findAll());

        return "activities";
    }
}
