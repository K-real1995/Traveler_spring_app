package com.travelerregistrationform.controller;

import com.travelerregistrationform.model.TravelersModel;
import com.travelerregistrationform.service.TravelersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TravelersController {

    private final TravelersService travelersService;

    public TravelersController(TravelersService travelersService) {
        this.travelersService = travelersService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new TravelersModel());
        return "register_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute TravelersModel travelersModel){
        System.out.println("Запрос регистрации " + travelersModel);
        TravelersModel registerTraveler = travelersService.registerTraveler(
                travelersModel.getName(),
                travelersModel.getEmail(),
                travelersModel.getPhone(),
                travelersModel.getPlace());
        return registerTraveler == null ? "error_page" : "redirect:/success_page";
    }

    @GetMapping("/success_page")
    public String getSuccessPage(){
        return "success_page";
    }
}
