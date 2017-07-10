package pe.edu.cibertec.proyemp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_pedido")
public class Pedido {

	@Id
	@GeneratedValue
	private Long id;
	private String nroPedido;
	private String estado;//pendiende o cancelado
	@ManyToOne
	private Cliente cliente = new Cliente();
	
	@Temporal(TemporalType.DATE)
	private Date fechaPedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(String nroPedido) {
		this.nroPedido = nroPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	
}
