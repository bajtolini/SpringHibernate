package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

public class CategoryConverter implements Converter<String, Category>{

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public Category convert(String id) {
		Category category = categoryDao.findById(Long.parseLong(id));
		return category;
	}

}