package personal.clinic.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import personal.clinic.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String>{
 	Set<Doctor> findAllDoc();

}
