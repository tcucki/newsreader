package com.cognitive.newsreader.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.cognitive.newsreader.domain.Category;
import com.cognitive.newsreader.persistence.CategoryDAO;
import com.cognitive.newsreader.translator.CategoryTranslator;
import com.cognitive.newsreader.vo.CategoryVO;

@Stateless(name = "CategoryServiceEJB")
//@Local(value = CategoryService.class)
@Remote(value = CategoryService.class)
public class CategoryServiceImpl implements CategoryService {

	@EJB
	private CategoryDAO categoryDAO;
	
	private CategoryTranslator translator;
	
	@PostConstruct
	private void init() {
		this.translator = new CategoryTranslator();
	}
	
	@Override
	public CategoryVO find(String id) {
		Category category = this.categoryDAO.find(id);
		return this.translator.EntityToVO(category);
	}

	@Override
	public CategoryVO insert(CategoryVO categoryVO) {
		Category category = this.translator.VOToEntity(categoryVO);
		category = this.categoryDAO.insert(category);
		return this.translator.EntityToVO(category);
	}

	@Override
	public CategoryVO update(CategoryVO categoryVO) {
		Category category = this.translator.VOToEntity(categoryVO);
		category = this.categoryDAO.update(category);
		return this.translator.EntityToVO(category);
	}

	@Override
	public void delete(String id) {
		this.categoryDAO.delete(id);
	}

	@Override
	public List<CategoryVO> findAll() {

		List<Category> categories = this.categoryDAO.findAll();
		List<CategoryVO> categoryVOs = new ArrayList<>(categories.size());
		for (Category category : categories) {
			CategoryVO categoryVO = this.translator.EntityToVO(category);
			categoryVOs.add(categoryVO);
		}
		return categoryVOs;
	}

}
