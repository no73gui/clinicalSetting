package personal.clinic.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import personal.clinic.entity.Doctor;
import personal.clinic.model.DoctorDTO;

@Component
public class DoctorMapperImpl implements DoctorMapper {

	
	@Override
	public DoctorDTO doctorToDoctorDTO(Doctor doctor) {
		DoctorDTO dDTO = new DoctorDTO(doctor);
		return dDTO;
	}

	@Override
	public Doctor doctorDTOToDoctor(DoctorDTO doctorDTO) {
		Doctor d = new Doctor(doctorDTO);
		return d;
	}

	@Override
	public Set<DoctorDTO> doctorListToListDoctorDTO(Set<Doctor> listOfDoctor) {
		Set<DoctorDTO> sDTO = new HashSet<DoctorDTO>();
		for (Doctor d : listOfDoctor) {
			DoctorDTO dDTO = new DoctorDTO(d);
			sDTO.add(dDTO);
		}
		return sDTO;
	}

	@Override
	public Set<Doctor> listDoctorDTOtoDoctorList(Set<DoctorDTO> listOfDoctorDTO) {
		Set<Doctor> sD = new HashSet<Doctor>();
		for(DoctorDTO dDTO : listOfDoctorDTO) {
			Doctor d = new Doctor(dDTO);
			sD.add(d);
		}
		return sD;
	}

}
