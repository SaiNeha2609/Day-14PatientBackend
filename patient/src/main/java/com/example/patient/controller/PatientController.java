package com.example.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.patient.modal.Patient;
import com.example.patient.service.PatientService;

@Controller
@CrossOrigin(allowedHeaders = "*")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/Patient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Patient nc = patientService.savePatient(patient);
			return new ResponseEntity<>(nc, HttpStatus.OK);
	}
	
	
	@GetMapping("/Patient/{id}")
	public ResponseEntity<?> getPatientByName(@PathVariable  long id ){
		Patient p=patientService.getByID(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@GetMapping("/info/{id}")
	public ResponseEntity<?> getPatientByDoc(@PathVariable  String doc ){
		Patient p=patientService.getByDoc(doc);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
//	
//	@GetMapping("/info/{id}")
//	public ResponseEntity<?> getPatientByStage(@PathVariable  String stage ){
//		Patient p=patientService.getByStage(stage);
//		return new ResponseEntity<>(p,HttpStatus.OK);
//	}
//	
	@GetMapping("/Patient")
	public ResponseEntity<?> getAllPatients(){
		List<Patient> patientList=patientService.getAllPatientDetails();
		return new ResponseEntity<List<Patient>>(patientList,HttpStatus.OK);
	}

//	@DeleteMapping("/delete/{id}")
//	public void deletePatient(@PathVariable Long id) {
//	       patientService.deletePatient(id);
//	    }
	
	@DeleteMapping("/Patient/{id}")
	 public ResponseEntity<?> deletePatient(@PathVariable long id) {
		    try {
		      patientService.deleteByID(id);
		      return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		    } catch (Exception e) {
		      return ResponseEntity.badRequest().body(null);
		    }
		  }
// 
	@PutMapping("/Patient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		Patient p=patientService.updatePatient(id,patient);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}

}
