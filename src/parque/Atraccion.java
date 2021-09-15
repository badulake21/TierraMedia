package parque;

import java.util.Objects;

public class Atraccion{

	private String nombre;
	private int precio;
	private double tiempo;
	private int cupo;
	private String tipo;
	
	public Atraccion(){
		
	}
	
	public Atraccion(String nombre, int precio, double tiempo, int cupo, String tipo) {
		this.nombre = nombre;
		this.precio = precio;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", precio=" + precio + ", tiempo=" + tiempo + ", cupo=" + cupo + ", tipo="
				+ tipo + "]";
	}
	

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cupo, nombre, precio, tiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return cupo == other.cupo && Objects.equals(nombre, other.nombre) && precio == other.precio
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& Objects.equals(tipo, other.tipo);
	}
	
	
	
}
