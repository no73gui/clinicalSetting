package personal.clinic.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import personal.clinic.entity.Admin;
import personal.clinic.entity.Doctor;
import personal.clinic.entity.Nurse;
@Data
@NoArgsConstructor
public class ClinicDTO {
	
	private Integer clinicId;
	private String clinicName;
	private String clinicStreetAddress;
	private String clinicState;
	private String clinicZip;
	private Set<Nurse> nurses;
	private Set<Doctor> doctors;
	private Set<Admin> administrativeEmployees;
	

}
