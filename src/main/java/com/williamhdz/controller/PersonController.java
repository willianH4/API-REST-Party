package com.williamhdz.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.williamhdz.entity.Person;
import com.williamhdz.reporitory.PersonRepository;

@Controller
@RequestMapping("/api/persons")
public class PersonController {
	
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
			return new ResponseEntity<>(personRepository.findById(id).orElseThrow(), HttpStatus.OK)
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
