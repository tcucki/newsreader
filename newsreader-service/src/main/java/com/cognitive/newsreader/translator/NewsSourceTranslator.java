package com.cognitive.newsreader.translator;

import com.cognitive.framework.translator.AbstractTranslator;
import com.cognitive.newsreader.domain.NewsSource;
import com.cognitive.newsreader.vo.NewsSourceVO;

public class NewsSourceTranslator extends AbstractTranslator<String, NewsSourceVO, NewsSource> {

	@Override
	public NewsSourceVO translateEntityToVO(NewsSource newsSource) {
		
		NewsSourceVO newsSourceVO = new NewsSourceVO();
		newsSourceVO.setActive(newsSource.getActive());
		newsSourceVO.setId(newsSource.getId());
		newsSourceVO.setName(newsSource.getName());
		newsSourceVO.setTimerExpression(newsSource.getTimerExpression());
		newsSourceVO.setUrl(newsSource.getUrl());

		return newsSourceVO;
	}

	@Override
	public NewsSource translateVoToEntity(NewsSourceVO newsSourceVO) {

		NewsSource newsSource = new NewsSource();
		newsSource.setActive(newsSourceVO.getActive());
		newsSource.setId(newsSourceVO.getId());
		newsSource.setName(newsSourceVO.getName());
		newsSource.setTimerExpression(newsSourceVO.getTimerExpression());
		newsSource.setUrl(newsSourceVO.getUrl());

		return newsSource;
	}

}
