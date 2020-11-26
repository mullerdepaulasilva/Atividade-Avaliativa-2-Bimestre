package com.fafram.webserviceApplication.config;

import com.fafram.webserviceApplication.entities.Customer;
import com.fafram.webserviceApplication.entities.Phone;
import com.fafram.webserviceApplication.repositories.CustomerRepository;
import com.fafram.webserviceApplication.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    @Autowired
    private PhoneRepository phoneRepository;


    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {

        Phone pho1 = new Phone(null,"celular", 12345667);
        Phone pho2 = new Phone(null,"celular", 23768902);
        Phone pho3 = new Phone(null,"celular", 74838212);

        Customer customer1 = new Customer(null,"Muller","abcdes", "346345851");
        Customer customer2 = new Customer(null,"Pedro","defasas", "466232390875");
        Customer customer3 = new Customer(null,"Otavio","ghidawd", "4487980878");

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        phoneRepository.saveAll(Arrays.asList(pho1, pho2, pho3));

        customer1.getPhones().add(pho1);
        customer1.getPhones().add(pho2);

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));

    }
}
