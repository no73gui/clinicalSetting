package personal.clinic.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	@Bean
	public DoctorMapper doctorMapper() {
		return new DoctorMapperImpl();
	}
	
	@Bean
	public NurseMapper nurseMapper() {
		return new NurseMapperImpl();
	}
	
	@Bean
	public AdminMapper adminMapper() {
		return new AdminMapperImpl();
	}
	
	@Bean
	public ClinicMapper clinicMapper() {
		return new ClinicMapperImpl();
	}
}
