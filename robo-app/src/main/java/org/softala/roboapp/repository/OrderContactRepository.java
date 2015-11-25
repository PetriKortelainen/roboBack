package org.softala.roboapp.repository;

import org.softala.roboapp.model.OrderContact;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Kortelainen
 * @Since 14.10.2015
 * 
 * 
 * Implementation of Spring's CrudRepository for user OrderContact
 */
public interface OrderContactRepository extends CrudRepository<OrderContact, String> {

}
