package personal.clinic.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import personal.clinic.entity.Clinic;
import personal.clinic.entity.Doctor;
import personal.clinic.entity.Nurse;

 // this DTO represents all of the data being exposed to the controller/API
@NoArgsConstructor// noArgsConstructor. @Data generates constructor.
@Data // getters and setters
public class NurseDTO {
	public NurseDTO(Nurse n) {
		this.nurseId = n.getNurseId();
		this.nurseEmpNum = n.getNurseEmpNum();
		this.nurseFirstName = n.getNurseFirstName();
		this.nurseLastName = n.getNurseLastName();
		this.clinicId = n.getClinic();
		this.overseeing = n.getOverseeing();
	}
	private Integer nurseId;
	private String nurseEmpNum;
	private String nurseFirstName;
	private String nurseLastName;
	private Clinic clinicId;
	private Set<Doctor> overseeing;
	
	

}
