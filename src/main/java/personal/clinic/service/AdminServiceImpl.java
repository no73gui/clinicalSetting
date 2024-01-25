package personal.clinic.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import personal.clinic.entity.Admin;
import personal.clinic.entity.Clinic;
import personal.clinic.mapper.AdminMapperImpl;
import personal.clinic.model.AdminDTO;
import personal.clinic.repository.AdminRepositoryImpl;
import personal.clinic.repository.ClinicRepositoryImpl;

@Service
public class AdminServiceImpl {
	
	private final AdminMapperImpl adminMapper;
	private final AdminRepositoryImpl adminRepo;
	private final ClinicRepositoryImpl clinicRepo;
	
	@Autowired
	public AdminServiceImpl(AdminMapperImpl adminMapper, AdminRepositoryImpl adminRepo, ClinicRepositoryImpl clinicRepo) {
		this.adminMapper = adminMapper;
		this.adminRepo = adminRepo;
		this.clinicRepo = clinicRepo;
	}
	
	
	
	
	public Set<AdminDTO> getAllAdminAtClinic(Integer clinicId){
		Clinic c = clinicRepo.getById(clinicId);
		
		Set<Admin> listAdminInClinic = c.getAdministrativeEmployees();
		
		return adminMapper.adminListToListAdminDTO(listAdminInClinic);
	
	}
	
	public AdminDTO createAdmin() {
		Admin a = new Admin();
		adminRepo.save(a);
		return adminMapper.adminToAdminDTO(a);
	}
	
	
	
	public AdminDTO getAdminByRef(Integer adminId) {
		if(adminId != null) {
			AdminDTO aDTO = adminMapper.adminToAdminDTO(adminRepo.getById(adminId));
			return aDTO;
		}
		else {
			throw new EntityNotFoundException("Admin with ID " + adminId + " does not exist.");
		}
		
	}
	
	public AdminDTO removeAdminById(Integer adminId) {
		if(adminId != null) {
			Admin a = adminRepo.getById(adminId);
			adminRepo.delete(a);
			return adminMapper.adminToAdminDTO(a);
		}
		else {
			throw new EntityNotFoundException("Admin with ID " + adminId + " does not exist.");
		}
	}
	
	public Set<AdminDTO> getAllAdminByClinic(Integer clinicId){
		Clinic clinic = clinicRepo.getById(clinicId);
		Set<Admin> listAdminAtClinic = clinic.getAdministrativeEmployees();
		return adminMapper.adminListToListAdminDTO(listAdminAtClinic);
		
	}
	
	public AdminDTO updateAdmin(Integer adminId, AdminDTO updatedAdmin) {
			// check if admin exists
		Optional<Admin> adminOptional= adminRepo.findById(adminId);
		// use optionals to update

		// if Admin is present, Update the fields
		if (adminOptional.isPresent()) {
			Admin existingAdmin = adminOptional.get();
			// use the updated admin to pass in the values to the existing admin.
			if(updatedAdmin.getAdminFirstName() != null) {
			existingAdmin.setAdminFirstName(updatedAdmin.getAdminFirstName());
			}
			if(updatedAdmin.getAdminLastName() != null) {
				existingAdmin.setAdminLastName(updatedAdmin.getAdminLastName());
			}
			if(updatedAdmin.getClinic()  != null) {
				existingAdmin.setClinic(updatedAdmin.getClinic());				
			}

			adminRepo.save(existingAdmin);
			
			return adminMapper.adminToAdminDTO(existingAdmin);
		}
		
		else {
			throw new EntityNotFoundException("Admin with ID " + adminId + " does not exist.");
		}
		
		
	}

}
