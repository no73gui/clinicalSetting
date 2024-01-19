package personal.clinic.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import personal.clinic.entity.Clinic;
import personal.clinic.entity.Nurse;
import personal.clinic.mapper.NurseMapperImpl;
import personal.clinic.model.DoctorDTO;
import personal.clinic.model.NurseDTO;
import personal.clinic.repository.ClinicRepository;
import personal.clinic.repository.NurseRepository;

@Service
public class NurseServiceImpl implements NurseServiceInt {

	private final NurseRepository nurseRepo;
	private final NurseMapperImpl nurseMapper;
	private final ClinicRepository clinicRepo;

	@Autowired
	public NurseServiceImpl(NurseRepository nurseRepo, NurseMapperImpl nurseMapper, ClinicRepository clinicRepo) {
		this.nurseMapper = nurseMapper;
		this.nurseRepo = nurseRepo;
		this.clinicRepo = clinicRepo;

	}

	@Override
	@Transactional
	public NurseDTO createNurse(NurseDTO nurseDto) {
		// Implement the logic to create a nurse

		Nurse nurse = new Nurse();
		nurse.setNurseId(nurseDto.getNurseId());
		nurse.setNurseFirstName(nurseDto.getNurseFirstName());
		nurse.setNurseLastName(nurseDto.getNurseLastName());
		nurse.setClinic(nurseDto.getClinicId());
		nurse.setNurseEmpNum(nurseDto.getNurseEmpNum());
		nurse.setOverseeing(nurseDto.getOverseeing());
		// Convert DTO to entity using the mapper
		nurseMapper.nurseDTOToNurse(nurseDto);
		// Save to the repository
		nurseRepo.save(nurse);

		// Return the created NurseDTO
		return nurseDto;

	}

	@Override
	public Set<NurseDTO> getAllNurseByClinicId(Integer clinicId) throws NullPointerException {
		Set<NurseDTO> nDTO = null;
		if (clinicId != null) {
					
			Clinic c = clinicRepo.getReferenceById(clinicId);
			c.getNurses();
			nDTO = nurseMapper.nurseListToListNurseDTO(c.getNurses());
			return nDTO;
		}
		else {
			throw new NullPointerException("Clinic ID can not be null.");
		}

	}

	@Override
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

	
	@Override
	@Transactional
	public Long getCount() {
		return nurseRepo.count();
	}

	@Override
	@Transactional
	public NurseDTO getNurseByEmpNum(String nurseEmpNum) {
		if (nurseEmpNum != null) {
			Nurse nurse = nurseRepo.getReferenceById(nurseEmpNum);
			
			return nurseMapper.nurseToNurseDTO(nurse);
			
		}
		else {
			throw new EntityNotFoundException("Nurse Employee Number is null or cannot be found.");
		}
		

	}

	@Override
	@Transactional
	public NurseDTO removeNurseWithEmpNum(String nurseEmpNum) {
		Nurse nurse = nurseRepo.getReferenceById(nurseEmpNum);

		if (nurseRepo.existsById(nurseEmpNum)) {
			nurseRepo.delete(nurse);
			nurseRepo.save(nurse);
		}

		return nurseMapper.nurseToNurseDTO(nurse);

	}

}
