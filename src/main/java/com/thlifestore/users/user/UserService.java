package com.thlifestore.users.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.thlifestore.users.user.controller.UserController;
import com.thlifestore.users.user.dozermapper.DozerMapperConverter;
import com.thlifestore.users.user.entities.User;
import com.thlifestore.users.user.exception.handler.CustomNotFoundExceptionHandler;
import com.thlifestore.users.user.repository.UserRepository;
import com.thlifestore.users.user.v1.vo.UserVO;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional
	public List<UserVO> findAll(){
		List<UserVO> vo = DozerMapperConverter.parseListObjectForEntity(repository.findAll(),UserVO.class);
		vo.stream().forEach(p -> p.add(linkTo(methodOn(UserController.class).findById(p.getKey())).withSelfRel()));
		return vo;
	}
	
	@Transactional
	public UserVO findById(Long id) {
		UserVO vo = DozerMapperConverter.parseObjectForEntity(repository.findById(id),UserVO.class);
		vo.add(linkTo(methodOn(UserController.class).findById((vo.getKey()))).withSelfRel());
		return vo;
	}
	
	@Transactional
	public UserVO create(UserVO entity){
		User user = DozerMapperConverter.parseObjectForEntity(entity, User.class);
		UserVO vo = DozerMapperConverter.parseObjectForEntity(repository.save(user), UserVO.class);
		vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
		return vo;
		
	}
	@Transactional
	public UserVO update(UserVO entity) {
		User user = repository.findById(entity.getKey()).orElseThrow( () -> new CustomNotFoundExceptionHandler(""));
		user.setCpf(entity.getCpf());
		user.setDt_Nasc(entity.getDt_Nasc());
		user.setGenre(entity.getGenre());
		user.setName(entity.getName());	
		UserVO vo = DozerMapperConverter.parseObjectForEntity(user, UserVO.class);
		vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	@Transactional
	public void delete(Long id) {
		User user = repository.findById(id).orElseThrow( () -> new CustomNotFoundExceptionHandler(""));
		repository.delete(user);
	}
}
