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

    public Venta(LocalDateTime fechaHora, Cliente cliente, List<ProductoHistorico> listaProductos, double montoTotal) {
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.montoTotal = montoTotal;
    }

}
