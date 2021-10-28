package com.danielxavierr.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielxavierr.workshopmongo.domain.User;
import com.danielxavierr.workshopmongo.dto.UserDTO;
import com.danielxavierr.workshopmongo.repository.UserRepository;
import com.danielxavierr.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User user) {
		User newObj = findById(user.getId());
		updateData(newObj, user);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User user) {
		newObj.setName(user.getName());
		newObj.setEmail(user.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
