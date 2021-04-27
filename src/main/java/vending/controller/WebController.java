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

import vending.beans.Item;
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
	
	@GetMapping({ "viewAll" })
	public String viewAllMachines(Model model) {
		if(vendingRepo.findAll().isEmpty()) {
			return addNewMachine(model);
		}
		
		model.addAttribute("machines", vendingRepo.findAll());
		return "vendors.html";
	}
	
	@GetMapping({ "viewAllAdmin" })
	public String viewAllMachinesAdmin(Model model) {
		if(vendingRepo.findAll().isEmpty()) {
			return addNewMachine(model);
		}
		
		model.addAttribute("machines", vendingRepo.findAll());
		return "vendors-admin.html";
	}
	
	@GetMapping("inputMachine")
	public String addNewMachine(Model model) {
		Machine m = new Machine();
		model.addAttribute("newMachine", m);
		
		return "input-machine.html";
	}
	
	@PostMapping("inputMachine")
	public String addNewMachine(@ModelAttribute Machine m, Model model) {
		vendingRepo.save(m);
		
		return viewAllMachinesAdmin(model);
	}
	
	@GetMapping("/editMachine/{id}")
	public String showUpdateMachine(@PathVariable("id") long id, Model model) {
		Machine m = vendingRepo.findById(id).orElse(null);
		model.addAttribute("newMachine", m);
		
		return "input-machine.html";
	}
	
	@PostMapping("/updateMachine/{id}")
	public String reviseMachine(Machine m, Model model) {
		vendingRepo.save(m);
		
		model.addAttribute("machines", vendingRepo.findAll());
		return "vendors-admin.html";
	}
	
	@GetMapping("/deleteMachine/{id}")
	public String deleteVendor(@PathVariable("id") long id, Model model) {
		Machine m = vendingRepo.findById(id).orElse(null);
		vendingRepo.delete(m);
		
		return viewAllMachinesAdmin(model);
	}
	
	@GetMapping("/viewItems/{id}")
	public String viewItems(@PathVariable("id") long id, Model model) {
		return null;
	}
	
	@GetMapping("/addUser/{id}")
	public String addUser(@PathVariable("id") long id, Model model) {
		return null;
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		return null;
	}
	
	@GetMapping("/addWallet/{id}") 
	public String addWallet(@PathVariable("id") long id, Model model) {
		return null;
	}
	
	@GetMapping("/deleteWallet/{id}") 
		public String deleteWallet(@PathVariable("id") long id, Model model) {
		return null;
	}
	
	@GetMapping("/addItem/{id}")
	public String addItem(@PathVariable("id") long id, Model model) {
		Item i = new Item();
		model.addAttribute("newItem", i);
			
		return "addItem.html";
	}
	
	@PostMapping("/addItem/{id}")
	public String addItem(@ModelAttribute Item i, Model model) {
		itemRepo.save(i);
		
		return "items.html";
	}
	
	@GetMapping("/editItem/{id}")
	public String editItem(@PathVariable("id") long id, Model model) {
		Machine m = vendingRepo.findById(id).orElse(null);
		Item i = itemRepo.findById(id).orElse(null);
		model.addAttribute("items", i);
		
		return "items.html";
	}
	
	@GetMapping("/deleteItem/{id}") 
	public String deleteItem(@PathVariable("id") long id, Model model) {
		return null;
	}
	
	@PostMapping("/updateItem/{id}")
	public String updateItem(Item i, Model model) {
		itemRepo.save(i);
		
		model.addAttribute("items", itemRepo.findAll());
		return "items.html";
	}
	
	@GetMapping("/makeTransaction/{id}")
	public String makeTransaction(@PathVariable("id") long id, Model model) {
		return null;
	}
	
	@GetMapping({ "/", "Index" })
	public String index(Model model) {
		return "index.html";
	}
	
}
