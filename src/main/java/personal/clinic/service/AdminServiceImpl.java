package personal.clinic.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.clinic.entity.Admin;
import personal.clinic.entity.Clinic;
import personal.clinic.mapper.AdminMapperImpl;
import personal.clinic.model.AdminDTO;
import personal.clinic.repository.AdminRepository;
import personal.clinic.repository.ClinicRepository;

@Service
public class AdminServiceImpl {
	
	private final AdminMapperImpl adminMapper;
	private final AdminRepository adminRepo;
	private final ClinicRepository clinicRepo;
	
	@Autowired
	public AdminServiceImpl(AdminMapperImpl adminMapper, AdminRepository adminRepo, ClinicRepository clinicRepo) {
		this.adminMapper = adminMapper;
		this.adminRepo = adminRepo;
		this.clinicRepo = clinicRepo;
	}
	
	
	
	
	public Set<AdminDTO> getAllAdminAtClinic(String clinicId){
		Set<Admin> listAdminInClinic = clinicRepo.getReferenceById(clinicId).getAdministrativeEmployees();
		
		return adminMapper.adminListToListAdminDTO(listAdminInClinic);
	
	}
	
	public AdminDTO getAdminByRef(String adminId) {
		adminRepo.getReferenceById(adminId);
		
		return adminMapper.adminToAdminDTO(adminId);
	}
	
	public AdminDTO removeAdminById(String adminId) {
		adminRepo.deleteById(adminId);
		return adminMapper.adminToAdminDTO(adminId);
	}
	
	public Set<AdminDTO> getAllAdminByClinic(String clinicId){
		Clinic clinic = clinicRepo.getReferenceById(clinicId);
		Set<Admin> listAdminAtClinic = clinic.getAdministrativeEmployees();
		return adminMapper.adminListToListAdminDTO(listAdminAtClinic);
		
	}
	
	public AdminDTO updateAdmin(String adminId, AdminDTO updatedAdmin) {
			// check if admin exists
		Optional<Admin> adminOptional= adminRepo.findById(adminId);
		// use optionals to update

		// if Admin is present, Update the fields
		if (adminOptional.isPresent()) {
			Admin existingAdmin = adminOptional.get();
			// use the updated admin to pass in the values to the existing admin.
			existingAdmin.setAdminFirstName(updatedAdmin.getAdminFirstName());
			existingAdmin.setAdminLastName(updatedAdmin.getAdminLastName());
			existingAdmin.setClinic(updatedAdmin.getClinic());

			adminRepo.save(existingAdmin);
		}
		return adminMapper.adminToAdminDTO(updatedAdmin);
		
		
	}

}
