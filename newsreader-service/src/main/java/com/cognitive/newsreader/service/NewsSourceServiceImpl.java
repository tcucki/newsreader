package com.cognitive.newsreader.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.cognitive.framework.GenericServiceImpl;
import com.cognitive.newsreader.domain.NewsSource;
import com.cognitive.newsreader.persistence.NewsSourceDAO;
import com.cognitive.newsreader.translator.NewsSourceTranslator;
import com.cognitive.newsreader.vo.NewsSourceVO;

@Stateless(name = "NewsSourceServiceEJB")
@Remote(value = NewsSourceService.class)
public class NewsSourceServiceImpl extends GenericServiceImpl<NewsSourceVO, NewsSource, String> implements NewsSourceService {

	@EJB
	private NewsSourceDAO newsSourceDAO;
	
	@PostConstruct
	private void init() {
		this.setGenericDAO(newsSourceDAO);
		this.setTranslator(new NewsSourceTranslator());
	}
}
