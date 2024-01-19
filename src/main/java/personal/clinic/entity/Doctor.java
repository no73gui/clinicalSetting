// the entity package contains entities which use JPA and Lombok for entity declaration and getter/setter generation.

package personal.clinic.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@Table(name = "doctor")
@NoArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private String doctorId;
	@Column(name = "doctor_empNum")
	private String leadId;
	@Column(name = "doctor_first_name")
	private String doctorFirstName;
	@Column(name = "doctor_last_name")
	private String doctorLastName;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "doctor")
	@JoinTable(name = "clinic_doctor")
	// each single doctor may rotate to different clinics and a clinic can have multiple doctors.
	private Set<Clinic> clinic = new HashSet<>();
	
	
	// each single doctor may have many nurse under their watch, but many nurses may have many doctors that they work under based on rotation.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@Column(name = "assigned_nurses")
	@ManyToMany(mappedBy = "overseeing")
	private Set<Nurse> overseeing = new HashSet<>();
	
	public Doctor(String doctorId, String leadId, String firstName, String lastName, Set<Clinic> clinic, Set<Nurse> overseeing) {
		this.doctorId= doctorId;
		this.leadId = leadId;
		this.doctorFirstName = firstName;
		this.doctorLastName = lastName;
		this.clinic = clinic;
		this.overseeing = overseeing;
	}


}
