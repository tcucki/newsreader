package com.cognitive.newsreader.vo;

import java.util.Date;

import com.cognitive.framework.vo.ValueObject;

public class NewsEntryVO extends ValueObject<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5344315808349846846L;

	private String sourceId;
	
	private String title;
	
	private Date pubDate;
	
	private String draft;
	
	private String contentURL;
	
	private String content;

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getDraft() {
		return draft;
	}

	public void setDraft(String draft) {
		this.draft = draft;
	}

	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
