package com.cognitive.newsreader.web.businessdelegate;

import com.cognitive.newsreader.service.NewsSourceService;

public class NewsSourceBD extends NewsReaderBusinessDelegate<NewsSourceService> {

	public NewsSourceBD() {
		setup("NewsSourceServiceEJB");
	}
}
