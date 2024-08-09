package com.thlifestore.users.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thlifestore.users.user.service.UserService;
import com.thlifestore.users.user.util.MediaType;
import com.thlifestore.users.user.v1.vo.UserVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user/v1")
@Tag(name = "Users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Find all users", description = "Find all users", tags = {"Users"},
	responses = {@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(
			mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserVO.class)))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
	public List<UserVO> findAll(){
		return service.findAll();
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Find by users", description = "Find by users", tags = {"Users"},
	responses = {@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(
			schema = @Schema(implementation = UserVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
	public UserVO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "creating user using json, xml and yml", description = "creating user using json, xml and yml", tags = {"Users"},
	responses = {@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(
			schema = @Schema(implementation = UserVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
	public UserVO create(@RequestBody UserVO entity){
		return service.create(entity);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "updating user using json, xml and yml", description = "updating user using json, xml and yml", tags = {"Users"},
	responses = {@ApiResponse(description = "Updated", responseCode = "200", content = @Content(
			schema = @Schema(implementation = UserVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
	public UserVO update(@RequestBody UserVO entity){
		return service.update(entity);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "deleting a user", description = "deleting a user", tags = {"Users"},
	responses = {@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
	public ResponseEntity<?>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
