package com.missingartifacts.crm.repository;

import com.missingartifacts.crm.model.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
