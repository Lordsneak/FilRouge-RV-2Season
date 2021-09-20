package ma.revend.app.ws.services;

import java.util.List;

import ma.revend.app.ws.shared.dto.CategoryDto;

public interface CategoryService {
	
	List<CategoryDto> getCategorys(int page, int limit);
	CategoryDto createCategory(CategoryDto category);
	CategoryDto getCategory(String name);
	CategoryDto getCategoryByCategoryId(String categoryId);
	CategoryDto updateCategory(String categoryId, CategoryDto categoryDto);
	void deleteCategory(String categoryId);

}
