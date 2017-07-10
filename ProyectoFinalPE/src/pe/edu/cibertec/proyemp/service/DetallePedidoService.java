package pe.edu.cibertec.proyemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.proyemp.repository.DetallePedidoRepository;

@Component
public class DetallePedidoService {

	@Autowired
	private DetallePedidoRepository detallePedidoRepository;

	public DetallePedidoRepository getDetallePedidoRepository() {
		return detallePedidoRepository;
	}

	public void setDetallePedidoRepository(DetallePedidoRepository detallePedidoRepository) {
		this.detallePedidoRepository = detallePedidoRepository;
	}
	
	
}
