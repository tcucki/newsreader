package com.cognitive.newsreader.persistence;

import javax.ejb.Stateless;

import com.cognitive.framework.persistence.GenericDAO;
import com.cognitive.newsreader.domain.NewsSource;

@Stateless
public class NewsSourceDAO extends GenericDAO<NewsSource, String> {

}
