package personal.clinic.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import personal.clinic.entity.Clinic;
import personal.clinic.mapper.ClinicMapperImpl;
import personal.clinic.model.ClinicDTO;
import personal.clinic.repository.ClinicRepository;
@Service
@Component
public class ClinicServiceImpl implements ClinicServiceInt {
	
	private final ClinicMapperImpl clinicMapper;
	private final ClinicRepository clinicRepo;
	@Autowired
	public ClinicServiceImpl(ClinicMapperImpl clinicMapper , ClinicRepository clinicRepo) {
		this.clinicMapper = clinicMapper;
		this.clinicRepo = clinicRepo;
	}
	
	
	@Override
	public Set<ClinicDTO> getAllClinics(){
		Set<Clinic>listClinics = clinicRepo.findAllClinic();
		return clinicMapper.clinicListToListCLinicDTO(listClinics);
	}
	
	
	@Override
	public ClinicDTO getClinicById(Integer clinicId) {
		Clinic clinic = clinicRepo.getReferenceById(clinicId);
		return clinicMapper.clinicToClinicDTO(clinic);
	}
	
	
	// I want this to be able to return a list of clinics within the same ZIP. What do i need to change in the entity/DTO for this to happen?
	@Override
	public Set<ClinicDTO> getClinicsInZIP(String zip){
		Set<Clinic> clinics = clinicRepo.count(getClinicsInZIP(zip));
		
		return clinicMapper.clinicListToListCLinicDTO(clinics);
	}


	@Override
	public ClinicDTO removeClinic(Integer clinicId) {
		Clinic clinic = clinicRepo.getReferenceById(clinicId);
		clinicRepo.delete(clinic);
		return clinicMapper.clinicToClinicDTO(clinic);
	}

}
