package com.missingartifacts.crm.repository;

import com.missingartifacts.crm.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
