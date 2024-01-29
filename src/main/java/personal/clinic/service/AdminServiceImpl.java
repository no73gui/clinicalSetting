package personal.clinic.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import personal.clinic.dao.AdminDAOImpl;
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
	private final AdminDAOImpl adminDAO;
	
	@Autowired
	public AdminServiceImpl(AdminMapperImpl adminMapper, AdminRepositoryImpl adminRepo, ClinicRepositoryImpl clinicRepo,
		AdminDAOImpl adminDAO) {
		this.adminMapper = adminMapper;
		this.adminRepo = adminRepo;
		this.clinicRepo = clinicRepo;
		this.adminDAO = adminDAO;
	}
	
	
	
	
	public Set<AdminDTO> getAllAdminAtClinic(Integer clinicId){
		Clinic c = clinicRepo.getById(clinicId);
		
		Set<Admin> listAdminInClinic = c.getAdministrativeEmployees();
		
		return adminMapper.adminListToListAdminDTO(listAdminInClinic);
	
	}
	
	public AdminDTO createAdmin(AdminDTO aDTO) {
		
		if(aDTO != null) {
			Admin a = new Admin(aDTO);
			adminDAO.create(a);
			return adminMapper.adminToAdminDTO(a);
		}
		else {
			Admin a = new Admin(aDTO);
			adminDAO.create(a);
			return adminMapper.adminToAdminDTO(a);
		}
			
	}
	
	
	
	public AdminDTO getAdminByRef(Integer adminId) {
		if(adminId != null) {
			AdminDTO aDTO = adminDAO.read(adminId);
			return aDTO;
		}
		else {
			throw new EntityNotFoundException("Admin with ID " + adminId + " does not exist.");
		}
		
	}
	
	public void removeAdminById(Integer adminId) {
		if(adminId != null) {
			adminDAO.delete(adminId);
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
