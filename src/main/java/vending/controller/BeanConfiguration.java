/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Apr 9, 2021
 */
package vending.controller;

import org.springframework.context.annotation.Bean;

import vending.beans.Item;
import vending.beans.Machine;
import vending.beans.User;
import vending.beans.Wallet;

/**
 * @author wuebk
 *
 */
public class BeanConfiguration {

		@Bean
		public Machine machine() {
			Machine bean = new Machine(000001);
			bean.setDetails("First itteration of Vending Machines MK1 000001");
			return bean;
		}
		
		@Bean
		public Item item() {
			Item bean = new Item(001);
			bean.setPrice(0.00);
			bean.setQuantity(0);
			return bean;
		}
		
		@Bean
		public User user() {
			User bean = new User(01);
			bean.setFirstName("Jane");
			bean.setLastName("Doe");
			return bean;
		}
		
		@Bean
		public Wallet wallet() {
			Wallet bean = new Wallet(1);
			bean.setBalance(0);
			return bean;
		}
}
