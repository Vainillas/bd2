package ar.unrn.tp.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class CarritoCompra {
    private final Cliente cliente;
    private List<Producto> productos;
    private TarjetaCredito tarjetaCredito;
    private PromocionCollector promociones;

    public CarritoCompra(Cliente cliente, List<Producto> productos,  PromocionCollector promociones) {
        this.cliente = cliente;
        this.productos = productos;
        this.promociones = promociones;
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
        return this.promociones.retornarTotal(this.productos);
    }
    public double calcularTotal(TarjetaCredito tarjetaCredito){
        return this.promociones.retornarTotal(this.productos, tarjetaCredito);
    }
    public Venta generarVenta(TarjetaCredito tarjetaCredito) {
        List<ProductoHistorico> productoHistoricos = List.of(productos.stream().map(producto -> new ProductoHistorico(producto.getCodigo(), producto.getDescripcion(), producto.getCategoria(), producto.getPrecio(), producto.getMarca())).toArray(ProductoHistorico[]::new));
        pagar(tarjetaCredito);
        return new Venta(LocalDateTime.now(),this.cliente, productoHistoricos,this.calcularTotal(tarjetaCredito) );
    }

    private void pagar(TarjetaCredito tarjetaCredito) {
        tarjetaCredito.pagar(this.calcularTotal(tarjetaCredito));
    }
}
