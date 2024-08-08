package com.thlifestore.users.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thlifestore.users.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
