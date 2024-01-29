package personal.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import personal.clinic.entity.Nurse;
import personal.clinic.mapper.NurseMapper;
import personal.clinic.model.NurseDTO;

@Component
public class NurseDAOImpl implements NurseDAO {
	
	@Autowired
	private final EntityManager entityManager;
	
	
	@Autowired
	public NurseDAOImpl(EntityManager em) {
		this.entityManager = em;
	}
	
	
	
	
	@Override
	public void create(Nurse n) {
		entityManager.persist(n);
	}

	@Override
	public NurseDTO read(Integer nurseId) {
		Nurse n = entityManager.find(Nurse.class, nurseId);
		return NurseMapper.MAPPER.nurseToNurseDTO(n);
	}

	@Override
	public void update(Nurse n) {
		entityManager.persist(n);
		
	}

	@Override
	public void delete(Integer nurseId) {
		Nurse n = entityManager.find(Nurse.class, nurseId);
		entityManager.remove(n);
		
	}
	


}
