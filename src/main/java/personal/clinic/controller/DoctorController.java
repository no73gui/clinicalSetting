
package personal.clinic.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import personal.clinic.model.DoctorDTO;
import personal.clinic.model.NurseDTO;
import personal.clinic.service.DoctorService;

@RestController
@RequestMapping("/personal-clinic/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@Autowired
	public DoctorController(DoctorService docService) {
		this.doctorService = docService;
	}
	
	
	
	

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public DoctorDTO createDoctor() {

		return doctorService.createDoctor();

	}

	@GetMapping("/view/overseeing")
	public Set<NurseDTO> getOverseeing(Integer docId) {
		if (docId != null) {
			return doctorService.getOverseeing(docId);
		}
		else {
			throw new NullPointerException();
		}
	}

	
	
	@GetMapping("/view/allDocs")
	@ResponseStatus(HttpStatus.OK)
	public Set<DoctorDTO> getAll() {
		return doctorService.getAll();

	}

	@GetMapping("/view/doc/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DoctorDTO getDoctorByEmpNum(Integer id) {
		if (id != null) {
			return doctorService.getDoctorByEmpNum(id);
		} else {
			throw new EntityNotFoundException("Doctor with ID : " + id + " could not be found.");
		}
	}

	@DeleteMapping("/remove/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DoctorDTO removeDoctor(Integer id) {
		if (id != null) {
			return doctorService.removeDoctor(id);
		} else {
			throw new EntityNotFoundException("Doctor with ID: " + id + " could not be found.");
		}
	}
	
	@PutMapping("/update/doctor/{doctorId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public DoctorDTO updateDoctor(@PathVariable Integer docId, @RequestBody String firstName, @RequestBody String lastName ) {
		if(docId != null) {
			return doctorService.update(docId,firstName,lastName);
		}
		else {
			throw new NullPointerException();
		}
	}
}
