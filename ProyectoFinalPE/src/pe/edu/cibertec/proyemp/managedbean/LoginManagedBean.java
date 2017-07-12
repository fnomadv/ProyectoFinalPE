package pe.edu.cibertec.proyemp.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Cliente;
import pe.edu.cibertec.proyemp.model.Empleado;
import pe.edu.cibertec.proyemp.service.ClienteService;
import pe.edu.cibertec.proyemp.service.EmpleadoService;

@ManagedBean
@ViewScoped
public class LoginManagedBean {

	private Empleado empleado = new Empleado();
	
	private Cliente cliente = new Cliente();
	
	private String usuario;
	
	private String clave;
	
	@ManagedProperty(value="#{empleadoService}")
	private EmpleadoService empleadoService;
	
	@ManagedProperty(value="#{clienteService}")
	private ClienteService clienteService;
	
	public String validarLogin(){
//		FacesMessage message = 
//				new FacesMessage("Logueado",
//						"El empleado se guardó de manera satisfactoria");
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		empleado = empleadoService.getEmpleadoRepository().validarLogin(getUsuario(),getClave());
		cliente = clienteService.getClienteRepository().validarLogin(getUsuario(),getClave());
		
		if(empleado == null ){
			if(cliente == null){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario y Clave incorrectos","Incorrecto"));
				return "login";
			}
			else{
				context.getExternalContext().getSessionMap().put("cliente", cliente);
				return "principal";
			}
		}else{
			context.getExternalContext().getSessionMap().put("empleado", empleado);
			//enviar a una pantalla de mantenimiento general
			return "mntEmpleado";
		}
	}
	
	public String cerrarSesion(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login";
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

}
