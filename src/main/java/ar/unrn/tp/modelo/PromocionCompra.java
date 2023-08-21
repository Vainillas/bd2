package ar.unrn.tp.modelo;

import java.time.LocalDate;
import java.util.List;

public class PromocionCompra implements Promocion {
    private final double DESCUENTO = 0.08;
    private LocalDate diaInicio;
    private LocalDate diaFin;
    private EmisorTarjeta emisorTarjeta;
    public PromocionCompra(LocalDate diaInicio, LocalDate diaFin, EmisorTarjeta emisorTarjeta) {
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.emisorTarjeta = emisorTarjeta;
    }

    @Override
    public double aplicarPromocion(List<Producto> productos, TarjetaCredito tarjetaCredito) {
        double descuento = 0;
            if((diaInicio.isEqual(LocalDate.now()) && diaFin.isAfter(LocalDate.now())) || (diaInicio.isBefore(LocalDate.now()) && diaFin.isEqual(LocalDate.now())) || (diaInicio.isBefore(LocalDate.now()) && diaFin.isAfter(LocalDate.now()))) {
                for(Producto producto : productos)
                    if (tarjetaCredito.esEmisor(emisorTarjeta)) {
                        descuento -= producto.getPrecio() - producto.aplicarDescuento(DESCUENTO);
                    }
            }
            return descuento;
    }

    @Override
    public double aplicarPromocion(List<Producto> productos) {
        return 0;
    }
}
