package com.cognitive.newsreader.web.businessdelegate;

import com.cognitive.newsreader.service.CategoryService;

public class CategoryBD extends NewsReaderBusinessDelegate<CategoryService> {

	public CategoryBD() {

		setup("CategoryServiceEJB");
	}

}
