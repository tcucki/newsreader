package com.cognitive.newsreader.web.managedbeans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.cognitive.newsreader.service.NewsSourceService;
import com.cognitive.newsreader.vo.NewsSourceVO;
import com.cognitive.newsreader.web.businessdelegate.NewsSourceBD;

@RequestScoped
@Named
public class NewsSourceMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5306871070819318934L;

	private NewsSourceService newsSourceService;
	
	private NewsSourceVO newsSource = new NewsSourceVO();
	
	public NewsSourceMB() {
		this.newsSourceService = new NewsSourceBD().getService();
	}
	
	public String save() {
		
		this.newsSourceService.save(this.newsSource);
		return "success";
	}

	public NewsSourceVO getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(NewsSourceVO newsSource) {
		this.newsSource = newsSource;
	}
	
}
