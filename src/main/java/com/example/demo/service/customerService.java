package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class customerService {

    private int idCount=1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer( Customer customer){

        customer.setId(idCount);
        customerList.add(customer);
        idCount++;
        return customer;

    }

    public List<Customer> getAllCustomer(){

        return customerList;

    }

    public Customer getCustomer(int id){
        return customerList
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .get();
    }

    public Customer updateCustomer(int id, Customer customer){

        customerList
                .stream()
                .forEach(c ->{
                    if(c.getId() == id){
                        c.setFname(customer.getFname());
                        c.setLname(customer.getLname());
                        c.setEmail(customer.getEmail());
                    }
                });

        return customerList
                .stream()
                .filter(c -> c.getId() == customer.getId())
                .findFirst()
                .get();

    }

    public void deleteCustomer(int id){

        customerList
                .stream()
                .forEach(c ->{
                    if(c.getId() == id){
                        customerList.remove(c);
                    }
                });

    }

}
