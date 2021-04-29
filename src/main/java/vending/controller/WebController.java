/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Apr 9, 2021
 */
package vending.controller;

import java.util.List;

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
import vending.beans.User;
import vending.repos.ItemRepository;
import vending.repos.VendingRepository;

@Controller
public class WebController {
	@Autowired
	VendingRepository vendingRepo;
	@Autowired
	ItemRepository itemRepo;
	User user = new User();
	
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
		System.out.println(m);
		model.addAttribute("newMachine", m);
		
		return "input-machine.html";
	}
	
	@PostMapping("/updateMachine/{id}")
	public String reviseMachine(@PathVariable("id") long id, Machine m, Model model) {
		Machine revised = vendingRepo.findById(id).orElse(null);
		System.out.println(revised.toString());
		revised.setDetails(m.getDetails());
		vendingRepo.save(revised);
		
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
		Machine m = vendingRepo.findById(id).orElse(null);
		List<Item> items = m.getItems();
		model.addAttribute("items", items);
		
		return "items.html";
	}
	
	@GetMapping("/addItem/{id}")
	public String addItem(@PathVariable("id") long id, Model model) {
		Machine m = vendingRepo.findById(id).orElse(null);
		Item i = new Item();
		model.addAttribute("newItem", i);
		model.addAttribute("currentMachine", m);
			
		return "addItem.html";
	}
	
	@PostMapping("/addItem/{id}")
	public String addItem(@PathVariable("id") long id, @ModelAttribute Item i, Model model) {
		Machine m = vendingRepo.findById(id).orElse(null);
		
		itemRepo.save(i);
		m.addItems(i);
		vendingRepo.save(m);
		
		return editItem(id, model);
	}
	
	@GetMapping("/showEditItems/{id}")
	public String editItem(@PathVariable("id") long id, Model model) {
		Machine m = vendingRepo.findById(id).orElse(null);
		List<Item> items = m.getItems();
		if(items == null) {
			return addItem(id, model);
		}
		model.addAttribute("items", items);
		model.addAttribute("currentMachine", m);
		
		return "items.html";
	}
	
	@GetMapping("/deleteItem/{id}") 
	public String deleteItem(@PathVariable("id") long id, Model model) {
		return null;
	}
	
	@PostMapping("/updateItem/{id}")
	public String updateItem(Item i, @PathVariable("id") long id, Model model) {
		Machine m = vendingRepo.findById(id).orElse(null);
		m.addItems(i);
		itemRepo.save(i);
		vendingRepo.save(m);
		List<Item> items = m.getItems();
		model.addAttribute("items", items);
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
