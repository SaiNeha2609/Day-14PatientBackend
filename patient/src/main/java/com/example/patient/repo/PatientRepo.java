package com.example.patient.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patient.modal.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

//	Optional<Patient> findById1(String doc);

//	Optional<Patient> findById(String name);
	
//	Optional<Patient> findById2(String stage);

}
