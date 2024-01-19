package personal.clinic.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personal.clinic.entity.Clinic;
import personal.clinic.entity.Doctor;
import personal.clinic.entity.Nurse;
import personal.clinic.mapper.DoctorMapperImpl;
import personal.clinic.mapper.NurseMapperImpl;
import personal.clinic.model.DoctorDTO;
import personal.clinic.model.NurseDTO;
import personal.clinic.repository.ClinicRepositoryImpl;
import personal.clinic.repository.DoctorRepositoryImpl;
@Service
public class DoctorService {
	
	private final DoctorMapperImpl docMapper;
	private final ClinicRepositoryImpl clinicRepo;
	private final DoctorRepositoryImpl docRepo;
	private final NurseMapperImpl nurseMapper;
	
	
	@Autowired
	public DoctorService(DoctorMapperImpl docMapper, ClinicRepositoryImpl clinicRepo,DoctorRepositoryImpl docRepo, NurseMapperImpl nurseMapper) {
		this.docMapper = docMapper;
		this.clinicRepo = clinicRepo;
		this.docRepo = docRepo;
		this.nurseMapper = nurseMapper;
	}
	@Transactional
	public DoctorDTO createDoctor() {
		// convert DTO to entity, save to DB, convert back to DTO and return to Controller/API
		Doctor d = new Doctor();
		// commit transaction
		docRepo.save(d);
		
		return docMapper.doctorToDoctorDTO(d);
	}
	
	
	
	public Set<NurseDTO> getOverseeing(String doctorLicNum){
		Set<Nurse> listNurse = docRepo.getReferenceById(doctorLicNum).getOverseeing(); 
		
		return nurseMapper.nurseListToListNurseDTO(listNurse);
		
	}
	public Set<DoctorDTO> getAll(){
		Set<Doctor> listDoc = docRepo.findAllDoc();// returns entity objects
		
		return docMapper.doctorListToListDoctorDTO(listDoc);
	}
	public DoctorDTO getDoctorByEmpNum(String docLicNum) {
		Doctor doctor = docRepo.getReferenceById(docLicNum);
		
		return docMapper.doctorToDoctorDTO(doctor);
	}
	public DoctorDTO removeDoctor(String docLicNum) {
		Doctor doctor = docRepo.getReferenceById(docLicNum);
		
		docRepo.delete(doctor);

		return docMapper.doctorToDoctorDTO(doctor);
		
	}


	public Set<DoctorDTO> getAllByClinicId(Integer clinicId) {
		Clinic clinic = clinicRepo.getReferenceById(clinicId);
		Set<Doctor> doctors = clinic.getDoctors();
		
		return docMapper.doctorListToListDoctorDTO(doctors);
	}

}
