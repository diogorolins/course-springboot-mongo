package com.diogorolins.wsmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogorolins.wsmongo.domains.User;
import com.diogorolins.wsmongo.dto.UserDTO;
import com.diogorolins.wsmongo.repositories.UserRepository;
import com.diogorolins.wsmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();		
	}
	
	public User findById(String id) {
		Optional<User>  obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
		
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);		
	}
	
	public User update(String id, User obj) {
		User newObj = repository.findById(id).get();
		return repository.save(updateData(newObj, obj));
		
	}
	
	private User updateData(User newObj, User obj) {
		return new User(newObj.getId(), obj.getName(), obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());			
	}
}
