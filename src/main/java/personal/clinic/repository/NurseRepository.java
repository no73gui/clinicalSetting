package personal.clinic.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import personal.clinic.entity.Nurse;
import personal.clinic.model.DoctorDTO;
import personal.clinic.model.NurseDTO;

// Repository interface is what will be used for the Service layer to interact with the database. JPA gets CRUD methods.

public interface NurseRepository extends  JpaRepository<Nurse, Integer>{
	
	Set<DoctorDTO> getSupervisingDoctor(String nurseLicNum);

	NurseDTO createNurse(NurseDTO nurseDto);
}
