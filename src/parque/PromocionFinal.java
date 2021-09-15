package parque;

import java.util.List;

public class PromocionFinal extends Promocion {

	@Override
	public void setPrecioFinal() {
		this.precioFinal = precioFinal;
	}

	public PromocionFinal(String nombre, List<Atraccion> atracciones, int precioFinal) {
		super(nombre, atracciones);
		this.precioFinal = precioFinal;
	}

	@Override
	public String toString() {
		return "PromocionFinal [nombre=" + nombre + ", atracciones=" + atracciones + ", costo=" + costo
				+ ", precioFinal=" + precioFinal + ", tipoPromocion=" + tipoPromocion + ", tiempoTotal=" + tiempoTotal
				+ "]";
	}

	




}
