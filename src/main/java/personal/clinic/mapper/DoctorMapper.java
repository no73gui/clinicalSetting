package personal.clinic.mapper;

import java.util.Set;

import org.mapstruct.factory.Mappers;

import personal.clinic.entity.Doctor;
import personal.clinic.model.DoctorDTO;
//the mapper will be used to convert entities to/from DTO. 
//the mapper is utilized in the Service implementation
public interface DoctorMapper {
	
	// caps by suggestion os StackO.
	DoctorMapper MAPPER = Mappers.getMapper(DoctorMapper.class);
	
	// map DtO to entity and vice versa
	DoctorDTO doctorToDoctorDTO(Doctor doctor);
	// takes in a dto, converts to entity.
	Doctor doctorDTOToDoctor(DoctorDTO doctorDTO);

	Set<DoctorDTO> doctorListToListDoctorDTO(Set<Doctor> listOfDoctor);
	
	Set<Doctor> listDoctorDTOtoDoctorList(Set<DoctorDTO> listOfDoctorDTO);
}

