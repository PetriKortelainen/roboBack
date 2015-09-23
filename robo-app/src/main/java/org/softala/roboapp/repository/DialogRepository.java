package org.softala.roboapp.repository;

import org.softala.roboapp.model.Hello;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DialogRepository extends CrudRepository<Hello, Long> {

}