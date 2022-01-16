package com.example.restapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.restapp.entity.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

	@Query(value = "SELECT * FROM Person p WHERE CAST(p.postcode AS SMALLINT) BETWEEN :postcodeMin AND :postcodeMax", nativeQuery = true)
	public List<PersonEntity> getPeopleWithinRange(
			@Param("postcodeMin") Short postcodeMin,
			@Param("postcodeMax") Short postcodeMax);

}
