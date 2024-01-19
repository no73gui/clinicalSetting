package personal.clinic.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import personal.clinic.entity.Clinic;
import personal.clinic.entity.Doctor;

 // this DTO represents all of the data being exposed to the controller/API
@NoArgsConstructor// noArgsConstructor. @Data generates constructor.
@Data // getters and setters
public class NurseDTO {
	private String nurseId;
	private String nurseEmpNum;
	private String nurseFirstName;
	private String nurseLastName;
	private Clinic clinicId;
	private Set<Doctor> overseeing;
	
	

}
