package ua.pp.darknsoft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.darknsoft.domain.entities.Customer;
import ua.pp.darknsoft.services.CustomerService;

import java.util.List;

@Controller
public class MainController {

    private final CustomerService customerService;

    public MainController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/")
    public String index(Model dasModel) {

        return "index";
    }

    @GetMapping(value = "/customers")
    public String customers(Model dasModel) {
        List<Customer> customers = customerService.findAll();
        dasModel.addAttribute("customers",customers);
        return "list-customers";
    }

    @GetMapping(value = "/showFormForAdd")
    public String showFormForAdd(Model dasModel) {

        return "customer-form";
    }


}
