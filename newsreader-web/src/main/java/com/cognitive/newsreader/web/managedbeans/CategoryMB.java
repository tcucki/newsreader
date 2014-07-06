/**
 * 
 */
package com.cognitive.newsreader.web.managedbeans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.cognitive.newsreader.service.CategoryService;
import com.cognitive.newsreader.vo.CategoryVO;
import com.cognitive.newsreader.web.businessdelegate.CategoryBD;

/**
 * @author tiago
 *
 */
@RequestScoped
@Named
public class CategoryMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6793725559008359140L;

	private CategoryService categoryService;
	
	private CategoryVO category = new CategoryVO();
	
	public CategoryMB() {
		
		this.categoryService = new CategoryBD().getService();
	}
	
	public String save() {
		
		this.categoryService.save(this.category);
		return "success";
	}
	
	public CategoryVO getCategory() {
		return category;
	}
	
	public void setCategory(CategoryVO category) {
		this.category = category;
	}
	
}
