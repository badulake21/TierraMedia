package parque;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private String preferencia;
	private int presupuestoUsado;
	private double tiempoUsado;
	private List <Promocion> itinerarioPromociones = new ArrayList<Promocion>();
	private List <Atraccion> itinerarioAtracciones = new ArrayList<Atraccion>();
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible, String preferencia) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", preferencia=" + preferencia + ", presupuestoUsado=" + presupuestoUsado + ", tiempoUsado="
				+ tiempoUsado + ", itinerarioPromociones=" + itinerarioPromociones + ", itinerarioAtracciones="
				+ itinerarioAtracciones + "]";
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}
	
	public void agregarPromocionAItinerario(Promocion promo) {
		itinerarioPromociones.add(promo);
	}
	
	public void agregarAtraccionAItinerario(Atraccion atracc) {
		itinerarioAtracciones.add(atracc);
	}

	public List<Promocion> getItinerarioPromociones() {
		return itinerarioPromociones;
	}

	public List<Atraccion> getItinerarioAtracciones() {
		return itinerarioAtracciones;
	}
	
	public void decirItinerario() {
		System.out.println("Gracias por utilizar nuestro servicio " + getNombre() + ".");
		if(getItinerarioAtracciones().isEmpty() && getItinerarioPromociones().isEmpty()) {
			System.out.println("No ha seleccionado ninguna actividad para el día de hoy. ¡Vuelva pronto!");
		}else if(!getItinerarioAtracciones().isEmpty() && getItinerarioPromociones().isEmpty()) {
			decirItinerarioAtracciones();
			System.out.println("El itinerario le llevará " + tiempoUsado + "hs y su valor total es de $" + presupuestoUsado + "." );
		}else if(getItinerarioAtracciones().isEmpty() && !getItinerarioPromociones().isEmpty()) {
			decirItinerarioPromociones();
			System.out.println("El itinerario le llevará " + tiempoUsado + "hs y su valor total es de $" + presupuestoUsado + "." );
		}else {
			decirItinerarioPromociones();
			decirItinerarioAtracciones();
			System.out.println("El itinerario le llevará " + tiempoUsado + "hs y su valor total es de $" + presupuestoUsado + "." );
		}
	}
	
	private void decirItinerarioPromociones() {
		System.out.println("Las promociones elegidas fueron: ");
		for(Promocion promo : itinerarioPromociones) {
			System.out.println("La promocion " + promo.getNombre() + " que contiene las atracciones:" );
			for(Atraccion atracc : promo.atracciones) {
				System.out.println(atracc.getNombre());
			}
		}
		
	}
	
	public void escribirItinerario(PrintWriter salida) {
		if(getItinerarioAtracciones().isEmpty() && getItinerarioPromociones().isEmpty()) {
			salida.println("Sin elecciones");
		}else if(!getItinerarioAtracciones().isEmpty() && getItinerarioPromociones().isEmpty()) {
			escribirItinerarioAtracciones(salida);
			salida.println("TOTAL TIEMPO:" + tiempoUsado + "hs" );
			salida.println("TOTAL VALOR: $" + presupuestoUsado + "." );
		}else if(getItinerarioAtracciones().isEmpty() && !getItinerarioPromociones().isEmpty()) {
			escribirItinerarioPromociones(salida);
			salida.println("TOTAL TIEMPO:" + tiempoUsado + "hs" );
			salida.println("TOTAL VALOR: $" + presupuestoUsado + "." );
		}else {
			escribirItinerarioPromociones(salida);
			escribirItinerarioAtracciones(salida);
			salida.println("TOTAL TIEMPO:" + tiempoUsado + "hs" );
			salida.println("TOTAL VALOR: $" + presupuestoUsado + "." );
		}
		
	}
	
	private void escribirItinerarioPromociones(PrintWriter salida) {
		salida.println("Promociones:");
		for(Promocion promo : itinerarioPromociones) {
			salida.println(promo.getNombre() + " que contiene las atracciones:" );
			for(Atraccion atracc : promo.atracciones) {
				salida.println("      " + atracc.getNombre());
			}
		}
	}

	private void escribirItinerarioAtracciones(PrintWriter salida) {
		salida.println("Atracciones:");
		for(Atraccion atracc : itinerarioAtracciones) {
			salida.println(atracc.getNombre());
		}
	}

	private void decirItinerarioAtracciones() {
		System.out.println("Las atracciones elegidas fueron: ");
		for(Atraccion atracc : itinerarioAtracciones) {
			System.out.println("La atraccion " + atracc.getNombre() +".");
		}
	}

	public int getPresupuestoUsado() {
		return presupuestoUsado;
	}

	public void setPresupuestoUsado(int presupuestoUsado) {
		this.presupuestoUsado = presupuestoUsado;
	}

	public double getTiempoUsado() {
		return tiempoUsado;
	}

	public void setTiempoUsado(double tiempoUsado) {
		this.tiempoUsado = tiempoUsado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itinerarioAtracciones, itinerarioPromociones, nombre, preferencia, presupuesto,
				presupuestoUsado, tiempoDisponible, tiempoUsado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(itinerarioAtracciones, other.itinerarioAtracciones)
				&& Objects.equals(itinerarioPromociones, other.itinerarioPromociones)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(preferencia, other.preferencia)
				&& presupuesto == other.presupuesto && presupuestoUsado == other.presupuestoUsado
				&& Double.doubleToLongBits(tiempoDisponible) == Double.doubleToLongBits(other.tiempoDisponible)
				&& Double.doubleToLongBits(tiempoUsado) == Double.doubleToLongBits(other.tiempoUsado);
	}

	
	
	
}
