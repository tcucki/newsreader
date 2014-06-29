package com.cognitive.newsreader.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cognitive.framework.model.EntityModel;

@Entity
@Table(name = "category")
public class Category extends EntityModel {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
