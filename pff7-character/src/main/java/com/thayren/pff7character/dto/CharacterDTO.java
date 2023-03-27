package com.thayren.pff7character.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.thayren.pff7character.entities.Character;


public class CharacterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Integer age;
	private String residence;
	private String history;
	private String imgUrl;

	Set<CategoryDTO> categories = new HashSet<>();

	public CharacterDTO() {
	}

	public CharacterDTO(Long id, String name, Integer age, String residence, String history, String imgUrl) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.residence = residence;
		this.history = history;
		this.imgUrl = imgUrl;
	}
	
	public CharacterDTO(Character entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.age = entity.getAge();
		this.residence = entity.getResidence();
		this.history = entity.getHistory();
		this.imgUrl = entity.getImgUrl();
		entity.getCategories().forEach(category -> this.categories.add(new CategoryDTO (category)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<CategoryDTO> getCategories() {
		return categories;
	}
	
	

}
