package pe.edu.cibertec.proyemp.managedbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.common.collect.Lists;

import pe.edu.cibertec.proyemp.model.Cliente;
import pe.edu.cibertec.proyemp.model.DetallePedido;
import pe.edu.cibertec.proyemp.model.Pedido;
import pe.edu.cibertec.proyemp.model.Producto;
import pe.edu.cibertec.proyemp.service.DetallePedidoService;
import pe.edu.cibertec.proyemp.service.PedidoService;
import pe.edu.cibertec.proyemp.service.ProductoService;

@ManagedBean
@SessionScoped
public class CarritoManagedBean {

	private Cliente cliente = new Cliente();

	private Producto productoSeleccionado = new Producto();

	private Pedido pedido = new Pedido();

	private DetallePedido detallePedido = new DetallePedido();

	private List<DetallePedido> listaProductosCarrito;

	private List<Pedido> pedidos = new ArrayList<Pedido>();

	private int cantidad;

	private double totalCompra;// monto total del carrito de compra

	private double st;

	@ManagedProperty(value = "#{productoService}")
	private ProductoService productoService;

	@ManagedProperty(value = "#{pedidoService}")
	private PedidoService pedidoService;

	@ManagedProperty(value = "#{detallePedidoService}")
	private DetallePedidoService detallePedidoService;

	/**
	 * Metodo que obtiene el producto y la cantidad a pedir y se agregará al
	 * carrito.
	 * 
	 * @return
	 * @throws ParseException
	 */
	public String agregarCarrito() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();

		Long id = Long.parseLong(params.get("parprodid"));
		productoSeleccionado = productoService.getProductoRepository().findOne(new Long(id));
		cliente = (Cliente) context.getExternalContext().getSessionMap().get("cliente");
		//listaProductosCarrito = 
		if (cantidad != 0) {
			//buscar si cliente tiene pedido pendiente
			pedido = pedidoService.getPedidoRepository().obtenerPedidoPorEstado(cliente.getId(), "Pendiente");
			//System.out.println("Pedido pendiente es "+pedido.getId()+" / "+pedido.getNroPedido());
			if(pedido != null){
				System.out.println("if de pedido != null");
				//buscamos si tiene un carrito pendiente
				listaProductosCarrito = detallePedidoService.getDetallePedidoRepository().listadoPendientes(pedido.getId());
				if(listaProductosCarrito == null){
//					System.out.println("if de listaProductosCarrito != null");
//					//agregamos el nuevo detalle al pedido
//					//crear el datelle del pedido
					detallePedido.setPedido(pedido);
					detallePedido.setProducto(productoSeleccionado);
					detallePedido.setCantidad(cantidad);
					st = detallePedido.getProducto().getPrecio() * cantidad;
					detallePedido.setSubtotal(st);
					
					totalCompra += detallePedido.getSubtotal();
					detallePedidoService.getDetallePedidoRepository().save(detallePedido);
					listaProductosCarrito = detallePedidoService.getDetallePedidoRepository().listadoPendientes(pedido.getId());
					detallePedido = new DetallePedido();
					return "carrito_compra";
				}else{
					System.out.println("else de listaProductosCarrito != null");
					// si exista un carrito
					// comprobar que si el producto seleccionado ya se encuentra en el carrito
					listaProductosCarrito = detallePedidoService.getDetallePedidoRepository().listadoPendientes(pedido.getId());
					//for para tener la totalidad de la compra
					for (DetallePedido lp : listaProductosCarrito) {
						totalCompra += lp.getSubtotal();
					}
					for (DetallePedido lp : listaProductosCarrito) {
						System.out.println("dentro del for");
						System.out.println(lp.getProducto().getId());
						System.out.println(productoSeleccionado.getId());
						if (lp.getProducto().getId() == productoSeleccionado.getId()) {
							System.out.println("modificando el producto que estaba en el carrito");
							lp.setCantidad(cantidad + lp.getCantidad());
							st = productoSeleccionado.getPrecio() * lp.getCantidad();
							lp.setSubtotal(st);
							totalCompra += lp.getSubtotal();
							detallePedidoService.getDetallePedidoRepository().save(lp);
							listaProductosCarrito = detallePedidoService.getDetallePedidoRepository().listadoPendientes(pedido.getId());
							detallePedido = new DetallePedido();
							return "carrito_compra";
						}
					}
					detallePedido.setPedido(pedido);
					detallePedido.setProducto(productoSeleccionado);
					detallePedido.setCantidad(cantidad);
					st = detallePedido.getProducto().getPrecio() * cantidad;
					detallePedido.setSubtotal(st);
					
					totalCompra += detallePedido.getSubtotal();
					detallePedidoService.getDetallePedidoRepository().save(detallePedido);
					listaProductosCarrito = detallePedidoService.getDetallePedidoRepository().listadoPendientes(pedido.getId());
					detallePedido = new DetallePedido();
					return "carrito_compra";
				}
			}
			else{
				//Si el cliente no presenta ningun pedido pendiente creamos un nuevo pedido
				Date fecha = new Date();
				// guardamos pedidos y detallePedido
				pedido.setCliente(cliente);
				int cont = (int) pedidoService.getPedidoRepository().count() + 1;
				pedido.setNroPedido("P000" + cont);
				pedido.setEstado("Pendiente");
				pedido.setFechaPedido(fecha);
				pedidoService.getPedidoRepository().save(pedido);
				
				//crear el datelle del pedido
				detallePedido.setPedido(pedido);
				detallePedido.setProducto(productoSeleccionado);
				detallePedido.setCantidad(cantidad);
				st = detallePedido.getProducto().getPrecio() * cantidad;
				detallePedido.setSubtotal(st);
				
				totalCompra += detallePedido.getSubtotal();
				
				detallePedidoService.getDetallePedidoRepository().save(detallePedido);
			}

			listaProductosCarrito = detallePedidoService.getDetallePedidoRepository().listadoPendientes(pedido.getId());
			detallePedido = new DetallePedido();
			return "carrito_compra";
		}
		else {
			System.out.println("Cantidad no puede ser 0");
			return "";
		}
	}

	/**
	 * Metodo que retorna el producto seleccionado a una pagina producto
	 * detalle, en esta pagina se introducira la cantidad a comprar
	 * 
	 * @return
	 */
	public String productSelect() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();

		Long id = Long.parseLong(params.get("parprodid"));
		// obtenemos el producto seleccionado
		productoSeleccionado = productoService.getProductoRepository().findOne(new Long(id));

		return "producto_detalle";
	}

	public String irPrincipal() {
		return "principal";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public DetallePedido getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(DetallePedido detallePedido) {
		this.detallePedido = detallePedido;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public List<Pedido> getPedidos() {
		pedidos = Lists.newArrayList(pedidoService.getPedidoRepository().findAll());
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public PedidoService getPedidoService() {
		return pedidoService;
	}

	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	public DetallePedidoService getDetallePedidoService() {
		return detallePedidoService;
	}

	public void setDetallePedidoService(DetallePedidoService detallePedidoService) {
		this.detallePedidoService = detallePedidoService;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public double getSt() {
		return st;
	}

	public void setSt(double st) {
		this.st = st;
	}

	public List<DetallePedido> getListaProductosCarrito() {
		return listaProductosCarrito;
	}

	public void setListaProductosCarrito(List<DetallePedido> listaProductosCarrito) {
		this.listaProductosCarrito = listaProductosCarrito;
	}

}
