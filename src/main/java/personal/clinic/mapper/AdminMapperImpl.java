package personal.clinic.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import personal.clinic.entity.Admin;
import personal.clinic.model.AdminDTO;
@Mapper
@Component
public class AdminMapperImpl implements AdminMapper {

	@Override
	public AdminDTO adminToAdminDTO(String adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin adminDTOToAdmin(AdminDTO adminDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<AdminDTO> adminListToListAdminDTO(Set<Admin> listOfAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Admin> listAdminDTOtoAdminList(Set<AdminDTO> listOfAdminDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminDTO adminToAdminDTO(AdminDTO updatedAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

}
