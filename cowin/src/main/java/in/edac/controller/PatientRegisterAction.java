package in.edac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import in.edac.model.Patient;
import in.edac.repository.PatientRepository;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/patient")
public class PatientRegisterAction {

	@Autowired
	PatientRepository patientRepository;

	@PostMapping("/")
	
	public void createPatient(@RequestBody Patient patient) {
		patientRepository.save(patient);
	}

	@GetMapping("/show")
	public List<Patient> getUsers() {

		return patientRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable int id) {
		return patientRepository.findById(id).get();
	}

	@PutMapping("/{id}")
	public void updatePatient(@PathVariable int id, @RequestBody Patient user) {
		patientRepository.save(user);
	}

	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable int id) {
		patientRepository.deleteById(id);
	}

	/*
	 * @GetMapping("/login") public ModelAndView log() { ModelAndView mv=new
	 * ModelAndView("login"); return mv; }
	 */

	@PostMapping("/authPtlogin")
	public ModelAndView Authenticatepatient(String username, String password) {
		Patient patient = patientRepository.findByUsernameAndPassword(username, password);
		if (patient != null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("patient", patient);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("Appointment");
			mv.addObject("ptLogFail", 0);
			return mv;
		}
	}

}
