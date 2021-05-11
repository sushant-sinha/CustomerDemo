package com.example.demo.api;

import com.example.demo.model.Customer;
import com.example.demo.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private customerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){

        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomer(){

        return customerService.getAllCustomer();
    }

    @GetMapping(value = "/{customerid}")
    public Customer getCustomer(@PathVariable("customerid") int id){

        return customerService.getCustomer(id);

    }

    @PutMapping(value = "/{customerid}")
    public Customer updateCustomer(@PathVariable("customerid") int id, @RequestBody Customer customer){

        return customerService.updateCustomer(id, customer);

    }

    @DeleteMapping(value = "/{customerid}")
    public void deleteCustomer(@PathVariable("customerid") int id){

        customerService.deleteCustomer(id);

    }

}
