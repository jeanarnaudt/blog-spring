package com.blog.repository;

import org.springframework.stereotype.Repository;
import com.blog.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   User findByUsername(String username);
}
