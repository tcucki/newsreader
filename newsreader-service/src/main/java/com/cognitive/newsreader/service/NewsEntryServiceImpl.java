package com.cognitive.newsreader.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.cognitive.framework.GenericServiceImpl;
import com.cognitive.newsreader.domain.NewsEntry;
import com.cognitive.newsreader.persistence.NewsEntryDAO;
import com.cognitive.newsreader.translator.NewsEntryTranslator;
import com.cognitive.newsreader.vo.NewsEntryVO;

@Stateless(name = "NewsEntryServiceEJB")
@Remote(value = NewsEntryService.class)
public class NewsEntryServiceImpl extends GenericServiceImpl<NewsEntryVO, NewsEntry, String> implements NewsEntryService {

	@EJB
	private NewsEntryDAO newsEntryDAO;
	
	@PostConstruct
	private void setup() {
		this.setGenericDAO(newsEntryDAO);
		this.setTranslator(new NewsEntryTranslator());
	}
	
	@Override
	public boolean exists(String id) {

		return this.newsEntryDAO.exists(id);
	}

}
