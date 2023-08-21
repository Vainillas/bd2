package ar.unrn.tp.modelo;

import java.time.LocalDate;
import java.util.List;
public class PromocionProducto implements Promocion{
    private final double DESCUENTO = 0.05;
    private LocalDate diaInicio;
    private LocalDate diaFin;
    private Marca marca;

    public PromocionProducto(LocalDate diaInicio, LocalDate diaFin, Marca marca) {
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.marca = marca;
    }

    @Override
    public double aplicarPromocion(List<Producto> productos, TarjetaCredito tarjetaCredito) {
        double descuento = 0;
        if((diaInicio.isEqual(LocalDate.now()) && diaFin.isAfter(LocalDate.now())) || (diaInicio.isBefore(LocalDate.now()) && diaFin.isEqual(LocalDate.now())) || (diaInicio.isBefore(LocalDate.now()) && diaFin.isAfter(LocalDate.now()))) {
            for(Producto producto : productos) {
                if(producto.sosDeMarca(marca)) {
                    descuento -= producto.getPrecio() - producto.aplicarDescuento(DESCUENTO);
                }
            }
        }
        return descuento;
    }

    @Override
    public double aplicarPromocion(List<Producto> productos) {
        return aplicarPromocion(productos, null);
    }
}
