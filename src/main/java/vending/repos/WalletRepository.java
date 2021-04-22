package vending.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vending.beans.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
	
}