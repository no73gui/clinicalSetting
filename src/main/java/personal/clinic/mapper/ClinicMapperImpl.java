package personal.clinic.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import personal.clinic.entity.Clinic;
import personal.clinic.model.ClinicDTO;

@Component
public class ClinicMapperImpl implements ClinicMapper {

	@Override
	public ClinicDTO clinicToClinicDTO(Clinic c) {
		ClinicDTO cDTO = new ClinicDTO(c);
		
		return cDTO;
	}

	@Override
	public Clinic clinicDTOToClinic(ClinicDTO cDTO) {
		Clinic c = new Clinic(cDTO);
		
		return c;
	}

	@Override
	public Set<ClinicDTO> clinicListToListCLinicDTO(Set<Clinic> lc) {
		Set<ClinicDTO> lcDTO = new HashSet<ClinicDTO>();
		for (Clinic c : lc ) {
			ClinicDTO dto = new ClinicDTO(c);
			lcDTO.add(dto);
		}
		return lcDTO;
	}

	@Override
	public Set<Clinic> listClinicDTOtoClinicList(Set<ClinicDTO> lcDTO) {
		Set<Clinic> lc = new HashSet<Clinic>();
		for (ClinicDTO cDTO : lcDTO) {
			Clinic c = new Clinic(cDTO);
			lc.add(c);
		}
		return lc;
	}

}
