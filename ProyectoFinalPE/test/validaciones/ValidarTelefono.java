package validaciones;

import static org.junit.Assert.*;

import org.junit.Test;

import pe.edu.cibertec.proyemp.model.Cliente;

public class ValidarTelefono {

	Cliente c = new Cliente();
	
	@Test
	public void telnulo() {
		c.setTelefono(null);
		boolean resultado = c.validarTelefono(c.getTelefono());
		assertFalse(resultado);
	}
	
	@Test
	public void telvacio() {
		c.setTelefono("");
		boolean resultado = c.validarTelefono(c.getTelefono());
		assertFalse(resultado);
	}
	
	@Test
	public void teltamanio6() {
		c.setTelefono("123456");
		boolean resultado = c.validarTelefono(c.getTelefono());
		assertFalse(resultado);
	}
	
	@Test
	public void teltamanio8() {
		c.setTelefono("12345678");
		boolean resultado = c.validarTelefono(c.getTelefono());
		assertFalse(resultado);
	}
	
	@Test
	public void teltamanio7() {
		c.setTelefono("1234567");
		boolean resultado = c.validarTelefono(c.getTelefono());
		assertTrue(resultado);
	}
	
	@Test
	public void teltamanio9() {
		c.setTelefono("123456789");
		boolean resultado = c.validarTelefono(c.getTelefono());
		assertTrue(resultado);
	}

}
