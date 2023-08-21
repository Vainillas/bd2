package ar.unrn.tp.modelo;

import java.time.LocalDate;
import java.util.List;

public class PromocionCompra implements Promocion {
    private final double DESCUENTO = 0.08;
    private LocalDate diaInicio;
    private LocalDate diaFin;
    private EmisorTarjeta emisorTarjeta;
    public PromocionCompra(LocalDate diaInicio, LocalDate diaFin, EmisorTarjeta emisorTarjeta) {
        validarAtributosPromocion(diaInicio, diaFin);
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
    public void validarAtributosPromocion(LocalDate diaInicio, LocalDate diaFin) {
        if (diaInicio == null) {
            throw new RuntimeException("El dia de inicio no puede ser nulo");
        }
        if (diaFin == null) {
            throw new RuntimeException("El dia de fin no puede ser nulo");
        }
        if (diaInicio.isAfter(diaFin)) {
            throw new RuntimeException("El dia de inicio no puede ser posterior al dia de fin");
        }
    }
}
