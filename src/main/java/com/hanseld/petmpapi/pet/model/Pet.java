package com.hanseld.petmpapi.pet.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "_pets", 
	   indexes = { @Index(name = "ind_pet_name", columnList = "pet_name") })
public class Pet implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pet_id")
	private Long id;
	
	@Basic
	@Column(name = "pet_name")
	private String name;

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
}
