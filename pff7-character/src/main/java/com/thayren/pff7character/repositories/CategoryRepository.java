package com.thayren.pff7character.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thayren.pff7character.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("select cat from Category cat where cat.name like %?1%")
	Page<Category> find(String name, Pageable pageable);

}