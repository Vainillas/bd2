package ar.unrn.tp.main;

import ar.unrn.tp.api.ClienteService;
import ar.unrn.tp.jpa.servicios.ClienteServiceJPAImpl;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteServiceJPA = new ClienteServiceJPAImpl();
        //clienteServiceJPA.crearCliente("Mateo", "Aliberti", "43303613", "mateoaliberti@gmail.com");
        clienteServiceJPA.agregarTarjeta(1L, "123456789", "VISA");
    }
}
