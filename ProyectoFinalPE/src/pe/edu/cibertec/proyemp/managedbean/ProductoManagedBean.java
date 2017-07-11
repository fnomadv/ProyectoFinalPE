package pe.edu.cibertec.proyemp.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import com.google.common.collect.Lists;

import pe.edu.cibertec.proyemp.model.Cliente;
import pe.edu.cibertec.proyemp.model.Producto;
import pe.edu.cibertec.proyemp.service.ProductoService;

@ManagedBean
@SessionScoped
public class ProductoManagedBean {
	
	private Part auxImagen;

	private Producto producto = new Producto();
	
	private Cliente cliente = new Cliente();
	
	private List<Producto> productos = new ArrayList<Producto>();
	
	@ManagedProperty(value="#{productoService}")
	private ProductoService productoService;
	
	public String guardar() throws IOException{
//		auxImagen.write("D:\\Data\\"+getFilename(auxImagen));
//		auxImagen.write("\\WebContent\\resources\\img"+getFilename(auxImagen));
		return "";
	}
	
//	private static String getFilename(Part part){
//		for (String cd : part.getHeader("content-disposition").split(";")){
//			if(cd.trim().startsWith("filename")){
//				String filename = cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
//				return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
//			}
//		}
//		return null;
//	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProductos() {
		productos = Lists.newArrayList(productoService.getProductoRepository().findAll());
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public Part getAuxImagen() {
		return auxImagen;
	}

	public void setAuxImagen(Part auxImagen) {
		this.auxImagen = auxImagen;
	}

	public Cliente getCliente() {
		FacesContext context = FacesContext.getCurrentInstance();
		cliente = (Cliente) context.getExternalContext().getSessionMap().get("cliente");
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
