package personal.clinic.dao;

import personal.clinic.entity.Admin;
import personal.clinic.model.AdminDTO;

public interface AdminDAO {
	
	
	void create(Admin a);
	AdminDTO read(Integer adminId);
	void update(Admin a);
	void delete(Integer adminId);

}
