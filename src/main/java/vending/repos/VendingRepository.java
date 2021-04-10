package vending.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vending.beans.Machine;

@Repository
public interface VendingRepository extends JpaRepository<Machine, Long> {
	
}
