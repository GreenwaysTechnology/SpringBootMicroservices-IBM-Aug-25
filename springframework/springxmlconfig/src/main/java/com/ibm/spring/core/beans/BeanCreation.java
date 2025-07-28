package com.ibm.spring.core.beans;

public class BeanCreation {
    public static void main(String[] args) {
        //create Customer Bean
        Customer customer = new Customer(1,"Subramaian");
        System.out.println(customer.getId() + " " + customer.getName());

        Customer newCustomer = new Customer();
        newCustomer.setId(2);
        newCustomer.setName("Murugan");
        System.out.println(newCustomer.getId() + " " + newCustomer.getName());

        GreeterService greeterService = new GreeterService();
        System.out.println(greeterService.sayHello());
    }
}
