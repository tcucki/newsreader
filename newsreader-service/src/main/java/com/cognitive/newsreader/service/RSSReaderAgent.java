package com.cognitive.newsreader.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

import org.apache.log4j.Logger;

import com.cognitive.newsreader.vo.NewsSourceVO;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Singleton
@Startup
public class RSSReaderAgent {
	
	private static final Logger LOGGER = Logger.getLogger(RSSReaderAgent.class);
	
	@EJB
	private NewsSourceService newsSourceService;
	
	@Resource
	private TimerService timerService;

	@PostConstruct
	private void setup() {
		LOGGER.info("***********  Searching news sources configured");
		
		try {
			List<NewsSourceVO> newsSources = this.newsSourceService.findAll();
			NewsSourceVO newsSourceVO = newsSources.get(0);
//			for (NewsSourceVO newsSourceVO : newsSources) { //TODO test
				this.activateNewsSource(newsSourceVO);
//			}
		} catch (Exception e) {
			LOGGER.error("Exception on setting up RSS Reader Agent", e);
		}
		LOGGER.info("News sources configured and listening");
		//http://www.terra.com.br/rss/
	}
	
	private void activateNewsSource(NewsSourceVO newsSourceVO) {
		
		long initialDuration = 5000; //TODO test
		LOGGER.info("Checking news source:\t" + newsSourceVO.getId() + "\t" + newsSourceVO.getName());
		Collection<Timer> timers = this.timerService.getAllTimers();
		boolean found = false;
		for (Timer timer : timers) {
			if (timer.getInfo().equals(newsSourceVO.getId())) {
				found = true;
				LOGGER.info("Found news source:\t" + newsSourceVO.getId() + "\t" + newsSourceVO.getName());
				continue;
			}
		}
		if (!found) {
			TimerConfig timerConfig = new TimerConfig(newsSourceVO.getId(), false);
			this.timerService.createIntervalTimer(initialDuration, 120000, timerConfig);
			initialDuration = initialDuration + 300000; // TODO test
			LOGGER.info("Created news source:\t" + newsSourceVO.getId() + "\t" + newsSourceVO.getName());
		}
	}

	@PreDestroy
	private void shutdown() {
		LOGGER.info("**********************shutdown");
	}
	
	@Timeout
	private void executeRSSReading(Timer timer) {
		LOGGER.info("Executing timer " + timer.getInfo());
		String id = (String) timer.getInfo();
		NewsSourceVO newsSourceVO = this.newsSourceService.find(id);
		LOGGER.info("Fetching news source:\tid: " + newsSourceVO.getId() + "\t" + newsSourceVO.getName() +
				"\nURL:\t" + newsSourceVO.getUrl());
		
		try {
			URL feedUrl = new URL(newsSourceVO.getUrl());
			SyndFeedInput syndFeedInput = new SyndFeedInput();
			SyndFeed feed = syndFeedInput.build( new XmlReader(feedUrl));
			LOGGER.info("Feed read:\nTitle:\t" +  feed.getTitle() + "\nDescription:\t" + feed.getDescription() +
					"\n# entries:\t" + feed.getEntries().size() + "\nDocs:\t" + feed.getDocs());
		} catch (Throwable e) {
			LOGGER.error("Exception on reading a feed from " + newsSourceVO.getName(), e);
		}
		
	}
}
