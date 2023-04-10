package com.example.demo.controller;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout ();
        return "redirect:/";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {

        List<Customer> customers = addCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());
        return "customers";
    }

    // add customers for demonstration
    public List<Customer> addCustomers() {
        List<Customer> list = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setAddress("Saudi");
        customer1.setName("Neom");
        customer1.setServiceRendered("Travel");
        list.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setAddress("Dubai");
        customer2.setName("Tonamus");
        customer2.setServiceRendered("Booking");
        list.add(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setAddress("Singapore");
        customer3.setName("singapore");
        customer3.setServiceRendered("Internet");
        list.add(customer3);

        return list;
    }
}
