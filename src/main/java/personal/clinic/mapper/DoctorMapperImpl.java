package personal.clinic.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import personal.clinic.entity.Doctor;
import personal.clinic.model.DoctorDTO;

@Mapper
@Component
public class DoctorMapperImpl implements DoctorMapper {

	@Override
	public DoctorDTO doctorToDoctorDTO(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor doctorDTOToDoctor(DoctorDTO doctorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<DoctorDTO> doctorListToListDoctorDTO(Set<Doctor> listOfDoctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Doctor> listDoctorDTOtoDoctorList(Set<DoctorDTO> listOfDoctorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
