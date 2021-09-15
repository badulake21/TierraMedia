package main;

import java.io.IOException;

import parque.Administrador;
import parque.CargaDiaria;

public class App {

	public static void main(String[] args) throws IOException {
		Administrador admin = new Administrador();
		CargaDiaria carga = new CargaDiaria();
		
		admin.agregarTodasAtracciones(carga.obtenerAtraccionesDesdeArchivo());
		
		admin.agregarTodosUsuarios(carga.obtenerUsuariosDesdeArchivo());
		
		admin.agregarTodasPromociones(carga.obtenerPromocionesDesdeArchivo(admin));
		
		
		admin.ordenarAtracciones();
		admin.ordenarPromociones();
		
		admin.recomendarAUsuarios();
		System.out.println("---Sistema finalizado---");
		
		carga.escribirArchivoDeSalida(admin.getUsuarios(), "salida.txt");
	}

}
