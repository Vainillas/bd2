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
        validarAtributosConstructor(descripcion, categoria, precio, marca);
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.marca = marca;
        this.precio = precio;
    }
    private void validarAtributosConstructor(String descripcion, Categoria categoria, double precio, Marca marca) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new RuntimeException("La descripcion no puede ser nula o vacia");
        }
        if (categoria == null) {
            throw new RuntimeException("La categoria no puede ser nula");
        }
        if (precio <= 0) {
            throw new RuntimeException("El precio no puede ser menor o igual a cero");
        }
        if (marca == null) {
            throw new RuntimeException("La marca no puede ser nula");
        }
    }



    public boolean sosDeMarca(Marca marca) {
        return this.marca.equals(marca);
    }
    public double aplicarDescuento(double descuento){
        return precio - (precio * descuento);
    }
}
