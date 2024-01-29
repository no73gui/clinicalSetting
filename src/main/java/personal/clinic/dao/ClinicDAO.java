package personal.clinic.dao;

import personal.clinic.entity.Clinic;
import personal.clinic.model.ClinicDTO;

public interface ClinicDAO {
	
	void create(Clinic c);
	ClinicDTO read(Integer clinicId);
	void update(Clinic c);
	void delete(Integer clinicId);

}
