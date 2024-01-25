package personal.clinic.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import personal.clinic.entity.Clinic;
import personal.clinic.entity.Doctor;
import personal.clinic.entity.Nurse;

@Data
@NoArgsConstructor
public class DoctorDTO {
	private Integer doctorId;
	private String doctorFirstName;
	private String doctorLastName;
	private String leadId;
	private Set<Clinic> clinicId;
	private Set<Nurse> overseeing;
	
	
	public DoctorDTO(Doctor d) {
		this.doctorId = d.getDoctorId();
		this.doctorFirstName = d.getDoctorFirstName();
		this.doctorLastName = d.getDoctorLastName();
		this.clinicId = d.getClinic();
		this.overseeing = d.getOverseeing();
		this.leadId = d.getLeadId();
		
	}
	
}
