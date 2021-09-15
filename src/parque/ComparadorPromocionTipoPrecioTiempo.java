package parque;

import java.util.Comparator;

public class ComparadorPromocionTipoPrecioTiempo implements Comparator<Promocion> {

	
	@Override
	public int compare(Promocion o1, Promocion o2) {
		 int resultado = o1.getTipoPromocion().compareTo(o2.getTipoPromocion());
         if ( resultado != 0 ){ 
         	return resultado; 
         }
         resultado = -Integer.compare(o1.getPrecioFinal(), o2.getPrecioFinal());
         if ( resultado != 0 ){ 
         return resultado; 
         }
        
         resultado = -Double.compare(o1.getTiempoTotal(), o2.getTiempoTotal());
         return resultado; 
	}
}
