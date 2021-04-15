package vending;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import vending.beans.Item;
import vending.beans.Machine;
import vending.beans.User;
import vending.beans.Wallet;
import vending.controller.BeanConfiguration;
import vending.repos.VendingRepository;


@SpringBootApplication
public class VendingMachineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VendingMachineApplication.class, args);
	}

	@Autowired 
	VendingRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Machine m = appContext.getBean("machine", Machine.class);
		
		System.out.println(m.getUsers());
		
		List<Machine> allMyMachines = repo.findAll();
		for(Machine vendors: allMyMachines) {
			System.out.println(vendors.toString());
		}
		((AbstractApplicationContext) appContext).close();
	}
}
