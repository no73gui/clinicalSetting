package personal.clinic.service;

import java.util.Set;

import personal.clinic.entity.Admin;
import personal.clinic.model.AdminDTO;

//service interface is used to hold method signatures that will be used to perform action s within the Service implementation.
//unknown to me: sometimes Service class wants me to put method signature in the repo instead of in here.
public interface AdminServiceInt {
	
	Set<AdminDTO> getAllAdminAtClinic(String clinicId);
	AdminDTO createAdmin(Admin admin);
	AdminDTO getAdminByRef(String adminId);
	AdminDTO removeAdminById(Admin admin);
	Set<AdminDTO> getAllAdmin();
	AdminDTO updateAdmin(String adminId);
}
