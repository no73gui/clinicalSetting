package personal.clinic.service;

import java.util.Set;

import personal.clinic.model.DoctorDTO;
import personal.clinic.model.NurseDTO;
// service interface is used to hold method signatures that will be used to perform action s within the Service implementation.
// unknown to me: sometimes Service class wants me to put method signature in the repo instead of in here. 

// return types should reflect DTO
public interface NurseServiceInt {
	
	NurseDTO createNurse(NurseDTO nurseDTO);
	Set<NurseDTO> getAllNurseByClinicId(Integer clinicId);
	Set<DoctorDTO> getSupervisingDoctor(String nurseLicNum);
	Long getCount();
	NurseDTO getNurseByEmpNum(String nurseEmpNum);
	NurseDTO removeNurseWithEmpNum(String nurseEmpNum);
	
	

}
