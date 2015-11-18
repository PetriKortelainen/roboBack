package org.softala.roboapp.repository;

import java.util.ArrayList;

import org.softala.roboapp.model.Dialog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Tuomas Törmä, Kortelainen Petri
 * @Since 14.10.2015
 * 
 */

@Repository
public interface DialogRepository extends CrudRepository<Dialog, Integer> {

		@Query(value="select d.dialog_id from dialog d where d.enabled = true",nativeQuery = true)
	
		public ArrayList<Integer> findEnabled();
}