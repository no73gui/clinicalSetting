package personal.clinic.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import personal.clinic.entity.Nurse;
import personal.clinic.model.NurseDTO;
@Mapper
@Component
public class NurseMapperImpl implements NurseMapper {

	@Override
	public NurseDTO nurseToNurseDTO(Nurse nurse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nurse nurseDTOToNurse(NurseDTO nurseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<NurseDTO> nurseListToListNurseDTO(Set<Nurse> docOversight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Nurse> listNurseDTOtoNurseList(Set<NurseDTO> listOfNurseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
