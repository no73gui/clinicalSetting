package personal.clinic.dao;

import personal.clinic.entity.Nurse;
import personal.clinic.model.NurseDTO;

public interface NurseDAO {
	
	
	void create(Nurse n);
	NurseDTO read(Integer nurseId);
	void update(Nurse n);
	void delete(Integer nurseId);

}
