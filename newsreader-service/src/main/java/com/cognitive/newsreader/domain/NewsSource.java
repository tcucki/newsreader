package com.cognitive.newsreader.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cognitive.framework.model.EntityModel;

@Entity
@Table(name = "newssource")
public class NewsSource extends EntityModel {

	private String name;
	
	private String url;
	
	private String timerExpression;
	
	@Transient
	private Boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTimerExpression() {
		return timerExpression;
	}

	public void setTimerExpression(String timerExpression) {
		this.timerExpression = timerExpression;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
