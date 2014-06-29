package com.cognitive.newsreader.persistence;

import javax.ejb.Stateless;

import com.cognitive.framework.persistence.GenericDAO;
import com.cognitive.newsreader.domain.Category;

@Stateless
public class CategoryDAO extends GenericDAO<Category, String> {

}
