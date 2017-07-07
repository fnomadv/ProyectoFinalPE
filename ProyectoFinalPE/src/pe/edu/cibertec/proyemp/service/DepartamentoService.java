package pe.edu.cibertec.proyemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.proyemp.repository.DepartamentoRepository;

@Component
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	public DepartamentoRepository getDepartamentoRepository() {
		return departamentoRepository;
	}

	public void setDepartamentoRepository(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	
}
