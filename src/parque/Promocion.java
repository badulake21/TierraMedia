package parque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Promocion {
	protected String nombre;
	protected List <Atraccion> atracciones = new ArrayList<Atraccion>();
	protected int costo;
	protected int precioFinal;
	protected String tipoPromocion;
	protected double tiempoTotal;
	
	
	public int getCosto() {
		return costo;
	}
	public void setCosto() {
		for(Atraccion atraccion: atracciones) {
			this.costo += atraccion.getPrecio();
		}
	}
	
	public Promocion(String nombre, List<Atraccion> atracciones) {
		this.nombre = nombre;
		this.atracciones = atracciones;
		this.setCosto();
		this.setTipoPromocion();
		this.setTiempoTotal();
	}
	
	protected void setTipoPromocion(){
		this.tipoPromocion = atracciones.get(0).getTipo();
	}
	
	
	public String getTipoPromocion() {
		return tipoPromocion;
	}

	public abstract void setPrecioFinal();
	
	public int getPrecioFinal() {
		return precioFinal;
	}
	public double getTiempoTotal() {
		return tiempoTotal;
	}
	
	public void setTiempoTotal() {
		for(Atraccion atraccion: atracciones) {
			this.tiempoTotal += atraccion.getTiempo();
		}
	}
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}	
	
	public boolean corroborarCupo() {
		for (Atraccion atracc : atracciones) {
			if(atracc.getCupo() == 0) {
				return false;
			}
		}
		return true;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String decirAtracciones() {
		String atraccionesString = "";
		for (Atraccion atracc : atracciones) {
			atraccionesString += atracc.getNombre() + ", ";
			}
		return atraccionesString;
	}
	@Override
	public int hashCode() {
		return Objects.hash(atracciones, costo, nombre, precioFinal, tiempoTotal, tipoPromocion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(atracciones, other.atracciones) && costo == other.costo
				&& Objects.equals(nombre, other.nombre) && precioFinal == other.precioFinal
				&& Double.doubleToLongBits(tiempoTotal) == Double.doubleToLongBits(other.tiempoTotal)
				&& Objects.equals(tipoPromocion, other.tipoPromocion);
	}
	
	
	
}
