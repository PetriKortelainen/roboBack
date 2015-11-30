/**
 * 
 */
package org.softala.roboapp.repository;

import org.softala.roboapp.model.Closing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author a1300786
 *
 */
@Repository
public interface ClosingRepository extends CrudRepository<Closing, Integer> {

}
