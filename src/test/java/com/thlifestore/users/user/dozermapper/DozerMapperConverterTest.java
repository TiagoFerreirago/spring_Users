package com.thlifestore.users.user.dozermapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thlifestore.users.user.entities.User;
import com.thlifestore.users.user.mocks.UserMocks;
import com.thlifestore.users.user.v1.vo.UserVO;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class DozerMapperConverterTest {

	private UserMocks input;
	private LocalDate date = LocalDate.now();
	@BeforeEach
	void setUp() throws Exception {
		input = new UserMocks();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testParseObjectForEntity() {
		User user = DozerMapperConverter.parseObjectForEntity(input.mockUserVo(),User.class);
		
		assertNotNull(user);
		assertNotNull(user.getId());
		assertEquals("123456789 0",user.getCpf());
		assertEquals(date,user.getDt_Nasc());
		assertEquals("Male 0",user.getGenre());
		assertEquals("Lewer P 0",user.getName());
	}

	@Test
	void testParseListObjectForEntity() {
		List<User> user = DozerMapperConverter.parseListObjectForEntity(input.mockListUserVO(), User.class);
		assertNotNull(user);
		assertEquals(10,user.size());
		
		User userOne = user.get(1);
		
		assertNotNull(userOne);
		assertNotNull(userOne.getId());
		assertEquals("123456789 1",userOne.getCpf());
		assertEquals(date,userOne.getDt_Nasc());
		assertEquals("Female 1",userOne.getGenre());
		assertEquals("Sthefanny 1",userOne.getName());
		
		User userFour= user.get(4);
		
		assertNotNull(userFour);
		assertNotNull(userFour.getId());
		assertEquals("123456789 4",userFour.getCpf());
		assertEquals(date,userFour.getDt_Nasc());
		assertEquals("Male 4",userFour.getGenre());
		assertEquals("Lewer P 4",userFour.getName());
		
		User userSeven= user.get(7);
		
		assertNotNull(userSeven);
		assertNotNull(userSeven.getId());
		assertEquals("123456789 7",userSeven.getCpf());
		assertEquals(date,userSeven.getDt_Nasc());
		assertEquals("Female 7",userSeven.getGenre());
		assertEquals("Sthefanny 7",userSeven.getName());
	}
	@Test
	void testParseObjectForEntityVO() {
		UserVO vo = DozerMapperConverter.parseObjectForEntity(input.mockUser(),UserVO.class);
		
		assertNotNull(vo);
		assertNotNull(vo.getKey());
		assertEquals("123456789 0",vo.getCpf());
		assertEquals(date,vo.getDt_Nasc());
		assertEquals("Male 0",vo.getGenre());
		assertEquals("Lewer P 0",vo.getName());
	}

	@Test
	void testParseListObjectForEntityVO() {
		List<UserVO> vo = DozerMapperConverter.parseListObjectForEntity(input.mockListUser(), UserVO.class);
		assertNotNull(vo);
		assertEquals(10,vo.size());
		
		UserVO voOne = vo.get(1);
		
		assertNotNull(voOne);
		assertNotNull(voOne.getKey());
		assertEquals("123456789 1",voOne.getCpf());
		assertEquals(date,voOne.getDt_Nasc());
		assertEquals("Female 1",voOne.getGenre());
		assertEquals("Sthefanny 1",voOne.getName());
		
		UserVO voFour= vo.get(4);
		
		assertNotNull(voFour);
		assertNotNull(voFour.getKey());
		assertEquals("123456789 4",voFour.getCpf());
		assertEquals(date,voFour.getDt_Nasc());
		assertEquals("Male 4",voFour.getGenre());
		assertEquals("Lewer P 4",voFour.getName());
		
		UserVO voSeven= vo.get(7);
		
		assertNotNull(voSeven);
		assertNotNull(voSeven.getKey());
		assertEquals("123456789 7",voSeven.getCpf());
		assertEquals(date,voSeven.getDt_Nasc());
		assertEquals("Female 7",voSeven.getGenre());
		assertEquals("Sthefanny 7",voSeven.getName());
	}
}
