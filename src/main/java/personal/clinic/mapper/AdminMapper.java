package personal.clinic.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import personal.clinic.entity.Admin;
import personal.clinic.model.AdminDTO;
@Mapper
public interface AdminMapper {
	
	// caps by suggestion os StackO.
	AdminMapper MAPPER = Mappers.getMapper(AdminMapper.class);
	
	// map DtO to Nurse and vice versa
	AdminDTO adminToAdminDTO(Admin a);
	// takes in a dto, converts to Nurse.
	Admin adminDTOToAdmin(AdminDTO aDTO);

	Set<AdminDTO> adminListToListAdminDTO(Set<Admin> listOfAdmin);
	
	Set<Admin> listAdminDTOtoAdminList(Set<AdminDTO> listOfAdminDTO);
}

