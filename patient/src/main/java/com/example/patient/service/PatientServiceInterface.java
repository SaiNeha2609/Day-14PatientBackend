package com.example.patient.service;

import java.util.List;


import com.example.patient.modal.Patient;


public interface PatientServiceInterface {
	abstract Patient savePatient(Patient patient);

	public Patient getByID(long id);
	
//	public Patient getByName(String name);
//	
//	public Patient getByDoc(String doc);
//	
//	public Patient getByStage(String stage);

	abstract List<Patient> getAllPatientDetails();
	
	public Patient updatePatient(Long id, Patient patient);

//	public void deletePatient(long id);
	public void deleteByID(long id);
	


}
