// the entity package contains entities which use JPA and Lombok for entity declaration and getter/setter generation.

package personal.clinic.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import personal.clinic.model.DoctorDTO;
@Entity
@Data
@Embeddable
@Table(name = "doctor")
@NoArgsConstructor
public class Doctor {
	
	public Doctor(DoctorDTO dDTO) {
		this.doctorId = dDTO.getDoctorId();
		this.clinic = dDTO.getClinicId();
		this.doctorFirstName = dDTO.getDoctorFirstName();
		this.doctorLastName = dDTO.getDoctorLastName();
		this.overseeing = dDTO.getOverseeing();
		this.leadId = dDTO.getLeadId();
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private Integer doctorId;
	@Column(name = "doctor_empNum")
	private String leadId;
	@Column(name = "doctor_first_name")
	private String doctorFirstName;
	@Column(name = "doctor_last_name")
	private String doctorLastName;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
//	@Column(name = "operating_doctors")
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "clinic_doctor" , 
			joinColumns = @JoinColumn(name = "doctor_id"),
			inverseJoinColumns = @JoinColumn(name = "clinic_id"))
	
	// each single doctor may rotate to different clinics and a clinic can have multiple doctors.
	private Set<Clinic> clinic = new HashSet<>();
	
	
	// each single doctor may have many nurse under their watch, but many nurses may have many doctors that they work under based on rotation.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
//	@Column(name = "assigned_nurses")
	
	@ManyToMany(mappedBy = "overseeing")
	private Set<Nurse> overseeing = new HashSet<>();
	
//	public Doctor(String doctorId, String leadId, String firstName, String lastName, Set<Clinic> clinic, Set<Nurse> overseeing) {
//		this.doctorId= doctorId;
//		this.leadId = leadId;
//		this.doctorFirstName = firstName;
//		this.doctorLastName = lastName;
//		this.clinic = clinic;
//		this.overseeing = overseeing;
//	}


}
