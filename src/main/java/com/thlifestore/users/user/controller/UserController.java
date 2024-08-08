package com.thlifestore.users.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thlifestore.users.user.UserService;
import com.thlifestore.users.user.v1.vo.UserVO;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserVO> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(value = "{/id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO findById(@RequestParam Long id) {
		return service.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO create(@RequestBody UserVO entity){
		return service.create(entity);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO update(@RequestBody UserVO entity){
		return service.update(entity);
	}
	
	@DeleteMapping(value = "{/id}")
	public ResponseEntity<?>delete(@RequestParam Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
