package com.cognitive.newsreader.vo;

import com.cognitive.framework.vo.ValueObject;

public class CategoryVO extends ValueObject<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680986469949287513L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
