package personal.clinic.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import personal.clinic.entity.Admin;
import personal.clinic.entity.Clinic;

@Data
@NoArgsConstructor
public class AdminDTO {
	
	private Integer adminId;
	private String adminFirstName;
	private String adminLastName;
	private Clinic clinic;
	
	public AdminDTO(Admin a) {
		this.adminId = a.getAdminId();
		this.adminFirstName = a.getAdminFirstName();
		this.adminLastName = a.getAdminLastName();
		this.clinic = a.getClinic();
	
	}

}
