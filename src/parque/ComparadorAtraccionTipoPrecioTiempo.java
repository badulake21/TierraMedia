package parque;

import java.util.Comparator;

public class ComparadorAtraccionTipoPrecioTiempo implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion o1, Atraccion o2) {
            int resultado = o1.getTipo().compareTo(o2.getTipo());
            if ( resultado != 0 ){ 
            	return resultado; 
            }
            resultado = -Integer.compare(o1.getPrecio(), o2.getPrecio());
            if ( resultado != 0 ){ 
            return resultado; 
            }
           
            resultado = -Double.compare(o1.getTiempo(), o2.getTiempo());
            return resultado; 
        }
	}
