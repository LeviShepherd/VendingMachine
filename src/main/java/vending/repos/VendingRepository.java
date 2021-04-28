package vending.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vending.beans.Machine;

@Repository
public interface VendingRepository extends JpaRepository<Machine, Long> {
	//@Query("SELECT m from Machines m")
	//Collection<Machine> findAllMachines(); 
}
