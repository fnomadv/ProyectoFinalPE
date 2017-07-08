package pe.edu.cibertec.proyemp.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Cliente;
import pe.edu.cibertec.proyemp.model.Empleado;

@ManagedBean
@ViewScoped
public class PermisosManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1077198688915842588L;

	public void verificarSesion(){
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			
			Empleado e = (Empleado) context.getExternalContext().getSessionMap().get("empleado");
			Cliente c = (Cliente) context.getExternalContext().getSessionMap().get("cliente");
			if (e == null){
				if(c == null){
					context.getExternalContext().redirect("permisos.xhtml");
				}
			}
		}catch(Exception e){
			//log para guardar regsitros de errores
		}
	}
}
