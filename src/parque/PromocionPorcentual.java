package parque;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	
	int porcentajePromo;
	
	public void setPrecioFinal() {
		int descuento = porcentajePromo * this.costo / 100;
		this.precioFinal = this.costo - descuento; 
	}
	
	public PromocionPorcentual(String nombre, List<Atraccion> atracciones, int porcentajePromo) {
		super(nombre, atracciones);
		this.porcentajePromo = porcentajePromo;
		this.setPrecioFinal();
	}

	@Override
	public String toString() {
		return "PromocionPorcentual [porcentajePromo=" + porcentajePromo + ", nombre=" + nombre + ", atracciones="
				+ atracciones + ", costo=" + costo + ", precioFinal=" + precioFinal + ", tipoPromocion=" + tipoPromocion
				+ ", tiempoTotal=" + tiempoTotal + "]";
	}


}
