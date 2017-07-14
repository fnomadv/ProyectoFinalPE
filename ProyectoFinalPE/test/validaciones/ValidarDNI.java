package validaciones;

import static org.junit.Assert.*;

import org.junit.Test;

import pe.edu.cibertec.proyemp.model.Cliente;

public class ValidarDNI {
	Cliente c = new Cliente();
	
	@Test
	public void dniVacio() {
		c.setDni("");
		boolean resultado = c.validarDni(c.getDni());
		assertFalse(resultado);
	}
	
	@Test
	public void dniLetras(){
		c.setDni("4821a87s");
		boolean resultado = c.validarDni(c.getDni());
		assertFalse(resultado);
	}
	
	@Test
	public void dninulo(){
		c.setDni(null);
		boolean resultado = c.validarDni(c.getDni());
		assertFalse(resultado);
	}
	
	@Test
	public void dniCorrecto(){
		c.setDni("48213876");
		boolean resultado = c.validarDni(c.getDni());
		assertTrue(resultado);
	}

}
