package ar.unrn.tp.modelo;

public class ProductoHistorico extends Producto{
    private double precio;

    public ProductoHistorico(String codigo, String descripcion, Categoria categoria, double precio, Marca marca) {
        super(codigo, descripcion, categoria, marca, precio);
    }

    public double precio() {
        return precio;
    }
}
