package com.mkyong;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mkyong.dao.CustomerRepository;
import com.mkyong.model.Customer;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("DATASOURCE = " + dataSource);

		List<Customer> list = customerRepository.findAll();
		list.forEach(x -> System.out.println(x));
	}
}