package personal.clinic.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import personal.clinic.entity.Doctor;
import personal.clinic.entity.Nurse;
import personal.clinic.mapper.DoctorMapperImpl;
import personal.clinic.mapper.NurseMapperImpl;
import personal.clinic.model.DoctorDTO;
import personal.clinic.model.NurseDTO;
import personal.clinic.repository.DoctorRepository;
import personal.clinic.service.DoctorService;

@RestController
@RequestMapping("/personal-clinic/doctor")
public class DoctorController {
	
	private final DoctorService doctorService;
	private final DoctorRepository doctorRepo;
	private final DoctorMapperImpl docMapper;
	private final NurseMapperImpl nurseMapper;
	
	@Autowired
	public DoctorController(DoctorService docService , DoctorRepository docRepo, 
			NurseMapperImpl nurseMapper, DoctorMapperImpl docMapper) {
		this.doctorService = docService;
		this.doctorRepo = docRepo;
		this.nurseMapper = nurseMapper;
		this.docMapper = docMapper;
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public DoctorDTO createDoctor() {
		
		return doctorService.createDoctor();
				
		
	}
	
	@GetMapping("/view/overseeing")
	public Set<NurseDTO> getOverseeing(String doctorLicNum){
		Doctor doctor = doctorRepo.getReferenceById(doctorLicNum);
		Set<Nurse> docOversight = doctor.getOverseeing();
		return nurseMapper.nurseListToListNurseDTO(docOversight);
		
	}
	public Set<DoctorDTO> getAll(){
		Set<Doctor> listDoctor = doctorRepo.findAllDoc();
		return docMapper.doctorListToListDoctorDTO(listDoctor);
		
		
		
	}
	public DoctorDTO getDoctorByEmpNum(String docLicNum) {
		
		Doctor doctor = doctorRepo.getReferenceById(docLicNum);
		return docMapper.doctorToDoctorDTO(doctor);
		
		
	}
	public String removeDoctor(String docLicNum) {
		
		Doctor doctor = doctorRepo.getReferenceById(docLicNum);
		doctorRepo.delete(doctor);
		
		return "Successfully Deleted Doctor : " + docLicNum;
	}

}
