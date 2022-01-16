package com.example.restapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapp.entity.PersonEntity;
import com.example.restapp.model.NamesInRange;
import com.example.restapp.model.Person;
import com.example.restapp.model.Postcode;
import com.example.restapp.repo.PersonRepository;

@RestController
@Validated
@RequestMapping("/api/person")
public class PersonController {

	private static final String RECORDS_SUCCESSFULLY_ADDED = " records successfully added";

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value = "/addList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addList(
			@RequestBody @Valid List<Person> people) {
		List<PersonEntity> peopleToPersist = people.stream()
				.map(pm -> pm.toEntity()).collect(Collectors.toList());
		this.personRepository.saveAll(peopleToPersist);
		return ResponseEntity.ok(getSuccessMessage(people.size()));
	}

	@GetMapping("/inRange")
	public ResponseEntity<NamesInRange> getNamesInRange(
			@RequestParam @Valid Postcode postcodeMin,
			@RequestParam @Valid Postcode postcodeMax) {
		List<Person> peopleInRange = this.personRepository
				.getPeopleWithinRange(
						Short.parseShort(postcodeMin.getPostcodeNumber()),
						Short.parseShort(postcodeMax.getPostcodeNumber()))
				.stream().map(Person::fromEntity).collect(Collectors.toList());
		List<String> names = peopleInRange.stream()
				.map(person -> person.getName()).collect(Collectors.toList());
		Integer totalNameCharacters = names.stream().map(name -> name.length())
				.reduce(0, Integer::sum);
		return ResponseEntity.ok(new NamesInRange(names, totalNameCharacters));
	}

	private String getSuccessMessage(int numRecords) {
		return new StringBuilder().append(numRecords)
				.append(RECORDS_SUCCESSFULLY_ADDED).toString();
	}

}
