
package personal.clinic.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import personal.clinic.model.ClinicDTO;
import personal.clinic.service.ClinicServiceImpl;

@RestController
@RequestMapping("/personal-clinic/clinic")
public class ClinicController {

	@Autowired
	private ClinicServiceImpl clinicService;

	@Autowired
	public ClinicController(ClinicServiceImpl clinicService) {
		this.clinicService = clinicService;
	}
	
	
	
	

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClinicDTO createClinic(@RequestBody ClinicDTO cDTO) {
		if(cDTO != null) {
			return clinicService.createDTOClinic(cDTO);
		}
		else {
			return clinicService.createClinic();
		}

	}

	@GetMapping("/view/{clinicId}")
	@ResponseStatus(HttpStatus.OK)
	public ClinicDTO viewClinic(@PathVariable Integer clinicId) {
		if (clinicId != null) {
			return clinicService.getClinicById(clinicId);
		} else {
			throw new NullPointerException();
		}
	}

	@GetMapping("/view/all")
	@ResponseStatus(HttpStatus.OK)
	public Set<ClinicDTO> viewAllClinic() {
		return clinicService.getAllClinics();
	}

	@GetMapping("/view/all/zip/{zip}")
	@ResponseStatus(HttpStatus.OK)
	public Set<ClinicDTO> viewAllByZip(@PathVariable String zip) {
		if (zip != null) {
			return clinicService.getClinicsInZIP(zip);
		} else {
			throw new NullPointerException();
		}
	}

	@GetMapping("/delete/{clinicId}")
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public ClinicDTO deleteClinic(@PathVariable Integer clinicId) {
		if (clinicId != null) {
			return clinicService.removeClinic(clinicId);
		}
		else {
			throw new NullPointerException();
		}
	}

}
