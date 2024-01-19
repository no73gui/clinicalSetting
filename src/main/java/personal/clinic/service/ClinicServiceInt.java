package personal.clinic.service;

import java.util.Set;

import personal.clinic.model.ClinicDTO;

//service interface is used to hold method signatures that will be used to perform action s within the Service implementation.
//unknown to me: sometimes Service class wants me to put method signature in the repo instead of in here.

//return types should reflect DTO
public interface ClinicServiceInt {
	
	Set<ClinicDTO> getAllClinics();
	ClinicDTO getClinicById(Integer clinicId);
	Set<ClinicDTO> getClinicsInZIP(String zip);
	ClinicDTO removeClinic(Integer clinicId);

}
