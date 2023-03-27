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
import com.williamhdz.reporitory.PartyRepository;

@RestController
@RequestMapping("/api/parties")
public class PartyController {

	// TODO: agregar validaciones

	@Autowired
	private PartyRepository partyRepository;

	@GetMapping
	public ResponseEntity<Collection<Party>> listParties() {
		return new ResponseEntity<>(partyRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Party> getPartyById(@PathVariable Long id) {
		Party party = partyRepository.findById(id).orElseThrow();

		if (party != null) {
			return new ResponseEntity<>(partyRepository.findById(id).orElseThrow(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> saveParty(@RequestBody Party party) {
		return new ResponseEntity<>(partyRepository.save(party), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteParty(@PathVariable Long id) {
		partyRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
