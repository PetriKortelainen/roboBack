package org.softala.roboapp.repository;

import org.softala.roboapp.model.AnswerOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerOptionRepository extends CrudRepository<AnswerOption, Long> {

}
