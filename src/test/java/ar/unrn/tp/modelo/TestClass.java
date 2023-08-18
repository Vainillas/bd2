package ar.unrn.tp.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TestClass {

    @Test
    public void test01() {
        // Arrange
        Marca nike = new Marca("Nike");
        Producto zapatillasNikeHombre = new Producto("5e001191-96d4-4ade-93da-e8c812f4db98", "Zapatillas Nike Masculinas Talle 40", Categoria.ROPA_DEPORTIVA, nike,1000.0);
        Producto zapatillasNikeMujer = new Producto("5e001191-96d4-4ade-93da-e8c812f4d398", "Zapatillas Nike Femeninas Talle 40", Categoria.ROPA_DEPORTIVA, nike,1000.0);
        TarjetaCredito tarjetaCredito = new TarjetaCredito(true, 10000.0);
        Cliente cliente = new Cliente("Juan", "Perez", "jperez@correo.com", tarjetaCredito);
        PromocionProducto promocionProducto = new PromocionProducto(LocalDate.now().plusDays(2L), LocalDate.now().minusDays(2L), nike);
        PromocionCompra promocionCompra = new PromocionCompra(LocalDate.now().plusDays(2L), LocalDate.now().minusDays(2L), tarjetaCredito);
        PromocionCollector promocionCollector = new PromocionCollector(List.of(promocionCompra, promocionProducto));

        CarritoCompra carritoCompra = new CarritoCompra(cliente, List.of(zapatillasNikeHombre, zapatillasNikeMujer), promocionCollector);
        // Act
        double total = carritoCompra.calcularTotal(tarjetaCredito);
        // Assert
        Assertions.assertEquals(total,2000.0);
    }
}
