package com.example.demo.users;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UsersDao extends JpaRepository<Users, String> {

}
