package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findByUsernameAndPassword(String username, String password);
}
