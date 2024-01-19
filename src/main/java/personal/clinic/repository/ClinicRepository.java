package personal.clinic.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import personal.clinic.entity.Clinic;
import personal.clinic.model.ClinicDTO;
public interface ClinicRepository extends JpaRepository<Clinic, String>{

	Clinic getReferenceById(Integer clinicId);

	Set<Clinic> count(Set<ClinicDTO> clinicsInZIP);
	
	Set<Clinic> findAllClinic();

}
