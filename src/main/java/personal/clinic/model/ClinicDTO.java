package personal.clinic.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import personal.clinic.entity.Admin;
import personal.clinic.entity.Clinic;
import personal.clinic.entity.Doctor;
import personal.clinic.entity.Nurse;
@Data
@NoArgsConstructor
public class ClinicDTO {
	private String clinicName;
	private String clinicStreetAddress;
	private String clinicState;
	private String clinicZip;
	private Set<Nurse> nurses;
	private Set<Doctor> doctors;
	private Set<Admin> administrativeEmployees;
	
	public ClinicDTO(Clinic c) {
		this.clinicName = c.getClinicName();
		this.clinicStreetAddress = c.getClinicStreetAddress();
		this.clinicState = c.getClinicState();
		this.clinicZip = c.getClinicZip();
		this.nurses = c.getNurses();
		this.doctors = c.getDoctors();
		this.administrativeEmployees = c.getAdministrativeEmployees();
	}
	
	public ClinicDTO(Integer clinicId, String clinicName,
			String clinicStreetAdd, String clinicState,
			String clinicZip, Set<Nurse> nurses, Set<Doctor> doctors,
			Set<Admin> adminEmp) {
		this.clinicName = clinicName;
		this.clinicState = clinicState;
		this.clinicStreetAddress = clinicStreetAdd;
		this.clinicZip = clinicZip;
		this.nurses = nurses;
		this.doctors = doctors;
		this.administrativeEmployees = adminEmp;
	}
	
	public ClinicDTO(Integer clinicId, String clinicName,
			String clinicAddr, String clinicState,
			String clinicZip) {
		this.clinicName = clinicName;
		this.clinicState = clinicState;
		this.clinicZip = clinicZip;
		this.clinicStreetAddress = clinicAddr;
	}

}
