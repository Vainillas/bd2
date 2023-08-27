package ar.unrn.tp.modelo;
;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import java.util.List;
@Getter
@Setter
public class Venta {
    private LocalDateTime fechaHora;
    private Cliente cliente;
    private List<ProductoHistorico> listaProductos;
    private double montoTotal;

    public Venta(LocalDateTime fechaHora, Cliente cliente, List<Producto> listaProductosHistoricos, double montoTotal) {
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.listaProductos = convertirProductosAHistorico(listaProductosHistoricos);
        this.montoTotal = montoTotal;
    }
    public List<ProductoHistorico> convertirProductosAHistorico(List<Producto> listaProductos){
        return List.of(listaProductos.stream().map(producto -> new ProductoHistorico(producto.getCodigo(), producto.getDescripcion(), producto.getCategoria(), producto.getPrecio(), producto.getMarca())).toArray(ProductoHistorico[]::new));
    }

}
