package com.example.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient.modal.Patient;
import com.example.patient.repo.PatientRepo;

@Service
public class PatientService implements PatientServiceInterface{
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Override
	public Patient savePatient(Patient p) {
		return patientRepo.save(p);
	}
	
	@Override
	public Patient getByID(long id){
		return patientRepo.findById(id).orElse(null);
	}

	@Override
	public List<Patient> getAllPatientDetails() {
		List<Patient> patientList= patientRepo.findAll();
		return patientList;
	}
	
//	@Override
//	public Patient getByName(String name){
//		return patientRepo.findById(name).orElse(null);
//	}
//	
//	@Override
//	public Patient getByDoc(String doc){
//		return patientRepo.findById(doc).orElse(null);
//	}
//	
//	@Override
//	public Patient getByStage(String stage){
//		return patientRepo.findById(stage).orElse(null);
//	}
	
	
	
//	@Override
//	public void deletePatient(long id) {
//		patientRepo.findById(id).orElse(null);
//	      patientRepo.deleteById(id);
//	}
//	
	@Override
	public void deleteByID(long id) {
		try {
		      Patient patient = patientRepo.findById(id).get();
		      if (patient != null) {
		        patientRepo.delete(patient);
		      }
		    } catch (Exception e) {
		      // If an exception occurs, log the error and return an empty response
		     // logger.error("Error occurred while deleting company", e);
		      return ;
		    }
	}

	@Override
	public Patient updatePatient(Long id, Patient patient){
		Patient p=patientRepo.findById(id).orElse(null);
		return patientRepo.save(patient);
	}


}
