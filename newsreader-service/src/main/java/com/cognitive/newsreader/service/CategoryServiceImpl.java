package com.cognitive.newsreader.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.cognitive.framework.GenericServiceImpl;
import com.cognitive.newsreader.domain.Category;
import com.cognitive.newsreader.persistence.CategoryDAO;
import com.cognitive.newsreader.translator.CategoryTranslator;
import com.cognitive.newsreader.vo.CategoryVO;

@Stateless(name = "CategoryServiceEJB")
//@Local(value = CategoryService.class)
@Remote(value = CategoryService.class)
public class CategoryServiceImpl extends GenericServiceImpl<CategoryVO, Category, String> implements CategoryService {

	@EJB
	private CategoryDAO categoryDAO;
	
	@PostConstruct
	private void init() {
		this.setGenericDAO(categoryDAO);
		this.setTranslator(new CategoryTranslator());
	}

}
