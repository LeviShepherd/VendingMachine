package vending.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import vending.beans.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
	@Query("SELECT w from Wallet w")
	Collection<Wallet> findAllWallet();
}
