package com.thayren.pff7authorizationserver.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thayren.pff7authorizationserver.entities.User;
import com.thayren.pff7authorizationserver.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
			User user = service.loadUserByUsername(email);
			return ResponseEntity.ok(user);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
