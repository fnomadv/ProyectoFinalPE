package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import pe.edu.cibertec.proyemp.model.Cargo;
import pe.edu.cibertec.proyemp.model.Rol;
import pe.edu.cibertec.proyemp.service.CargoService;


@ManagedBean
@SessionScoped
public class CargoManagedBean {

	private Cargo cargo = new Cargo();
	
	private List<Cargo> cargos = new ArrayList<Cargo>();
	
	@ManagedProperty(value="#{cargoService}")
	private CargoService cargoService;
	
	public String guardar (){
		cargoService.getCargoRepository().save(cargo);
		cargo = new Cargo();
		return "mntCargo";
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		cargos = Lists.newArrayList(cargoService.getCargoRepository().findAll());
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	
}
