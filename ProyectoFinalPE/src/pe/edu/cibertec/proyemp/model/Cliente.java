package pe.edu.cibertec.proyemp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	private String nombres;
	private String apellidos;
	private String dni;
	private String telefono;
	private String usuario;
	private String clave;
	private String estado;

	@ManyToOne
	private Rol rol = new Rol();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public boolean validarTelefono(String telefono) {

		if (telefono == null)
			return false;
		else {
			if (telefono.isEmpty())
				return false;
			else {
				if (telefono.length() != 7)
					if (telefono.length() != 9)
						return false;
					else {
						for (int i = 0; i <= telefono.length()-1; i++) {
							char letra = telefono.charAt(i);
							if (!Character.isDigit(letra))
								return false;
						}
					}
				else {
					for (int i = 0; i <= telefono.length()-1; i++) {
						char letra = telefono.charAt(i);
						if (!Character.isDigit(letra))
							return false;
					}
				}
			}
		}

		return true;
	}

	public boolean validarDni(String dni) {

		if (dni == null)
			return false;
		else {
			if (dni.isEmpty())
				return false;
			else {
				if (dni.length() != 8)
					return false;
				else {
					for (int i = 0; i <= dni.length()-1; i++) {
						char letra = dni.charAt(i);
						if (!Character.isDigit(letra))
							return false;
					}
				}
			}

		}

		return true;
	}

}
