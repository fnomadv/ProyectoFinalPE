package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.common.collect.Lists;

import pe.edu.cibertec.proyemp.model.Cliente;
import pe.edu.cibertec.proyemp.model.Rol;
import pe.edu.cibertec.proyemp.service.ClienteService;
import pe.edu.cibertec.proyemp.service.RolService;

@ManagedBean
@SessionScoped
public class ClienteManagedBean {

	private Cliente cliente = new Cliente();
	
	private Rol rol = new Rol();
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	private List<Rol> roles = new ArrayList<Rol>();
	
	@ManagedProperty(value="#{clienteService}")
	private ClienteService clienteService;
	
	@ManagedProperty(value="#{rolService}")
	private RolService rolService;

	public String guardar (){
		for (Cliente c : getClientes()) {
			String dni = cliente.getDni().replace(" ", "");
			if(c.getDni().equalsIgnoreCase(dni)){
				System.out.println("ya existe este dni");
				return "mntCliente";
			}
		}
		
		cliente.setUsuario(cliente.getDni());
		int passAleatorio = (int) (Math.random() * 99999 + 10000);
		cliente.setClave(Integer.toString(passAleatorio));
		cliente.setEstado("Activo");
		clienteService.getClienteRepository().save(cliente);
		
		cliente = new Cliente();
		return "mntCliente";
	}
	
	public String editarEstado(){
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();

		Long id = Long.parseLong(params.get("parempid"));
		
		cliente = clienteService.getClienteRepository().findOne(new Long(id));
		
		if(cliente.getEstado().equalsIgnoreCase("Activo"))
			cliente.setEstado("Inactivo");
		else
			cliente.setEstado("Activo");
		
		
		clienteService.getClienteRepository().save(cliente);
		cliente = new Cliente();
		return "mntCliente";
	}
	
	public String actualizar(){
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();

		Long id = Long.parseLong(params.get("parempid"));
		
		cliente = clienteService.getClienteRepository().findOne(new Long(id));
		return "mntCliente";
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Cliente> getClientes() {
		clientes = Lists.newArrayList(clienteService.getClienteRepository().findAll());
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Rol> getRoles() {
		roles = Lists.newArrayList(rolService.getRolRepository().findAll());
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}
	
	
}
