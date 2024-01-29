package personal.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import personal.clinic.entity.Doctor;
import personal.clinic.mapper.DoctorMapper;
import personal.clinic.model.DoctorDTO;

@Component
public class DoctorDAOImpl implements DoctorDAO{

	@Autowired
	private final EntityManager entityManager;
	
	public DoctorDAOImpl(EntityManager em) {
		this.entityManager = em;
	}
	
	@Override
	public void create(Doctor d) {
		entityManager.persist(d);
		
	}

	@Override
	public DoctorDTO read(Integer doctorId) {
		Doctor d = entityManager.find(Doctor.class, doctorId);
		
		return DoctorMapper.MAPPER.doctorToDoctorDTO(d);
	}

	@Override
	public void update(Doctor d) {
		entityManager.persist(d);
	}

	@Override
	public void delete(Integer doctorId) {
		Doctor d = entityManager.find(Doctor.class, doctorId);
		entityManager.remove(d);
		
	}

}
