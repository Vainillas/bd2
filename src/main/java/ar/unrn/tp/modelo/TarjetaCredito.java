package ar.unrn.tp.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TarjetaCredito {
    private EmisorTarjeta emisorTarjeta;
    private boolean activa;
    private double fondos;

    public TarjetaCredito(boolean activa, double fondos, EmisorTarjeta emisorTarjeta) {
        this.activa = activa;
        this.fondos = fondos;
        this.emisorTarjeta = emisorTarjeta;
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

    public boolean esEmisor(EmisorTarjeta emisorTarjeta) {
        return this.emisorTarjeta.equals(emisorTarjeta);
    }
}
