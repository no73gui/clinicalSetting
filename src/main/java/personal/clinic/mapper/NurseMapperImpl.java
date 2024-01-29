package personal.clinic.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import personal.clinic.entity.Nurse;
import personal.clinic.model.NurseDTO;
@Component
public class NurseMapperImpl implements NurseMapper {

	@Override
	public NurseDTO nurseToNurseDTO(Nurse nurse) {
		NurseDTO nDTO = new NurseDTO(nurse);
		
		return nDTO;
	}

	@Override
	public Nurse nurseDTOToNurse(NurseDTO nurseDTO) {
		Nurse n = new Nurse();
		n.setNurseFirstName(nurseDTO.getNurseFirstName());
		n.setNurseLastName(nurseDTO.getNurseLastName());
		n.setNurseEmpNum(nurseDTO.getNurseEmpNum());
		if(nurseDTO.getClinicId() != null) {
			n.setClinic(nurseDTO.getClinicId());
		}
		if(nurseDTO.getOverseeing() != null) {
			n.setOverseeing(nurseDTO.getOverseeing());
		}
		
		return n;
	}

	@Override
	public Set<NurseDTO> nurseListToListNurseDTO(Set<Nurse> nurses) {
		Set<NurseDTO> sNDTO = new HashSet<NurseDTO>();
		for(Nurse n : nurses) {
			NurseDTO nDTO = new NurseDTO(n);
			sNDTO.add(nDTO);
		}
		return sNDTO;
	}

	@Override
	public Set<Nurse> listNurseDTOtoNurseList(Set<NurseDTO> listOfNurseDTO) {
		Set<Nurse> sN = new HashSet<Nurse>();
		for (NurseDTO nDTO : listOfNurseDTO) {
			Nurse n = new Nurse(nDTO);
			sN.add(n);
		}
		return sN;
	}

}
