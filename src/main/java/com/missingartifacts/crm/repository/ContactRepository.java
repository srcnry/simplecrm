package com.missingartifacts.crm.repository;

import com.missingartifacts.crm.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
