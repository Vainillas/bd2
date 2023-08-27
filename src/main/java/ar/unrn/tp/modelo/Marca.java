package ar.unrn.tp.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class Marca {
    @Id
    private String nombre;

    public Marca(String nombre) {
        this.nombre = nombre;
    }

}
