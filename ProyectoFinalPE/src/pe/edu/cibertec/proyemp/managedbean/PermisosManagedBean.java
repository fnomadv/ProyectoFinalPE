package pe.edu.cibertec.proyemp.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Cliente;
import pe.edu.cibertec.proyemp.model.Empleado;

@ManagedBean
@ViewScoped
public class PermisosManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7527268209408785432L;

	public void verificarSesionEmp() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Empleado e = (Empleado) context.getExternalContext().getSessionMap().get("empleado");
			if (e == null) {
				context.getExternalContext().redirect("permisos.xhtml");
			}else if(e.getEstado().equalsIgnoreCase("Inactivo")){
				context.getExternalContext().redirect("permisos.xhtml");
			}
		} catch (Exception e) {
			// log para guardar regsitros de errores
		}
	}

	public void verificarSesionCli() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Cliente c = (Cliente)context.getExternalContext().getSessionMap().get("cliente");
			if (c == null) {
				context.getExternalContext().redirect("permisos.xhtml");
			}else if(c.getEstado().equalsIgnoreCase("Inactivo")){
				context.getExternalContext().redirect("permisos.xhtml");
			}

		} catch (Exception e) {
			// log para guardar regsitros de errores
		}
	}

}
