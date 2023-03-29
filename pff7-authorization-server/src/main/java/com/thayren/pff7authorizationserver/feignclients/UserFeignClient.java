package com.thayren.pff7authorizationserver.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thayren.pff7authorizationserver.entities.User;

@Component
@FeignClient(name = "pff7-user", path = "/users")
public interface UserFeignClient {

	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
