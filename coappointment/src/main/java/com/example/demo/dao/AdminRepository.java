package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByUsernameAndPassword(String username, String password);

}
