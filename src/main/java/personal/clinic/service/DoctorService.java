package personal.clinic.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
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
	private final DoctorRepositoryImpl docRepo;
	private final NurseMapperImpl nurseMapper;
	
	
	@Autowired
	public DoctorService(DoctorMapperImpl docMapper, ClinicRepositoryImpl clinicRepo,DoctorRepositoryImpl docRepo, NurseMapperImpl nurseMapper) {
		this.docMapper = docMapper;
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
	
	
	// GET non transactionaL
	public Set<NurseDTO> getOverseeing(Integer docId){
		Set<Nurse> listNurse = docRepo.getById(docId).getOverseeing(); 
		
		return nurseMapper.nurseListToListNurseDTO(listNurse);
		
	}
	
	
	
	public Set<DoctorDTO> getAll(){
		Set<Doctor> listDoc = docRepo.findAllDoc();// returns entity objects
		
		return docMapper.doctorListToListDoctorDTO(listDoc);
	}
	
	
	
	
	public DoctorDTO getDoctorByEmpNum(Integer docLicNum) {
		Doctor doctor = docRepo.getReferenceById(docLicNum);
		
		return docMapper.doctorToDoctorDTO(doctor);
	}
	
	
	
	
	public DoctorDTO removeDoctor(Integer id) {
		Doctor doctor = docRepo.getReferenceById(id);
		
		docRepo.delete(doctor);

		return docMapper.doctorToDoctorDTO(docRepo.save(doctor));
		
	}





	public DoctorDTO update(Integer docId, String firstName, String lastName) {
		if(docRepo.existsById(docId)) {
			Doctor d = docRepo.getReferenceById(docId);
			if(firstName != null) {
				d.setDoctorFirstName(firstName);
			}
			if(lastName != null) {
				d.setDoctorLastName(lastName);
			}
			return docMapper.doctorToDoctorDTO(d);
		}
		else {
			throw new EntityNotFoundException();
		}
			
	}

}
