package ar.unrn.tp.jpa.servicios;

import ar.unrn.tp.api.ProductoService;
import ar.unrn.tp.api.VentaService;
import ar.unrn.tp.modelo.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class VentaServiceJPAImpl extends ServiceJPAImpl implements VentaService {
    ProductoService productoService;
    public VentaServiceJPAImpl(ProductoService productoService){
        super();
        this.productoService = productoService;
    }
    @Override
    public void realizarVenta(Long idCliente, List<Long> productos, Long idTarjeta) {
        inTransactionExecute((em) -> {
            Cliente c = em.find(Cliente.class, idCliente);
            TarjetaCredito t = em.find(TarjetaCredito.class, idTarjeta);
            List<Producto> productosVenta = productoService.encontrarProductos(productos);
            Venta v = new Venta(LocalDateTime.now(), c, productosVenta, calcularMonto(productos, idTarjeta));
            em.persist(v);
        });
    }

    @Override
    public double calcularMonto(List<Long> productos, Long idTarjeta) {
        AtomicReference<Double> monto = new AtomicReference<>((double) 0);
        inTransactionExecute((em) -> {
            TarjetaCredito tarjetaCredito = em.find(TarjetaCredito.class, idTarjeta);
            List<Producto> productosVenta = productoService.encontrarProductos(productos);
            CarritoCompra carrito = new CarritoCompra(productosVenta, tarjetaCredito);
            monto.set(carrito.calcularTotal(tarjetaCredito));
        });
        return monto.get();
    }

    @Override
    public List<Venta> ventas() {
        List<Venta> ventas = new ArrayList<>();
        inTransactionExecute((em) -> {
            ventas.addAll(em.createQuery("select v from Venta v", Venta.class).getResultList());
        });
        return ventas;
    }
}
