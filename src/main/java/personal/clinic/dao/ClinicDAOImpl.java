package personal.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import personal.clinic.entity.Clinic;
import personal.clinic.mapper.ClinicMapper;
import personal.clinic.model.ClinicDTO;
@Component
public class ClinicDAOImpl implements ClinicDAO{
	@Autowired
	private final EntityManager entityManager;
	
	public ClinicDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	@Override
	public void create(Clinic c) {

		entityManager.persist(c);
	
	}

	@Override
	public ClinicDTO read(Integer clinicId) {
		Clinic c = entityManager.find(Clinic.class, clinicId);
		return ClinicMapper.MAPPER.clinicToClinicDTO(c);
	
	}


	@Override
	public void update(Clinic c) {
		entityManager.persist(c);
		
	}

	@Override
	public void delete(Integer clinicId) {
		Clinic c = entityManager.find(Clinic.class, clinicId);
		entityManager.remove(c);
	}

}
