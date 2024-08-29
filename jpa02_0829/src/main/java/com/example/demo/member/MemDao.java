package com.example.demo.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemDao extends JpaRepository<Member, String> {


}
