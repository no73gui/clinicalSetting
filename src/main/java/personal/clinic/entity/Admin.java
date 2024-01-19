//the entity package contains entities which use JPA and Lombok for entity declaration and getter/setter generation.

package personal.clinic.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "admin")
@NoArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private String adminId;
	
	@Column(name = "admin_first_name")
	private String adminFirstName;
	
	@Column(name = "admin_last_name")
	private String adminLastName;
	
	@ManyToOne
	@JoinColumn(name = "clinic_id", nullable = false)
	private Clinic clinic;
	
	
	public Admin(String id, String fName, String lName, Clinic clinicAffiliation) {
		this.adminId = id;
		this.adminFirstName = fName;
		this.adminLastName = lName;
		this.clinic = clinicAffiliation;
	}

}
