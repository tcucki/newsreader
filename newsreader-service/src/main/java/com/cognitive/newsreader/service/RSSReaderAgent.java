package com.cognitive.newsreader.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

import com.cognitive.newsreader.vo.NewsSourceVO;

@Singleton
@Startup
public class RSSReaderAgent {
	
	private static final Logger LOGGER = Logger.getLogger(RSSReaderAgent.class);
	
	@EJB
	private NewsSourceService newsSourceService;

	@PostConstruct
	private void setup() {
		LOGGER.info("***********  Searching news sources configured");
		
		try {
			List<NewsSourceVO> newsSources = this.newsSourceService.findAll();
			for (NewsSourceVO newsSourceVO : newsSources) {
				this.activateNewsSource(newsSourceVO);
			}
		} catch (Exception e) {
			LOGGER.error("Exception on setting up RSS Reader Agent", e);
		}
		LOGGER.info("News sources configured and listening");
		//http://www.terra.com.br/rss/
	}
	
	private void activateNewsSource(NewsSourceVO newsSourceVO) {
		// TODO Auto-generated method stub
		LOGGER.info("Found news source: " + newsSourceVO.getId() + "\t" + newsSourceVO.getName());
	}

	@PreDestroy
	private void shutdown() {
		LOGGER.info("**********************shutdown");
	}
}
