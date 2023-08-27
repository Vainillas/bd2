package ar.unrn.tp.modelo;

import java.time.LocalDate;
import java.util.List;
public class PromocionProducto implements Promocion{
    private double DESCUENTO = 0.05;
    private LocalDate diaInicio;
    private LocalDate diaFin;
    private Marca marca;

    public PromocionProducto(LocalDate diaInicio, LocalDate diaFin, Marca marca) {
        validarAtributosPromocion(diaInicio, diaFin);
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.marca = marca;
    }
    public PromocionProducto(LocalDate diaInicio, LocalDate diaFin, Marca marca, double descuento) {
        this(diaInicio, diaFin, marca);
        this.DESCUENTO = descuento;
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

    @Override
    public double aplicarPromocion(List<Producto> productos) {
        return aplicarPromocion(productos, null);
    }
}
