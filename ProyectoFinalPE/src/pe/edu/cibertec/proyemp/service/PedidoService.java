package pe.edu.cibertec.proyemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.proyemp.repository.PedidoRepository;

@Component
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public PedidoRepository getPedidoRepository() {
		return pedidoRepository;
	}

	public void setPedidoRepository(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	
}
