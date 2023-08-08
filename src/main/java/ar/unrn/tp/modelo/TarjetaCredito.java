package ar.unrn.tp.modelo;

public class TarjetaCredito {
    private boolean activa;
    private double fondos;

    public boolean estaActiva() {
        return activa;
    }

    public boolean tieneFondosSuficientes(double monto) {
        return fondos >= monto;
    }
    public void descontarFondos(double monto) {
        fondos -= monto;
    }
    public void sumarFondos(double monto) {
        fondos += monto;
    }
}
