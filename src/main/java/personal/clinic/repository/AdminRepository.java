package personal.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import personal.clinic.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
