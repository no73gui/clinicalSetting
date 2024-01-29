package personal.clinic.dao;

import personal.clinic.entity.Doctor;
import personal.clinic.model.DoctorDTO;

public interface DoctorDAO {
	
	void create(Doctor d);
	DoctorDTO read(Integer doctorId);
	void update(Doctor d);
	void delete(Integer doctorId);	

}
