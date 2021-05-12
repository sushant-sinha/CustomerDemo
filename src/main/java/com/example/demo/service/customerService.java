package com.example.demo.service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class customerService {

    @Autowired
    private CustomerDAO customerDAO;

    private int idCount=1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer( Customer customer){

        /*customer.setId(idCount);
        customerList.add(customer);
        idCount++;*/

        //return customer;

        // no id is passed

        return customerDAO.save(customer);

    }

    public List<Customer> getAllCustomer(){

        //return customerList;

        return customerDAO.findAll();

    }

    public Customer getCustomer(int id){
        /*return customerList
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .get();*/

        return customerDAO.findById(id).get();
    }

    public Customer updateCustomer(int id, Customer customer){

        /*customerList
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
                .get();*/

        // save when passed with id parameter works as update
        // when no id is passed with the customer object, it works as creating new customer

        customer.setId(id); // setting the id of the customer to be updated
        return customerDAO.save(customer);

    }

    public void deleteCustomer(int id){

        /*customerList
                .stream()
                .forEach(c ->{
                    if(c.getId() == id){
                        customerList.remove(c);
                    }
                });*/

        customerDAO.deleteById(id);

    }

}
