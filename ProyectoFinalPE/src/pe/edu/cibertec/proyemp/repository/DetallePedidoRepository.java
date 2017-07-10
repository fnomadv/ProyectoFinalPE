package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.DetallePedido;

@Repository
public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Long>{

	@Query("select d from DetallePedido d where d.pedido.id = :nro ")
	List<DetallePedido> listadoPendientes(@Param("nro") long nro
			);
	
}
