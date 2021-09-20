package ma.revend.app.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.revend.app.ws.entity.CategoryEntity;
import ma.revend.app.ws.repository.CategoryRepository;
import ma.revend.app.ws.services.CategoryService;
import ma.revend.app.ws.shared.Utils;
import ma.revend.app.ws.shared.dto.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	Utils util;
	
	@Override
	public List<CategoryDto> getCategorys(int page, int limit) {
		
		if(page > 0) page = page -1;
		
		List<CategoryDto> categoryDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<CategoryEntity> categoryPage =	categoryRepository.findAll(pageableRequest);
		
		List<CategoryEntity> categorys = categoryPage.getContent();
		
		for(CategoryEntity categoryEntity: categorys) {
			CategoryDto category = new CategoryDto();
			
			BeanUtils.copyProperties(categoryEntity, category);
			
			categoryDto.add(category);
		}
		return categoryDto;
		
	}

	@Override
	public CategoryDto getCategory(String name) {
		
		CategoryEntity categoryEntity = categoryRepository.findByName(name);

		if (categoryEntity == null)
			throw new UsernameNotFoundException(name);

		CategoryDto categoryDto = new CategoryDto();

		BeanUtils.copyProperties(categoryEntity, categoryDto);

		return categoryDto;
	}

	@Override
	public CategoryDto getCategoryByCategoryId(String categoryId) {
		
		CategoryEntity categoryEntity = categoryRepository.findByCategoryId(categoryId);

		if (categoryEntity == null)
			throw new UsernameNotFoundException(categoryId);

		CategoryDto categoryDto = new CategoryDto();

		BeanUtils.copyProperties(categoryEntity, categoryDto);

		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(String categoryId, CategoryDto categoryDto) {
			
		CategoryEntity categoryEntity = categoryRepository.findByCategoryId(categoryId);
		if (categoryEntity == null)
		throw new UsernameNotFoundException(categoryId);

		
		categoryEntity.setName(categoryDto.getName());
		categoryEntity.setLogo(categoryDto.getLogo());
		categoryEntity.setDescription(categoryDto.getDescription());

		CategoryEntity categoryupdate = categoryRepository.save(categoryEntity);

		CategoryDto catego = new CategoryDto();

		BeanUtils.copyProperties(categoryupdate, catego);

		return catego;
		
	}

	@Override
	public void deleteCategory(String categoryId) {

		CategoryEntity categoryEntity = categoryRepository.findByCategoryId(categoryId);

		if (categoryEntity == null)
			throw new UsernameNotFoundException(categoryId);

		categoryRepository.delete(categoryEntity);
		
	}

	@Override
	public CategoryDto createCategory(CategoryDto category) {
		
		CategoryEntity checkprod = categoryRepository.findByName(category.getName());
		
		if(checkprod != null) throw new RuntimeException("Category Already Exists");
		
		CategoryEntity addcategory = new CategoryEntity();
		
		BeanUtils.copyProperties(category, addcategory);
		
		addcategory.setCategoryId(util.generateStringId(3));
		
		CategoryEntity newcategory = categoryRepository.save(addcategory);
		
		CategoryDto categoryDto = new CategoryDto();
		
		BeanUtils.copyProperties(newcategory, categoryDto);
		
		return categoryDto;
	}

}
