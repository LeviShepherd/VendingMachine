package vending.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vending.beans.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
}
