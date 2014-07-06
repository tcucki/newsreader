package com.cognitive.newsreader.translator;

import com.cognitive.framework.translator.AbstractTranslator;
import com.cognitive.newsreader.domain.NewsEntry;
import com.cognitive.newsreader.vo.NewsEntryVO;

public class NewsEntryTranslator extends AbstractTranslator<String, NewsEntryVO, NewsEntry> {

	@Override
	public NewsEntryVO translateEntityToVO(NewsEntry entityModel) {
		NewsEntryVO valueObject = new NewsEntryVO();
		valueObject.setContent(entityModel.getContent());
		valueObject.setContentURL(entityModel.getContentURL());
		valueObject.setDraft(entityModel.getDraft());
		valueObject.setId(entityModel.getId());
		valueObject.setPubDate(entityModel.getPubDate());
		valueObject.setSourceId(entityModel.getSourceId());
		valueObject.setTitle(entityModel.getTitle());
		return valueObject;
	}

	@Override
	public NewsEntry translateVoToEntity(NewsEntryVO valueObject) {
		NewsEntry entityModel = new NewsEntry();
		entityModel.setContent(valueObject.getContent());
		entityModel.setContentURL(valueObject.getContentURL());
		entityModel.setDraft(valueObject.getDraft());
		entityModel.setId(valueObject.getId());
		entityModel.setPubDate(valueObject.getPubDate());
		entityModel.setSourceId(valueObject.getSourceId());
		entityModel.setTitle(valueObject.getTitle());
		return entityModel;
	}

}
