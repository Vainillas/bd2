package ar.unrn.tp.modelo;

import java.util.List;

public class PromocionCollector {
    private List<Promocion> promociones;

    public double retornarTotal(List<Producto> productos) {
        double descuento = 0;
        double total = 0;
        for(Producto producto : productos) {
            total += producto.getPrecio();
        }
        for (Promocion promocion : promociones) {
            descuento += promocion.aplicarPromocion(productos);
        }
        return total;
    }
}
