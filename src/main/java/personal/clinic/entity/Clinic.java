
// the entity package contains entities which use JPA and Lombok for entity declaration and getter/setter/constructor generation.

// entities should also contain the domain-specific logic. So, if i want to find total count of nurses, I need a method totalNumNurses(nurses) to retrieve the count of nurses
// see https://www.baeldung.com/java-entity-vs-dto

// entities can also contain validation constraints or lifecycle methods

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Embeddable
@Entity
@Data
@Table(name="clinic")
@NoArgsConstructor
public class Clinic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clinic_id")
	private Integer clinicId;
	@Column(name = "clinic_name")
	private String clinicName;
	@Column(name = "clinic_address")
	private String clinicStreetAddress;
	@Column(name = "clinic_state")
	private String clinicState;
	@Column(name = "clinic_zip")
	private String clinicZip;

	// each single clinic can have many nurse.
	// the ORM recognizes this will be referencing a Nurse object.
	// each single clinic can have many doctors, but multiple doctors can have multiple clinics..
	
	// mappedBy : JPA annotation used to define entity ownership between two entities. 
	// mappedBy is used on the inverse side of the relationship to indicate that the mapping information is owned by 
	// the other entity.
	
	// represents the inverse of relationship with Nurse. 'mappedBy = "clinic"' indicates the owning side of the
	// relationship is the "clinicId" field in Nurse.
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "clinic", cascade = CascadeType.PERSIST)
	// @JoinTable not needed for OneToMany
	private Set<Nurse> nurses = new HashSet<>();
	
	
	// each Clinic can have multiple doctors and each doctor can have multiple clinics.
	@Column(name = "operating_doctors")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "clinic")
	@JoinTable(name = "clinic_doctor" , joinColumns = @JoinColumn(
			name="clinic_id"), inverseJoinColumns = @JoinColumn(
					name = "doctor_id"))
	// inverseJoinColumns = @JoinColumn(referencedColumnName = "doctorId"))
	private Set<Doctor> doctors = new HashSet<>();
	
	
	// each single clinic can have many administrative employees.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
	@JoinTable(name = "clinic_admin",joinColumns = @JoinColumn(
			name = "clinic_id"), inverseJoinColumns = @JoinColumn(
			name = "admin_id"))
	private Set<Admin> administrativeEmployees = new HashSet<>();
	
	

}
