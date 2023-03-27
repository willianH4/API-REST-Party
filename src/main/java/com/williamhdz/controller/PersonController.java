package com.williamhdz.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williamhdz.entity.Party;
import com.williamhdz.entity.Person;
import com.williamhdz.reporitory.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	// TODO: agregar validaciones
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping
	public ResponseEntity<Collection<Person>> listPersons() {
		return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
		Person person = personRepository.findById(id).orElseThrow();
		
		if ( person != null) {
			return new ResponseEntity<>(personRepository.findById(id).orElseThrow(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> savePerson(@RequestBody Person person) {
		return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable Long id){
		personRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}/parties")
	public ResponseEntity<Collection<Party>> listPartiesOfPerson(@PathVariable Long id){
		Person person = personRepository.findById(id).orElseThrow();
		
		if ( person != null ) {
			return new ResponseEntity<>(person.getParties(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
}
