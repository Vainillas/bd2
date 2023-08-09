package ar.unrn.tp.modelo;

import java.util.List;

public class CarritoCompra {
    private final Cliente cliente;
    private List<Producto> productos;

    public CarritoCompra(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
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
