package com.thayren.pff7character.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thayren.pff7character.dto.CategoryDTO;
import com.thayren.pff7character.entities.Category;
import com.thayren.pff7character.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(String name, PageRequest pageRequest) {
		Page<Category> page = repository.find(name, pageRequest);

		return page.map(x -> new CategoryDTO(x));
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.get();

		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);

		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		Category entity = repository.getOne(id);
		entity.setName(dto.getName());
		entity = repository.save(entity);

		return new CategoryDTO(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);

	}

}