package personal.clinic.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import personal.clinic.dao.NurseDAOImpl;
import personal.clinic.entity.Clinic;
import personal.clinic.entity.Doctor;
import personal.clinic.entity.Nurse;
import personal.clinic.mapper.NurseMapperImpl;
import personal.clinic.model.DoctorDTO;
import personal.clinic.model.NurseDTO;
import personal.clinic.repository.ClinicRepositoryImpl;
import personal.clinic.repository.NurseRepositoryImpl;

@Service
public class NurseServiceImpl {

	private final NurseRepositoryImpl nurseRepo;
	private final NurseMapperImpl nurseMapper;
	private final ClinicRepositoryImpl clinicRepo;
	private final NurseDAOImpl nurseDAO;

	@Autowired
	public NurseServiceImpl(NurseRepositoryImpl nurseRepo, NurseMapperImpl nurseMapper, 
			ClinicRepositoryImpl clinicRepo,
			NurseDAOImpl nurseDAO) {
		this.nurseMapper = nurseMapper;
		this.nurseRepo = nurseRepo;
		this.clinicRepo = clinicRepo;
		this.nurseDAO = nurseDAO;
	}

	@Transactional
	public String createNurse(NurseDTO nDTO) {
		System.out.println("createNurse() in NurseServiceImpl reached.");
		// Implement the logic to create a nurse
		if(nDTO != null) {
			Nurse n = nurseMapper.nurseDTOToNurse(nDTO);
			
			nurseDAO.create(n);
			return "New Nurse Created using DTO.";
		}
		else {
			Nurse n = new Nurse();
			nurseDAO.create(n);
			return "Empty Nurse Created.";
		}

		// Return the created NurseDTO

	}

	public Set<NurseDTO> getAllNurseByClinicId(Integer clinicId) throws NullPointerException {
		Set<NurseDTO> nDTO = null;
		if (clinicId != null) {
					
			Clinic c = clinicRepo.getById(clinicId);
			c.getNurses();
			nDTO = nurseMapper.nurseListToListNurseDTO(c.getNurses());
			return nDTO;
		}
		else {
			throw new NullPointerException("Clinic ID can not be null.");
		}

	}

	public Set<DoctorDTO> getSupervisingDoctor(String nurseLicNum) throws EntityNotFoundException {
		if(nurseLicNum != null) {
			Set<DoctorDTO> oS = new HashSet<DoctorDTO>();
			for(DoctorDTO d : nurseRepo.getSupervisingDoctor(nurseLicNum)) {
				oS.add(d);
			}
			return oS;
		}
		else {
			throw new EntityNotFoundException("Nurse with ID: " + nurseLicNum + " could not be found.");
		}
	}

	
	public Long getCount() {
		return nurseRepo.count();
	}

	@Transactional
	public void removeNurseWithEmpNum(Integer nurseEmpNum) {
		nurseDAO.delete(nurseEmpNum);

	}
	
	@Transactional
	public NurseDTO update(Integer nurseId, Clinic clinic, String firstName,
			String lastName,
			Set<Doctor> overseeing) {
		
		if(nurseId != null) {
			Nurse n = nurseRepo.getReferenceById(nurseId);
			if(clinic != null) {
				n.setClinic(clinic);
			}
			if(firstName != null) {
				n.setNurseFirstName(firstName);
			}
			if(lastName != null)  {
				n.setNurseLastName(lastName);
			}
			if(overseeing != null) {
				n.setOverseeing(overseeing);
			}
			nurseRepo.save(n);
		
			return nurseMapper.nurseToNurseDTO(n);
		}
		else {
			throw new EntityNotFoundException("Nurse with ID " + nurseId + " could not be found.");
		}
	}

	public NurseDTO find(Integer nurseId) {
		NurseDTO n = nurseDAO.read(nurseId);
		return n;
	}

}
