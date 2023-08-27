package ar.unrn.tp.jpa.servicios;

import ar.unrn.tp.api.PromocionService;
import ar.unrn.tp.modelo.*;

import java.time.LocalDate;

public class PromocionServiceJPAImpl extends ServiceJPAImpl implements PromocionService {

    public PromocionServiceJPAImpl(){
        super();
    }

    @Override
    public void crearDescuentoSobreTotal(String marcaTarjeta, LocalDate fechaDesde, LocalDate fechaHasta, double porcentaje) {
        inTransactionExecute((em) -> {
            Promocion promocion = new PromocionCompra(fechaDesde, fechaHasta, EmisorTarjeta.valueOf(marcaTarjeta), porcentaje);
            em.persist(promocion);
        });
    }

    @Override
    public void crearDescuento(String marcaProducto, LocalDate fechaDesde, LocalDate fechaHasta, double porcentaje) {
        inTransactionExecute((em) -> {
            Marca marca = em.find(Marca.class, marcaProducto);
            Promocion promocion = new PromocionProducto(fechaDesde, fechaHasta, marca, porcentaje);
            em.persist(promocion);
        });
    }
}
