package ma.revend.app.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.revend.app.ws.reponse.CategoryReponse;
import ma.revend.app.ws.request.CategoryRequest;
import ma.revend.app.ws.services.CategoryService;
import ma.revend.app.ws.shared.dto.CategoryDto;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CategoryReponse> getAllCategorys(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {

		List<CategoryReponse> categoryReponse = new ArrayList<>();

		List<CategoryDto> categorys = categoryService.getCategorys(page, limit);

		for (CategoryDto categoryDto : categorys) {
			
			CategoryReponse cate = new CategoryReponse();

			BeanUtils.copyProperties(categoryDto, cate);

			categoryReponse.add(cate);
		}
		return categoryReponse;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CategoryReponse> getCategory(@PathVariable String id) {

		CategoryDto categoryDto = categoryService.getCategoryByCategoryId(id);

		CategoryReponse categoryReponse = new CategoryReponse();

		BeanUtils.copyProperties(categoryDto, categoryReponse);

		return new ResponseEntity<CategoryReponse>(categoryReponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CategoryReponse> createCategory(@RequestBody CategoryRequest categoryRequest) throws Exception {

		CategoryDto categoryDto = new CategoryDto();

		BeanUtils.copyProperties(categoryRequest, categoryDto);

		CategoryDto createCategory = categoryService.createCategory(categoryDto);

		CategoryReponse categoryReponse = new CategoryReponse();

		BeanUtils.copyProperties(createCategory, categoryReponse);

		return new ResponseEntity<CategoryReponse>(categoryReponse, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<CategoryReponse> updateCategory(@PathVariable String id, @RequestBody CategoryRequest categoryRequest) {

		CategoryDto categoryDto = new CategoryDto();

		BeanUtils.copyProperties(categoryRequest, categoryDto);

		CategoryDto updateCategory = categoryService.updateCategory(id, categoryDto);

		CategoryReponse categoryReponse = new CategoryReponse();

		BeanUtils.copyProperties(updateCategory, categoryReponse);

		return new ResponseEntity<CategoryReponse>(categoryReponse, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteCategory(@PathVariable String id) {

		categoryService.deleteCategory(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


}
