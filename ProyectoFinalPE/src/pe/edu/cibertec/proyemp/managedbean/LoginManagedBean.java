package pe.edu.cibertec.proyemp.managedbean;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Empleado;
import pe.edu.cibertec.proyemp.service.EmpleadoService;

@ManagedBean
@ViewScoped
public class LoginManagedBean {

	private Empleado empleado = new Empleado();
	
	private String usuario;
	
	private String clave;
	
	@ManagedProperty(value="#{empleadoService}")
	private EmpleadoService empleadoService;
	
	public String validarLogin(){
		
		empleado = empleadoService.getEmpleadoRepository().validarLogin(getUsuario(),getClave());
		
		if(empleado != null)
			return "principal";
		else
			return "login";
	}
	
	public String cerrarSesion(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "principal";
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}

	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
}
