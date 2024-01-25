
//the entity package contains entities which use JPA and Lombok for entity declaration and getter/setter generation.

package personal.clinic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import personal.clinic.model.AdminDTO;

@Entity
@Data
@Table(name = "admin")
@Embeddable
@NoArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Integer adminId;
	
	@Column(name = "admin_first_name")
	private String adminFirstName;
	
	@Column(name = "admin_last_name")
	private String adminLastName;
	
	@ManyToOne
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;
	
	public Admin(AdminDTO aDTO) {
		this.adminFirstName = aDTO.getAdminFirstName();
		this.adminLastName = aDTO.getAdminLastName();
		this.clinic = aDTO.getClinic();
	}
	

}
