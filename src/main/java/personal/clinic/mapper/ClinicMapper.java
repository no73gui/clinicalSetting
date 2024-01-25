package personal.clinic.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import personal.clinic.entity.Clinic;
import personal.clinic.model.ClinicDTO;
@Mapper
public interface ClinicMapper {
	
	// caps by suggestion os StackO.
	ClinicMapper MAPPER = Mappers.getMapper(ClinicMapper.class);
	
	// map DtO to Nurse and vice versa
	ClinicDTO clinicToClinicDTO(Clinic clinic);
	// takes in a dto, converts to Nurse.
	Clinic clinicDTOToClinic(ClinicDTO clinicDTO);

	Set<ClinicDTO> clinicListToListCLinicDTO(Set<Clinic> listOfClinic);
	
	Set<Clinic> listClinicDTOtoClinicList(Set<ClinicDTO> listOfDoctorDTO);



	
}
