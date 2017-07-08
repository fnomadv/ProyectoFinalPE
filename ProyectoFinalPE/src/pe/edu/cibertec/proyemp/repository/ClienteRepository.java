package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	@Query("select c from Cliente c where c.usuario like :usu and c.clave like :cla")
	Cliente validarLogin(@Param("usu") String usuario,@Param("cla") String clave
			);
	
}
