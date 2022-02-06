package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.darknsoft.services.CustomerService;

@Controller
public class MainController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/")
    public String index(Model dasModel) {
        customerService.findAll().stream().forEach(System.out::println);
        return "index";
    }
}
