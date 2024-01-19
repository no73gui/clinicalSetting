// the entity package contains entities which use JPA and Lombok for entity declaration and getter/setter generation.

package personal.clinic.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Embeddable
@Data
@Table(name = "nurse")
@NoArgsConstructor
public class Nurse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nurse_id")
	private String nurseId;
	
	@Column(name = "employee_num", nullable = false)
	private String nurseEmpNum;
	
	@Column(name = "first_name")
	private String nurseFirstName;
	
	@Column(name = "last_name")
	private String nurseLastName;
	
	// Many nurse can be assigned to one clinic.
	// this is the 
	// What column from the Owning side do i want to bring over to this table/entity? 
	// JoinColumn represents the Foreign Key in this class, But the Primary from the Clinic class.
	// Clinic is the owning side, so, I want to bring over the Clinic object under a "clinic_id" column 
	// that represents the primary key from Clinic
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "clinic_id", nullable = false)
	private Clinic clinic;

	
	
	
	
	// many nurse can be assigned to multiple doctor.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "nurse_doctor", joinColumns = @JoinColumn(
			name = "nurse_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id"))
	private Set<Doctor> overseeing = new HashSet<>();
	
	
	
	public Nurse(String licNumNurseId, String empNum, String firstName, String lastName, Set<Doctor> leads, Clinic clinic) {
		this.nurseId = licNumNurseId;
		this.nurseEmpNum = empNum;
		this.nurseFirstName = firstName;
		this.nurseLastName = lastName;
		this.overseeing = leads;
		this.clinic = clinic;
		
	}


}
