package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{

	@Query("select e from Pedido e where e.cliente.id = :idcli and e.estado like :est ")
	Pedido obtenerPedidoPorEstado(@Param("idcli") Long idCliente,@Param("est") String estado
			);
	
}
