package ar.unrn.tp.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Cliente {
    private String nombre;
    private String apellido;
    private String email;

    //escribe un campo que represente una colección de tarjetas de crédito
    private List<TarjetaCredito> tarjetas = new ArrayList<>();

    public Cliente(String nombre, String apellido, String email, List<TarjetaCredito> tarjetas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tarjetas = tarjetas;
    }
    public Cliente(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
    //Constructor con una sola tarjeta de credito
    public Cliente(String nombre, String apellido, String email, TarjetaCredito tarjeta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tarjetas.add(tarjeta);
    }
    public void agregarTarjeta(TarjetaCredito tarjeta) {
        tarjetas.add(tarjeta);
    }


}
