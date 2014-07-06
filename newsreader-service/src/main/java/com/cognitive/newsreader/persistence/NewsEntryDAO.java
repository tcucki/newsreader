package com.cognitive.newsreader.persistence;

import javax.ejb.Stateless;

import com.cognitive.framework.persistence.GenericDAO;
import com.cognitive.newsreader.domain.NewsEntry;

@Stateless
public class NewsEntryDAO extends GenericDAO<NewsEntry, String> {

	public boolean exists(String id) {
		return this.find(id) != null;
	}
}
