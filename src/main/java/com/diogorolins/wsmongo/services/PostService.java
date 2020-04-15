package com.diogorolins.wsmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogorolins.wsmongo.domains.Post;
import com.diogorolins.wsmongo.repositories.PostRepository;
import com.diogorolins.wsmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();		
	}
	
	public Post findById(String id) {
		Optional<Post>  obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Post insert(Post obj) {
		return repository.insert(obj);
		
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);		
	}

}
