package ar.unrn.tp.modelo;

import java.time.LocalDate;
import java.util.List;
public class PromocionProducto implements Promocion{
    private final double DESCUENTO = 0.05;
    private LocalDate diaInicio;
    private LocalDate diaFin;
    private Marca marca;

    @Override
    public double aplicarPromocion(List<Producto> productos) {
        double descuento = 0;
        if((diaInicio.isEqual(LocalDate.now()) && diaFin.isAfter(LocalDate.now())) || diaInicio.isEqual(LocalDate.now()) || diaFin.isEqual(LocalDate.now())) {
            for(Producto producto : productos) {
                if(producto.sosDeMarca(marca)) {
                    descuento -= producto.aplicarDescuento(DESCUENTO);
                }
            }
        }
        return descuento;
    }
}
