package com.cognitive.newsreader.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cognitive.framework.model.EntityModel;

@Entity
@Table(name = "newsentry")
public class NewsEntry extends EntityModel {

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
