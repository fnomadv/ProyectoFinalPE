package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.common.collect.Lists;

import pe.edu.cibertec.proyemp.model.Cargo;
import pe.edu.cibertec.proyemp.model.Departamento;
import pe.edu.cibertec.proyemp.model.Empleado;
import pe.edu.cibertec.proyemp.service.CargoService;
import pe.edu.cibertec.proyemp.service.DepartamentoService;
import pe.edu.cibertec.proyemp.service.EmpleadoService;

@ManagedBean
@SessionScoped
public class EmpleadoManagedBean {

	private Empleado empleado = new Empleado();
	
	private Departamento departamento = new Departamento();
	
	private Cargo cargo = new Cargo();
	
	private List<Empleado> empleados = new ArrayList<Empleado>();
	
	private List<Departamento> departamentos = new ArrayList<Departamento>();
	
	private List<Cargo> cargos = new ArrayList<Cargo>();
	
	@ManagedProperty(value="#{empleadoService}")
	private EmpleadoService empleadoService;
	
	@ManagedProperty(value="#{departamentoService}")
	private DepartamentoService departamentoService;
	
	@ManagedProperty(value="#{cargoService}")
	private CargoService cargoService;
	
	public String guardar (){
		for (Empleado e : getEmpleados()) {
			String dni = empleado.getDni().replace(" ", "");
			if(e.getDni().equalsIgnoreCase(dni)){
				System.out.println("ya existe este dni");
				return "mntEmpleado";
			}
		}
		empleado.setUsuario(empleado.getDni());
		int passAleatorio = (int) (Math.random() * 99999 + 10000);
		empleado.setClave(Integer.toString(passAleatorio));
		empleado.setEstado("Activo");
		empleadoService.getEmpleadoRepository().save(empleado);
		
		empleado = new Empleado();
		return "mntEmpleado";
	}
	
	public String actualizarDatos(){
		empleadoService.getEmpleadoRepository().save(empleado);
		empleado = new Empleado();
		return "mntEmpleado";
	}
	
	public String limpiar(){
		empleado = new Empleado();
		return "mntEmpleado";
	}
	
	public String editarEstado(){
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();

		Long id = Long.parseLong(params.get("parempid"));
		
		empleado = empleadoService.getEmpleadoRepository().findOne(new Long(id));
		
		if(empleado.getEstado().equalsIgnoreCase("Activo"))
			empleado.setEstado("Inactivo");
		else
			empleado.setEstado("Activo");
		
		
		empleadoService.getEmpleadoRepository().save(empleado);
		empleado = new Empleado();
		return "mntEmpleado";
	}
	
	public String actualizar(){
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();

		Long id = Long.parseLong(params.get("parempid"));
		
		empleado = empleadoService.getEmpleadoRepository().findOne(new Long(id));
		return "mntEmpleado";
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getEmpleados() {
		empleados = Lists.newArrayList(empleadoService.getEmpleadoRepository().findAll());
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Departamento> getDepartamentos() {
		departamentos = Lists.newArrayList(departamentoService.getDepartamentoRepository().findAll());
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public List<Cargo> getCargos() {
		cargos = Lists.newArrayList(cargoService.getCargoRepository().findAll());
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}

	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

	public DepartamentoService getDepartamentoService() {
		return departamentoService;
	}

	public void setDepartamentoService(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	
}
