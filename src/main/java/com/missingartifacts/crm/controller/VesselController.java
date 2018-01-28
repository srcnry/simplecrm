package com.missingartifacts.crm.controller;

import com.missingartifacts.crm.repository.VesselRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VesselController {

    private VesselRepository vesselRepository;

    public VesselController(VesselRepository vesselRepository) {
        this.vesselRepository = vesselRepository;
    }

    @RequestMapping("/vessels")
    public String getVessels(Model model){
        model.addAttribute("vessels", vesselRepository.findAll());

        return "vessels";
    }
}
