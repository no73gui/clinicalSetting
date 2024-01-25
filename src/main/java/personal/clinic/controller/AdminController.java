package personal.clinic.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import personal.clinic.model.AdminDTO;
import personal.clinic.service.AdminServiceImpl;


@RestController
@RequestMapping("/personal-clinic/admin")
public class AdminController {
	@Autowired
	private AdminServiceImpl adminService;

	@Autowired
	public AdminController(AdminServiceImpl adminService) {
		this.adminService = adminService;
	}

	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public AdminDTO createAdmin() {
		return adminService.createAdmin();
	}
	
	@GetMapping("/view/all/atClinic/{clinicId}")
	@ResponseStatus(HttpStatus.OK)
	public Set<AdminDTO> getAllAdminAtClinic(@PathVariable Integer clinicId) {
		if (clinicId != null) {
			return adminService.getAllAdminAtClinic(clinicId);
		}
		else {
			throw new NullPointerException();
		}
	}

	@GetMapping("/view/{adminId}")
	@ResponseStatus(HttpStatus.OK)
	public AdminDTO getAdminByRef(@PathVariable Integer adminId) {
		if (adminId != null) {
			return adminService.getAdminByRef(adminId);
		}
		else {
			throw new NullPointerException();
		}
	}

	@DeleteMapping("/delete/{adminId}")
	@ResponseStatus(HttpStatus.OK)
	public AdminDTO removeAdminById(@PathVariable Integer  adminId) {
		if (adminId != null) {
			return adminService.removeAdminById(adminId);
		} else {
			throw new NullPointerException();
		}
	}

	@PutMapping("/update/admin/{adminId}")
	@ResponseStatus(HttpStatus.OK)
	public AdminDTO updateAdmin(@PathVariable Integer adminId,@RequestBody AdminDTO updatedAdmin) {
		// check if admin exists
		if (adminId != null) {
			return adminService.updateAdmin(adminId, updatedAdmin);
		} else {
			throw new NullPointerException();
		}
	}

}
