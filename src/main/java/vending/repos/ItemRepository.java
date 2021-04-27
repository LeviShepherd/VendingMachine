package vending.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vending.beans.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	@Query("SELECT i from Items i")
	Collection<Item> findAllItems();
}
