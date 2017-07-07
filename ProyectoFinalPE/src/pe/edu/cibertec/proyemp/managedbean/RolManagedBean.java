package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import pe.edu.cibertec.proyemp.model.Rol;
import pe.edu.cibertec.proyemp.service.RolService;

@ManagedBean
@SessionScoped
public class RolManagedBean {

	private Rol rol = new Rol();
	
	private List<Rol> roles = new ArrayList<Rol>();
	
	@ManagedProperty(value="#{rolService}")
	private RolService rolService;

	public String guardar (){
		rolService.getRolRepository().save(rol);
		rol = new Rol();
		return "mntRol";
	}
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getRoles() {
		roles = Lists.newArrayList(rolService.getRolRepository().findAll());
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}


}
