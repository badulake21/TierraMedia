package parque;

import java.util.List;

public class Promocion3x2 extends Promocion {
	
	
	public void setPrecioFinal() {
		this.precioFinal = atracciones.get(0).getPrecio() + atracciones.get(1).getPrecio();
	}
	
	public Promocion3x2(String nombre, List<Atraccion> atracciones) {
		super(nombre, atracciones);
		this.setPrecioFinal();
	}

	@Override
	public String toString() {
		return "Promocion3x2 [nombre=" + nombre + ", atracciones=" + atracciones + ", costo=" + costo + ", precioFinal="
				+ precioFinal + ", tipoPromocion=" + tipoPromocion + ", tiempoTotal=" + tiempoTotal + "]";
	}
	
	
	
}
