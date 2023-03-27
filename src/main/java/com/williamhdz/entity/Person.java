package com.williamhdz.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Long id;
	private String name;
	private int age;

	@OneToMany(mappedBy = "person")
	private Set<Ability> skills = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference // evita problemas de serializacion
	@JoinTable(name = "people_parties", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"), inverseJoinColumns = @JoinColumn(name = "party_id", referencedColumnName = "party_id"))
	private Set<Party> parties = new HashSet<>();

	public Person() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Ability> getSkills() {
		return skills;
	}

	public void setSkills(Set<Ability> skills) {
		this.skills = skills;
	}

	public Set<Party> getParties() {
		return parties;
	}

	public void setParties(Set<Party> parties) {
		this.parties = parties;
	}

}
