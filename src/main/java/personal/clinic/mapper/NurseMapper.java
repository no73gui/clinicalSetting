package personal.clinic.mapper;

import java.util.Set;

import org.mapstruct.factory.Mappers;

import personal.clinic.entity.Nurse;
import personal.clinic.model.NurseDTO;

// the mapper will be used to convert entities to/from DTO. 
// the mapper is utilized in the Service implementation
public interface NurseMapper {
	
	// caps by suggestion os StackO.
	NurseMapper MAPPER = Mappers.getMapper(NurseMapper.class);
	
	// map DtO to Nurse and vice versa
	NurseDTO nurseToNurseDTO(Nurse nurse);
	// takes in a dto, converts to Nurse.
	Nurse nurseDTOToNurse(NurseDTO nurseDTO);

	Set<NurseDTO> nurseListToListNurseDTO(Set<Nurse> listOfNurse);
	
	Set<Nurse> listNurseDTOtoNurseList(Set<NurseDTO> listOfNurseDTO);
}
