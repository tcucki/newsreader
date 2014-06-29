package com.cognitive.newsreader.translator;

import com.cognitive.newsreader.domain.Category;
import com.cognitive.newsreader.vo.CategoryVO;

public class CategoryTranslator {

	public Category VOToEntity(CategoryVO vo) {
		Category e = new Category();
		e.setId(vo.getId());
		e.setName(vo.getName());
		return e;
	}
	
	public CategoryVO EntityToVO(Category e) {
		CategoryVO vo = new CategoryVO();
		vo.setId(e.getId());
		vo.setName(e.getName());
		return vo;
	}
}
