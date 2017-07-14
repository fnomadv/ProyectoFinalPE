package pe.edu.cibertec.proyemp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * En esta clase se registrara los atributos de un libro. Producto que la
 * empresa vendera.
 * 
 * @author FERNANDO
 *
 */

@Entity
@Table(name = "tb_producto")
public class Producto {

	@Id
	@GeneratedValue
	private Long id;
	private String isbn;
	private String titulo;
	private String imagen;
	private String descripcion;
	private double precio;
	private int stock;

 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public boolean validarIsbn(String isbn){
		if(isbn == null)
			return false;
		
		if(isbn.length() != 13)
			return false;
		
		for (int i = 0; i <= isbn.length()-1; i++) {
			char letra = isbn.charAt(i);
			if (!Character.isDigit(letra))
				return false;
		}
		
		return true;
	}

}
