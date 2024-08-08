package com.thlifestore.users.user.mocks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.thlifestore.users.user.entities.User;
import com.thlifestore.users.user.v1.vo.UserVO;

public class UserMocks {

	private LocalDate date = LocalDate.now();
	 
	public UserVO mockUserVo(int number) {
		UserVO vo = new UserVO();
		vo.setCpf("123456789 "+number);
		vo.setDt_Nasc(date);
		vo.setName((number%2==0 ? "Lewer P "+number : "Sthefanny "+number));
		vo.setKey(Long.valueOf(number));
		vo.setGenre((number%2==0?"Male "+number : "Female "+number));
		return vo;
	}
	
	public User mockUser(int number) {
		User user = new User();
		user.setCpf("123456789 "+number);
		user.setDt_Nasc(date);
		user.setGenre((number%2==0 ? "Male "+number : "Female "+number));
		user.setId(Long.valueOf(number));
		user.setName((number%2==0 ? "Lewer P "+number : "Sthefanny "+number));
		return user;
	}
	
	public List<UserVO> mockListUserVO(){
		List<UserVO>vo = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			vo.add(mockUserVo(i));
		}
		return vo;
	}
	
	public List<User> mockListUser(){
		List<User> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(mockUser(i));
		}
		return list;
	}
	
	public User mockUser() {
		return mockUser(0);
	}
	
	public UserVO mockUserVo() {
		return mockUserVo(0);
	}
}
