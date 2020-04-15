package com.diogorolins.wsmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diogorolins.wsmongo.domains.Post;
import com.diogorolins.wsmongo.resources.util.URL;
import com.diogorolins.wsmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResouce {
	
	@Autowired
	private PostService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAll(){		
		List<Post> list = service.findAll();	
		return ResponseEntity.ok().body(list);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Post> insert(@RequestBody Post obj){
		obj = service.insert(obj);		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text") String text) {
		text = URL.decodeParam(text);
		List<Post> posts = service.findByTitle(text);
		return ResponseEntity.ok().body(posts);
	}
	
	
}
