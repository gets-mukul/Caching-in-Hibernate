package com.telusko.com.caching.org;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "alien_able")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class CreateCache { // POJO
	@Id
	private int id;
	private String name;
	private String color;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "CreateCache [id=" + id + ", name=" + name + ", color=" + color + "]";
	}	


}