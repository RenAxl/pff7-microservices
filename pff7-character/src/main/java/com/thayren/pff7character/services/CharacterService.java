package com.thayren.pff7character.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thayren.pff7character.dto.CategoryDTO;
import com.thayren.pff7character.dto.CharacterDTO;
import com.thayren.pff7character.entities.Category;
import com.thayren.pff7character.entities.Character;
import com.thayren.pff7character.repositories.CategoryRepository;
import com.thayren.pff7character.repositories.CharacterRepository;
import com.thayren.pff7character.services.exceptions.ResourceNotFoundException;

@Service
public class CharacterService {

	@Autowired
	private CharacterRepository repository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public Page<CharacterDTO> findAllPaged(Long categoryId, String name, PageRequest pageRequest) {
		List<Category> categories = (categoryId == 0L) ? null : Arrays.asList(categoryRepository.getOne(categoryId));
		Page<Character> page = repository.find(categories, name, pageRequest);
		repository.findCharactersWithCategories(page.getContent());

		return page.map(entity -> new CharacterDTO(entity));
	}

	@Transactional(readOnly = true)
	public CharacterDTO findById(Long id) {
		Optional<Character> obj = repository.findById(id);
		Character entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new CharacterDTO(entity);
	}

	@Transactional
	public CharacterDTO insert(CharacterDTO dto) {
		Character entity = new Character();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);

		return new CharacterDTO(entity);
	}

	@Transactional
	public CharacterDTO update(Long id, CharacterDTO dto) {
		try {
			Character entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);

			return new CharacterDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	private void copyDtoToEntity(CharacterDTO dto, Character entity) {
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setResidence(dto.getResidence());
		entity.setHistory(dto.getHistory());
		entity.setImgUrl(dto.getImgUrl());

		entity.getCategories().clear();

		for (CategoryDTO catDto : dto.getCategories()) {
			Category category = categoryRepository.getOne(catDto.getId());
			entity.getCategories().add(category);
		}
	}

}
