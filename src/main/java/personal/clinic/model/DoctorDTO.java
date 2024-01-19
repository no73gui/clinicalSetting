package personal.clinic.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import personal.clinic.entity.Clinic;
import personal.clinic.entity.Nurse;

@Data
@NoArgsConstructor
public class DoctorDTO {
	private String doctorId;
	private String doctorFirstName;
	private String doctorLastName;
	private Set<Clinic> clinicId;
	private Set<Nurse> overseeing;
	
}
