package personal.clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import personal.clinic.entity.Clinic;

@Data
@NoArgsConstructor
public class AdminDTO {
	
	private String adminId;
	private String adminFirstName;
	private String adminLastName;
	private Clinic clinic;

}
