package personal.clinic.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import personal.clinic.entity.Admin;
import personal.clinic.model.AdminDTO;

@Component
public class AdminMapperImpl implements AdminMapper {

	public AdminDTO adminToAdminDTO(Admin a) {
		AdminDTO aDTO = new AdminDTO(a);
		return aDTO;
	}

	@Override
	public Admin adminDTOToAdmin(AdminDTO aDTO) {
		
		Admin a = new Admin(aDTO);
		
		return a;
	}

	@Override
	public Set<AdminDTO> adminListToListAdminDTO(Set<Admin> listOfAdmin) {
		Set<AdminDTO> aDTO = new HashSet<AdminDTO>();
		for (Admin a : listOfAdmin) {
			AdminDTO dto = new AdminDTO(a);
			aDTO.add(dto);
		}
		return aDTO;
	}

	@Override
	public Set<Admin> listAdminDTOtoAdminList(Set<AdminDTO> listOfAdminDTO) {
		Set<Admin> a = new HashSet<Admin>();
		for (AdminDTO aDTO : listOfAdminDTO) {
			Admin sA = new Admin(aDTO);
			a.add(sA);
		}
		return a;
	}

}
