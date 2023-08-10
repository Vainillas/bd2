package ar.unrn.tp.modelo;

import java.util.List;

public interface Promocion {
    double aplicarPromocion(List<Producto> productos, TarjetaCredito tarjetaCredito);

}
