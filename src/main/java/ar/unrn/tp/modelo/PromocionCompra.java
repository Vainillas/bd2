package ar.unrn.tp.modelo;

import java.time.LocalDate;
import java.util.List;

public class PromocionCompra implements Promocion {
    private final double DESCUENTO = 0.08;
    private LocalDate diaInicio;
    private LocalDate diaFin;
    private TarjetaCredito tarjeta;
    public PromocionCompra(LocalDate diaInicio, LocalDate diaFin, TarjetaCredito tarjeta) {
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.tarjeta = tarjeta;
    }

    @Override
    public double aplicarPromocion(List<Producto> productos, TarjetaCredito tarjetaCredito) {
        double descuento = 0;
            if((diaInicio.isEqual(LocalDate.now()) && diaFin.isAfter(LocalDate.now())) || diaInicio.isEqual(LocalDate.now()) || diaFin.isEqual(LocalDate.now())) {
                for(Producto producto : productos)
                    if (tarjetaCredito.equals(tarjeta)) {
                        descuento -= producto.aplicarDescuento(DESCUENTO);
                    }
            }
            return descuento;
    }
}
