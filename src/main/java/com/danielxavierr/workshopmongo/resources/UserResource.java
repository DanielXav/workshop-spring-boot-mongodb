package com.danielxavierr.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielxavierr.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = new ArrayList<>();
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User joao = new User("2", "João Green", "joao@gmail.com");
		
		list.addAll(Arrays.asList(maria, joao));
		return ResponseEntity.ok().body(list);
	}

}
