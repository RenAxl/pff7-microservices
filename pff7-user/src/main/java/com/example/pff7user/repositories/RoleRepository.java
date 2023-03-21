package com.example.pff7user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pff7user.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}