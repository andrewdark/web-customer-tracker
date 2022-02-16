package ua.pp.darknsoft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.pp.darknsoft.domain.dto.CustomerDto;
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
        List<CustomerDto> customers = customerService.findAll();
        dasModel.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping(value = "/showFormForAdd")
    public String showFormForAdd(Model dasModel) {
        //Create model attribute to bind form data
        CustomerDto theCustomer = new CustomerDto();
        dasModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping(value = "/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") CustomerDto theCustomer) {
        if (theCustomer != null)
            customerService.addCustomer(theCustomer);
        return "redirect:/customers";
    }

    @GetMapping(value = "/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model dasModel) {
        //Create model attribute to bind form data
        CustomerDto theCustomer = customerService.findById(id).orElse(null);
       if(theCustomer==null){
           return "redirect:/customers";
       }
        dasModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

}
