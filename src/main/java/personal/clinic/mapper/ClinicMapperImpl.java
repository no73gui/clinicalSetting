package personal.clinic.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import personal.clinic.entity.Clinic;
import personal.clinic.model.ClinicDTO;
@Mapper
@Component
public class ClinicMapperImpl implements ClinicMapper {

	@Override
	public ClinicDTO clinicToClinicDTO(Clinic clinic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clinic clinicDTOToClinic(ClinicDTO clinicDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ClinicDTO> clinicListToListCLinicDTO(Set<Clinic> listOfClinic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Clinic> listClinicDTOtoClinicList(Set<ClinicDTO> listOfDoctorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
