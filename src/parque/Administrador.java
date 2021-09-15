package parque;

import java.util.Arrays;
import java.util.Scanner;

public class Administrador {
	private Atraccion atracciones [];
	private Promocion promociones[];
	private Usuario usuarios[];
	Scanner teclado;
	
	public Administrador() {
		
	}
	
	public Administrador(Atraccion[] atracciones, Usuario[] usuarios) {
		this.atracciones = atracciones;
		this.usuarios = usuarios;
	}
	
	public void agregarTodasAtracciones(Atraccion[] atracciones) {
		this.atracciones = atracciones;
	}
	
	public void agregarTodosUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	
	public void agregarTodasPromociones(Promocion[] promociones) {
		this.promociones = promociones;
	}
	
	public Atraccion obtenerAtraccionPorNombre(String nombre) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equalsIgnoreCase(nombre)) {
				return atraccion;
			}
		}
		return null;
	}
	
	public void ordenarPromociones(){
		Arrays.sort(this.promociones, new ComparadorPromocionTipoPrecioTiempo());
	}
	
	public void ordenarAtracciones() {
		Arrays.sort(this.atracciones, new ComparadorAtraccionTipoPrecioTiempo());
	}
	
	public void recomendarAUsuarios(){
		for(Usuario usu : this.usuarios) {
			System.out.println("--¡Bienvenido " + usu.getNombre() + "!--");
			System.out.println("Le ofreceremos promociones y atracciones para que arme su itinerario en Tierra Media de acuerdo a su preferencia, presupuesto y tiempo disponible. ");
			ofrecerPromociones(usu);
			ofrecerAtracciones(usu);
			escribirPorPantallaItinerario(usu);
			System.out.println("----------------------------------");
		}
		teclado.close();
	}
	
	private void escribirPorPantallaItinerario(Usuario usu) {
		usu.decirItinerario();
	}
	
	private void ofrecerPromociones(Usuario usu) {
		teclado = new Scanner(System.in);
		for(Promocion promo : this.promociones) {
					if(usu.getTiempoDisponible() >= promo.getTiempoTotal() && usu.getPresupuesto() >= promo.getPrecioFinal() && promo.corroborarCupo()) {
						System.out.println("Le sugerimos:");
						System.out.println("       La promoción " + promo.getNombre() + " que incluye las atracciones: " + promo.decirAtracciones() + 
								"por un precio total de $" + promo.getPrecioFinal() + ". Le llevará " + promo.getTiempoTotal() + "hs.");
						System.out.println("Ingrese SI si acepta la oferta o NO para declinarla");
						String acepto = teclado.nextLine();
						if(acepto.equalsIgnoreCase("SI")){
							usu.setPresupuesto(usu.getPresupuesto() - promo.getPrecioFinal());
							usu.setTiempoDisponible(usu.getTiempoDisponible() - promo.getTiempoTotal());
							usu.setTiempoUsado(usu.getTiempoUsado() + promo.getTiempoTotal());
							usu.setPresupuestoUsado(usu.getPresupuestoUsado() + promo.getPrecioFinal());
							usu.agregarPromocionAItinerario(promo);
								for(Atraccion atracc : promo.getAtracciones()) {
									atracc.setCupo(atracc.getCupo() - 1);
								}
						}
					}
			}
		}
	
	private void ofrecerAtracciones(Usuario usu) {
		teclado = new Scanner(System.in);
		for(Atraccion atracc : this.atracciones) {
			if(!usu.getItinerarioPromociones().isEmpty()) {
			for(Promocion promo : usu.getItinerarioPromociones()) {
				if(!promo.getAtracciones().contains(atracc) && usu.getTiempoDisponible() >= atracc.getTiempo() && usu.getPresupuesto() >= atracc.getPrecio() && atracc.getCupo() > 0){
					System.out.println("Le sugerimos:");
					System.out.println("La atracción " + atracc.getNombre()  + ", por un precio de $" + atracc.getPrecio() 
					+ ". Le llevará " + atracc.getTiempo() + "hs.");
					System.out.println("Ingrese SI si acepta la oferta o NO para declinarla");
					String acepto = teclado.nextLine();
					if(acepto.equalsIgnoreCase("SI")){
						usu.setPresupuesto(usu.getPresupuesto() - atracc.getPrecio());
						usu.setTiempoDisponible(usu.getTiempoDisponible() - atracc.getTiempo());
						usu.setTiempoUsado(usu.getTiempoUsado() + atracc.getTiempo());
						usu.setPresupuestoUsado(usu.getPresupuestoUsado() + atracc.getPrecio());
						usu.agregarAtraccionAItinerario(atracc);
					}
				}
			}
		} else {
			if(usu.getTiempoDisponible() >= atracc.getTiempo() && usu.getPresupuesto() >= atracc.getPrecio()){
				System.out.println("Le sugerimos:");
				System.out.println("La atracción " + atracc.getNombre()  + ", por un precio de $" + atracc.getPrecio() 
				+ ". Le llevará " + atracc.getTiempo() + "hs.");
				System.out.println("Ingrese SI si acepta la oferta o NO para declinarla");
				String acepto = teclado.nextLine();
				if(acepto.equalsIgnoreCase("SI")){
					usu.setPresupuesto(usu.getPresupuesto() - atracc.getPrecio());
					usu.setTiempoDisponible(usu.getTiempoDisponible() - atracc.getTiempo());
					usu.setTiempoUsado(usu.getTiempoUsado() + atracc.getTiempo());
					usu.setPresupuestoUsado(usu.getPresupuestoUsado() + atracc.getPrecio());
					usu.agregarAtraccionAItinerario(atracc);
				}
			}
		}
		}
	}
	

	@Override
	public String toString() {
		return "Administrador [atracciones=" + Arrays.toString(atracciones) + ", promociones="
				+ Arrays.toString(promociones) + ", usuarios=" + Arrays.toString(usuarios) + "]";
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}

}
