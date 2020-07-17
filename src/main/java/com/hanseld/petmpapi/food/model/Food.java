package com.hanseld.petmpapi.food.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "_foods", 
	   indexes = { @Index(name = "ind_foo_name", columnList = "foo_name") })
public class Food implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "foo_id")
	private Long id;
	
	@Basic
	@Column(name = "foo_name")
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
