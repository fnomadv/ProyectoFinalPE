package pe.edu.cibertec.proyemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.proyemp.repository.RolRepository;

@Component
public class RolService {

	@Autowired
	private RolRepository rolRepository;

	public RolRepository getRolRepository() {
		return rolRepository;
	}

	public void setRolRepository(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}


}
