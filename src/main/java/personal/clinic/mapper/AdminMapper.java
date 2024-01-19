package personal.clinic.mapper;

import java.util.Set;

import org.mapstruct.factory.Mappers;

import personal.clinic.entity.Admin;
import personal.clinic.model.AdminDTO;

public interface AdminMapper {
	
	// caps by suggestion os StackO.
	AdminMapper MAPPER = Mappers.getMapper(AdminMapper.class);
	
	// map DtO to Nurse and vice versa
	AdminDTO adminToAdminDTO(String adminId);
	// takes in a dto, converts to Nurse.
	Admin adminDTOToAdmin(AdminDTO adminDTO);

	Set<AdminDTO> adminListToListAdminDTO(Set<Admin> listOfAdmin);
	
	Set<Admin> listAdminDTOtoAdminList(Set<AdminDTO> listOfAdminDTO);
	
	AdminDTO adminToAdminDTO(AdminDTO updatedAdmin);
}

