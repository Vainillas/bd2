package ar.unrn.tp.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private String email;

    //escribe un campo que represente una colección de tarjetas de crédito
    private List<TarjetaCredito> tarjetas = new ArrayList<>();

    public Cliente(String dni, String nombre, String apellido, String email, List<TarjetaCredito> tarjetas) {
        this(dni, nombre, apellido, email);
        this.tarjetas = tarjetas;
    }
    public Cliente(String dni, String nombre, String apellido, String email) {
        validarAtributosCliente(dni, nombre, apellido, email);
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
    }
    //Constructor con una sola tarjeta de credito
    public Cliente(String dni, String nombre, String apellido, String email, TarjetaCredito tarjeta) {
        this(dni, nombre, apellido, email);
        agregarTarjeta(tarjeta);
    }
    public void validarAtributosCliente(String dni, String nombre, String apellido, String email) {
        if (dni == null || dni.isEmpty()) {
            throw new RuntimeException("El dni no puede ser nulo o vacio");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("El nombre no puede ser nulo o vacio");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new RuntimeException("El apellido no puede ser nulo o vacio");
        }//Validar que el email tenga un formato válido con regex
        if (email == null || email.isEmpty() || !email.matches("^(.+)@(.+)$")) {
            throw new RuntimeException("El email no puede ser nulo o vacio");
        }
    }
    public void agregarTarjeta(TarjetaCredito tarjeta) {
        tarjetas.add(tarjeta);
    }


}
