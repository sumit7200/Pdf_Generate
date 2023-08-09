package com.example.school.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Studentt {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private String name;
	private String section;

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Studentt(long id, String name, String section) {
		super();
		this.id = id;
		this.name = name;
		this.section = section;
	}

	public Studentt() {
		super();
	}

	@Override
	public String toString() {
		return "Studentt [id=" + id + ", name=" + name + ", section=" + section + "]";
	}

}
