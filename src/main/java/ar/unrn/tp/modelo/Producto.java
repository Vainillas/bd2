package ar.unrn.tp.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
    private String codigo;
    private String descripcion;
    private Categoria categoria;
    private Marca marca;
    private double precio;

    public Producto(String codigo, String descripcion, Categoria categoria, Marca marca, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.marca = marca;
        this.precio = precio;
    }

    public boolean sosDeMarca(Marca marca) {
        return this.marca.equals(marca);
    }
    public double aplicarDescuento(double descuento){
        return precio - (precio * descuento);
    }
}
