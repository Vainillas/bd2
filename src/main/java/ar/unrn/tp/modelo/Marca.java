package ar.unrn.tp.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Marca {
    private String nombre;

    public Marca(String nombre) {
        this.nombre = nombre;
    }

}
