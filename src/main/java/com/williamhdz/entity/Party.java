package com.williamhdz.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "parties")
public class Party {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "party_id")
	private Long id;
	
	private String location;
	
	@Column(name = "party_date")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date date;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "persons_parties", joinColumns = @JoinColumn(name = "party_id", 
				referencedColumnName = "party_id"), 
				inverseJoinColumns = @JoinColumn(name = "person_id", 
				referencedColumnName = "person_id"))
	private Set<Person> people = new HashSet<>();

	public Party() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public void setPeople(Set<Person> people) {
		this.people = people;
	}
	
	
	
}
