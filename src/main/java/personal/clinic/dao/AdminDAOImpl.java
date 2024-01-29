package personal.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import personal.clinic.entity.Admin;
import personal.clinic.mapper.AdminMapper;
import personal.clinic.model.AdminDTO;

@Component
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private EntityManager entityManager;
	
	public AdminDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Admin a) {
		entityManager.persist(a);
		
	}

	@Override
	public AdminDTO read(Integer adminId) {
		Admin a = entityManager.find(Admin.class, adminId);
		return AdminMapper.MAPPER.adminToAdminDTO(a);
	}

	@Override
	public void update(Admin a) {
		entityManager.persist(a);		
	}

	@Override
	public void delete(Integer adminId) {
		Admin a = entityManager.find(Admin.class, adminId);
		entityManager.remove(a);
		
	}
	
	
	

}
