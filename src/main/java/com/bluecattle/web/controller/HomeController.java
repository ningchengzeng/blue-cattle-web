package com.bluecattle.web.controller;

import com.bluecattle.web.service.PropertyService;
import com.bluecattle.web.vo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("properties", propertyService.findProperties());
        return "index";
    }

    @RequestMapping("/th")
    public String renderWithThymeleaf(Model model) {
        model.addAttribute("user", "domix");
        return "th";
    }
}
