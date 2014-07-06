package com.cognitive.newsreader.service;

import com.cognitive.framework.service.CrudService;
import com.cognitive.newsreader.vo.NewsEntryVO;

public interface NewsEntryService extends CrudService<NewsEntryVO, String> {

	boolean exists(String id);
}
