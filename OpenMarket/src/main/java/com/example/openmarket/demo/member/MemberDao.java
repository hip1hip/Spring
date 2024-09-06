package com.example.openmarket.demo.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MemberDao extends JpaRepository<Member, String> {//JpaRepository:db작업 메서드 정의
	ArrayList<Member> findByType(String type);
}

