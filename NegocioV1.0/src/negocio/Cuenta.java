package negocio;

import java.util.*;

public class Cuenta {
	
	private Cliente micliente;
	private Set<Factura>misFacturas = new HashSet<Factura>();
	private double limitePermitido;
	
	public Cuenta(Cliente miCliente, double miLimitePermitido) {
		
	}
	
}
