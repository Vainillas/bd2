package ar.unrn.tp.modelo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TarjetaCredito {
    private boolean activa;
    private double fondos;

    public TarjetaCredito(boolean activa, double fondos) {
        this.activa = activa;
        this.fondos = fondos;
    }


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

    public void pagar(double v) {
        this.descontarFondos(v);
    }
}
