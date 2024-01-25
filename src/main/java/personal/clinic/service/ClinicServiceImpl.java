package personal.clinic.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import personal.clinic.entity.Clinic;
import personal.clinic.mapper.ClinicMapper;
import personal.clinic.mapper.ClinicMapperImpl;
import personal.clinic.model.ClinicDTO;
import personal.clinic.repository.ClinicRepositoryImpl;

@Service
@Transactional
public class ClinicServiceImpl {
	@Autowired
	private final ClinicMapper clinicMapper;
	@Autowired
	private final ClinicRepositoryImpl clinicRepo;
	
	@Autowired
	public ClinicServiceImpl(ClinicMapperImpl clinicMapper, ClinicRepositoryImpl clinicRepo) {
	this.clinicMapper = clinicMapper;
	this.clinicRepo = clinicRepo;

}

	public Set<ClinicDTO> getAllClinics() {
		Set<Clinic> lc = new HashSet<Clinic>();

		List<Clinic> listClinics = clinicRepo.findAll();
		for(Clinic c : listClinics) {
			lc.add(c);
			
		}
		return clinicMapper.clinicListToListCLinicDTO(lc);
		
	}

	public ClinicDTO getClinicById(Integer clinicId) {
		Clinic clinic = clinicRepo.getById(clinicId);
		return clinicMapper.clinicToClinicDTO(clinic);
	}

	// I want this to be able to return a list of clinics within the same ZIP. What
	// do i need to change in the entity/DTO for this to happen?
	public Set<ClinicDTO> getClinicsInZIP(String zip) {
		Set<Clinic> clinics = clinicRepo.count(getClinicsInZIP(zip));

		return clinicMapper.clinicListToListCLinicDTO(clinics);
	}

	@Transactional
	public ClinicDTO removeClinic(Integer clinicId) {
		Clinic clinic = clinicRepo.getById(clinicId);
		clinicRepo.delete(clinic);
		return clinicMapper.clinicToClinicDTO(clinic);
	}
	
	public ClinicDTO createDTOClinic(ClinicDTO cDTO) {
			Clinic c = new Clinic(cDTO);
			clinicRepo.saveAndFlush(c);
			System.out.println("Entered into Service Layer. Create ClinicDTO.");
			return clinicMapper.clinicToClinicDTO(c);
		
	}
	
	public ClinicDTO createClinic() {
		Clinic c = new Clinic();
		clinicRepo.saveAndFlush(c);
		System.out.println("Entered into Service Layer. Create Clinic.");
		return clinicMapper.clinicToClinicDTO(c);
	}

}
