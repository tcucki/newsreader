package com.cognitive.newsreader.vo;

import com.cognitive.framework.vo.ValueObject;

public class NewsSourceVO extends ValueObject<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7024493703679331456L;

	private String name;
	
	private String url;
	
	private String timerExpression;
	
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
