/**
 * 
 */
package org.softala.roboapp.repository;

import org.softala.roboapp.model.Closing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 	Tuomas Törmä, Petri Kortelainen
 * @since	2.12.2015
 *
 *	Implementation of Spring's CrudRepository for Closing
 *
 */
@Repository
public interface ClosingRepository extends CrudRepository<Closing, Integer> {

}
