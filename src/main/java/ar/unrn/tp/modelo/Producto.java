package ar.unrn.tp.modelo;

import lombok.Getter;

public class Producto {
    private String codigo;
    private String descripcion;
    private Categoria categoria;
    @Getter
    private double precio;

    // Constructor, getters y setters
}
