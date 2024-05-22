package com.github.derickfelix.bankapplication.repositories;

import com.github.derickfelix.bankapplication.models.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends BaseRepository<Customer, Long> {
    
    List<Customer> search(String term);
    
    Optional<Customer> findByAccountNumber(String accountNumber);
    
    Optional<Customer> findByAccountNumberAndPassword(String accountNumber, String password);
    
}
