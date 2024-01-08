package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CategoryDao;
import com.app.dto.CategoryDTO;
import com.app.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoryDTO addNewCategory(CategoryDTO cat) {
		Category categoryEntity=modelMapper.map(cat, Category.class);
		Category savedCategory=categoryDao.save(categoryEntity);
		return modelMapper.map(savedCategory, CategoryDTO.class);
	}

}
