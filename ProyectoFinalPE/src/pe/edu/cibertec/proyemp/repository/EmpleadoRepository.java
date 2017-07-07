package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{

	@Query("select e from Empleado e where e.usuario like :usu and e.clave like :cla")
	Empleado validarLogin(@Param("usu") String usuario,@Param("cla") String clave
			);
}
