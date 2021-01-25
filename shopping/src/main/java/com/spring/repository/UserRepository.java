package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPasswordAndUsertype(String email, String password, String usertype);
	User findByUserid(int id);
    List<User> findAllByUsertype(String usertype);
}
