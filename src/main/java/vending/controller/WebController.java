/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Apr 9, 2021
 */
package vending.controller;

/**
 * @author wuebk
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vending.beans.Machine;
import vending.repos.ItemRepository;
import vending.repos.UserRepository;
import vending.repos.VendingRepository;
import vending.repos.WalletRepository;

@Controller
public class WebController {
	@Autowired
	VendingRepository vendingRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	ItemRepository itemRepo;
	@Autowired
	WalletRepository walletRepo;
	
	@GetMapping({ "/", "viewAll" })
	public String viewAllMachines(Model model) {
		if(vendingRepo.findAll().isEmpty()) {
			return addNewMachine(model);
		}
		
		model.addAttribute("machines", vendingRepo.findAll());
		return "vendors";
	}
	
	@GetMapping("/inputMachine")
	public String addNewMachine(Model model) {
		Machine m = new Machine();
		model.addAttribute("newMachine", m);
		
		return "input";
	}
	
	@PostMapping("/inputMachine")
	public String addNewMachine(@ModelAttribute Machine m, Model model) {
		vendingRepo.save(m);
		
		return viewAllMachines(model);
	}
	
	@GetMapping("/edit?{id}")
	public String showUpdateMachine(@PathVariable("id") long id, Model model) {
		Machine m = vendingRepo.findById(id).orElse(null);
		model.addAttribute("newMachine", m);
		
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseMachine(Machine m, Model model) {
		vendingRepo.save(m);
		return viewAllMachines(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteVendor(@PathVariable("id") long id, Model model) {
		Machine m = vendingRepo.findById(id).orElse(null);
		vendingRepo.delete(m);
		
		return viewAllMachines(model);
	}
	
}
