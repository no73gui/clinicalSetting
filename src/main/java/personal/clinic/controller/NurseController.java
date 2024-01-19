// manage flow of data
// handle input/output
// Coordinate HTTP requests to appropriate service method.
// maybe use JPA for manipulation

// SpringMVC
// @Controller or @RestController at class level
// @RequestMapping,
// @GetMapping, 
// @PostMapping,
// etc. to map HTTP requests to handler methods.
//
// Ex: 
// map HTTP request. http://localhost:8080/personalClinic/nurse
// @RequestMapping("/personalClinic/nurse") ---- class level


// GET mapping
// @GetMapping("/{id}") ---- method level, parameterized

// When using the @RequestBody annotation in a mapped method, the parameters passed into the mapped methods should be annotated with @RequestBody to indicate 
// that the data should be obtained from the request body. This annotation is used to bind the content of the HTTP request body to the method parameter, 
// allowing for the automatic conversion of incoming data into the specified parameter type.

// The request body is part of the HTTP request that contains data that is sent by the client to the server.
// 
// 
// POST mapping
// 
// @PostMapping("/create")
// public String createNurse(@RequestBody NurseDTO somthing) {
// Logic to create new book using the DTO. Maybe convert the DTO to 
// an entity and save it to the database Service}


package personal.clinic.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import personal.clinic.entity.Clinic;
import personal.clinic.entity.Nurse;
import personal.clinic.model.DoctorDTO;
import personal.clinic.model.NurseDTO;
import personal.clinic.repository.ClinicRepositoryImpl;
import personal.clinic.service.NurseServiceImpl;
@RestController
@RequestMapping("/personal-clinic/nurse")
public class NurseController {
	@Autowired
	private NurseServiceImpl nurseService;// declare, but do not instantiate the Service
											// to a value. The value will be assigned in the
											// constructor by passing the Service object into
											// the constructor and assigning it to THIS instance
											// of the controller.
	@Autowired
	private ClinicRepositoryImpl clinicRepo;
	// autowire the constructor which contains the (autowired) NurseService implementation, which utilizes 
	// Service repository and the Service interface to provice a response to the controller, which is what the user
	// is interacting with. Use NurseServiceImpl nurseService to automatically inject both these at once.
	@Autowired // constructor level
	public NurseController(NurseServiceImpl nurseService) {
		this.nurseService = nurseService; // service handles all business logic. This controller is just going
		// to send the requests to the controller and provide a DTO response through the endpoint mappings.
		
	}
	
	// after Controller constructed with Service now known, create mappings.
	// the mapping will use the Service object to know which entity is being
	// worked with.
	
	
	
	// does ID auto increment????
	
	
	
	@PostMapping("/create")// HTTP POST
	@ResponseStatus(code = HttpStatus.CREATED)
	public NurseDTO createNurse(@RequestBody NurseDTO nurseDto) {
		
		// use the Service method from the global service object
		// to create the nurse.
		// the method is origin is NurseService.
		nurseService.createNurse(nurseDto);
		
		// return a string value of the Dto converted to simple
		// string.
		return nurseDto;
		
	}
	
	@GetMapping("/view/{nurseId}") // HTTP GET
	@ResponseStatus(code = HttpStatus.OK)
	// stack @PathVariable with {} in the mapping. The name of
	// this variable needs to be the same in the path as it is in
	// the variable. It also needs to reflect the return type of
	// getNurseById.
	public NurseDTO viewNurse(@PathVariable String nurseEmpNum) {
		NurseDTO nurseDTO = null;
		if(nurseEmpNum != null) {
			try { 
				nurseDTO = nurseService.getNurseByEmpNum(nurseEmpNum);
			}
			catch (NullPointerException npe) {
				System.out.println(npe);
			}
		}
		return nurseDTO;
	}
	
	
	@GetMapping("/view/all/{clinicId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Set<NurseDTO> viewAllNurses(@PathVariable Integer clinicId) {
		return nurseService.getAllNurseByClinicId(clinicId);

	}
	
	@GetMapping("/{nurseEmpNum}/supervisor")
	@ResponseStatus(code = HttpStatus.OK)
	public Set<DoctorDTO> getSupervisingDoctor(@PathVariable String nurseLicNum){
		
		return nurseService.getSupervisingDoctor(nurseLicNum);
		
	} 
	
	
	@GetMapping("/total/nurse")
	@ResponseStatus(code = HttpStatus.OK)
	public String getCount() {
		return "Total Num of Nurse: " + nurseService.getCount();
	}
	
	
	@GetMapping("/secondView/{nurseEmpNum}")
	@ResponseStatus(code = HttpStatus.OK)
	public NurseDTO getNurseByEmpNum(@PathVariable String nurseEmpNum) {
		
		return nurseService.getNurseByEmpNum(nurseEmpNum);
	}
	
	@DeleteMapping("/delete/nurse/{nurseEmpNum}")
	@ResponseStatus(code = HttpStatus.OK)
	public NurseDTO removeNurseWithEmpNum(String nurseEmpNum) {
		
		return nurseService.removeNurseWithEmpNum(nurseEmpNum);

	}
	
	

}

