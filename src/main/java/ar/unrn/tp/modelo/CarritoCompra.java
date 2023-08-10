package ar.unrn.tp.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CarritoCompra {
    private final Cliente cliente;
    private List<Producto> productos;
    private TarjetaCredito tarjetaCredito;
    private PromocionCollector promociones;

    public CarritoCompra(Cliente cliente, List<Producto> productos, TarjetaCredito tarjetaCredito, PromocionCollector promociones) {
        this.cliente = cliente;
        this.productos = productos;
        this.tarjetaCredito = tarjetaCredito;
        this.promociones = promociones;
    }
    public CarritoCompra(Cliente cliente, List<Producto> productos, TarjetaCredito tarjetaCredito, List<Promocion> promociones) {
        this.cliente = cliente;
        this.productos = productos;
        this.tarjetaCredito = tarjetaCredito;
        this.promociones = new PromocionCollector(promociones);
    }

    public CarritoCompra(Cliente cliente) {
        this.cliente = cliente;
    }
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }
    public void quitarProducto(Producto producto) {
        this.productos.remove(producto);
    }
    public void vaciarCarrito() {
        this.productos.clear();
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : this.productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
