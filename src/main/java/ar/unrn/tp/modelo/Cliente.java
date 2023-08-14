package ar.unrn.tp.modelo;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
public class Cliente {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    //escribe un campo que represente una colección de tarjetas de crédito
    @OneToMany(cascade = javax.persistence.CascadeType.ALL)
    private List<TarjetaCredito> tarjetas;

    public Cliente(Long id, String nombre, String apellido, String email, List<TarjetaCredito> tarjetas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tarjetas = tarjetas;
    }
    public Cliente(Long id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tarjetas = new ArrayList<>();
    }
    public void agregarTarjeta(TarjetaCredito tarjetaCredito) {
        tarjetas.add(tarjetaCredito);
    }
    public boolean seLlama(String nombre) {
        return this.nombre.equals(nombre);
    }
    public boolean seApellida(String apellido) {
        return this.apellido.equals(apellido);
    }
    public boolean tieneEmail(String email) {
        return this.email.equals(email);
    }




}
