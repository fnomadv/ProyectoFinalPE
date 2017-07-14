package validaciones;

import static org.junit.Assert.*;

import org.junit.Test;

import pe.edu.cibertec.proyemp.model.Producto;

public class ValidarISBN {

	Producto p = new Producto();
	
	@Test
	public void isbnnulo() {
		p.setIsbn(null);
		boolean resultado = p.validarIsbn(p.getIsbn());
		assertFalse(resultado);
	}
	
	@Test
	public void isbnvacio() {
		p.setIsbn("");
		boolean resultado = p.validarIsbn(p.getIsbn());
		assertFalse(resultado);
	}

	@Test
	public void isbnconletras() {
		p.setIsbn("1234asd891023");
		boolean resultado = p.validarIsbn(p.getIsbn());
		assertFalse(resultado);
	}
	
	@Test
	public void isbnincompleto() {
		p.setIsbn("321654987");
		boolean resultado = p.validarIsbn(p.getIsbn());
		assertFalse(resultado);
	}
	
	@Test
	public void isbncorrecto() {
		p.setIsbn("1234567890123");
		boolean resultado = p.validarIsbn(p.getIsbn());
		assertTrue(resultado);
	}
}
