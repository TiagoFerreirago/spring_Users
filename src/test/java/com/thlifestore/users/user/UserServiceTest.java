package com.thlifestore.users.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thlifestore.users.user.entities.User;
import com.thlifestore.users.user.exception.handler.CustomBadRequestExceptionHandler;
import com.thlifestore.users.user.mocks.UserMocks;
import com.thlifestore.users.user.repository.UserRepository;
import com.thlifestore.users.user.service.UserService;
import com.thlifestore.users.user.v1.vo.UserVO;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class UserServiceTest {

	private LocalDate date = LocalDate.now();
	private UserMocks input;
	@Mock
	private UserRepository repository;
	@InjectMocks
	private UserService service;
	
	@BeforeEach
	void setUp() throws Exception {
		input = new UserMocks();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		List<User>list = input.mockListUser();
		
		when(repository.findAll()).thenReturn(list);
		
		var result = service.findAll();
		
		assertNotNull(list);
		assertEquals(10,list.size());
		
		UserVO userOne = result.get(1);
		
		assertNotNull(userOne);
		assertNotNull(userOne.getKey());
		assertTrue(userOne.getLinks().toString().contains("</api/user/v1/1>;rel=\"self\""));
		assertEquals("123456789 1",userOne.getCpf());
		assertEquals(date,userOne.getDt_Nasc());
		assertEquals("Female 1",userOne.getGenre());
		assertEquals("Sthefanny 1",userOne.getName());
		
		UserVO userSix = result.get(6);
		
		assertNotNull(userSix);
		assertNotNull(userSix.getKey());
		assertTrue(userSix.getLinks().toString().contains("</api/user/v1/6>;rel=\"self\""));
		assertEquals("123456789 6",userSix.getCpf());
		assertEquals(date,userSix.getDt_Nasc());
		assertEquals("Male 6",userSix.getGenre());
		assertEquals("Lewer P 6",userSix.getName());
		
UserVO userNine= result.get(9);
		
		assertNotNull(userNine);
		assertNotNull(userNine.getKey());
		assertTrue(userNine.getLinks().toString().contains("</api/user/v1/9>;rel=\"self\""));
		assertEquals("123456789 9",userNine.getCpf());
		assertEquals(date,userNine.getDt_Nasc());
		assertEquals("Female 9",userNine.getGenre());
		assertEquals("Sthefanny 9",userNine.getName());
	}

	@Test
	void testFindById() {
		User user = input.mockUser();
		user.setId(1L);
				
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		
		var result = service.findById(1L);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertTrue(result.getLinks().toString().contains("</api/user/v1/1>;rel=\"self\""));
		assertEquals("123456789 0",result.getCpf());
		assertEquals(date,result.getDt_Nasc());
		assertEquals("Male 0",result.getGenre());
		assertEquals("Lewer P 0",result.getName());
	}

	@Test
	void testCreate() {
		User user = input.mockUser();
		user.setId(1L);
		
		User instance = user;
		instance.setId(1L);
		
		UserVO vo = input.mockUserVo();
		vo.setKey(1L);
		
		when(repository.save(user)).thenReturn(instance);
		
		var result = service.create(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertTrue(result.getLinks().toString().contains("</api/user/v1/1>;rel=\"self\""));
		assertEquals("123456789 0",result.getCpf());
		assertEquals(date,result.getDt_Nasc());
		assertEquals("Male 0",result.getGenre());
		assertEquals("Lewer P 0",result.getName());
	}

	@Test
	void testExceptioncreate() {
		Exception exception = assertThrows(CustomBadRequestExceptionHandler.class, () -> {
			service.create(null);
		});
		
		String messageActual = exception.getMessage();
		String messageExpective = "Invalid request: check the parameters provided.";
		
		assertEquals(messageActual,messageExpective);
		
	}
	@Test
	void testUpdate() {
		User user = input.mockUser();
		
		User instance = user;
		instance.setId(1L);
		
		UserVO vo = input.mockUserVo();
		vo.setKey(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		when(repository.save(user)).thenReturn(instance);
		
	    var result = service.update(vo);
	    
	    assertNotNull(result);
		assertNotNull(result.getKey());
		assertTrue(result.getLinks().toString().contains("</api/user/v1/1>;rel=\"self\""));
		assertEquals("123456789 0",result.getCpf());
		assertEquals(date,result.getDt_Nasc());
		assertEquals("Male 0",result.getGenre());
		assertEquals("Lewer P 0",result.getName());
	}
	
	@Test
	void testExceptionUpdate() {
		Exception exception = assertThrows(CustomBadRequestExceptionHandler.class, () -> {
			service.update(null);
		});
		
		String messageActual = exception.getMessage();
		String messageExpective = "Invalid request: check the parameters provided.";
		
		assertEquals(messageActual,messageExpective);
	}

	@Test
	void testDelete() {
		User user = input.mockUser();
		user.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		
		service.delete(1L);
		
		verify(repository,times(1)).delete(user);
					
	}

}
