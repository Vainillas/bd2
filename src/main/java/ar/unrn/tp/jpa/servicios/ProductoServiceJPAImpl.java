package ar.unrn.tp.jpa.servicios;

import ar.unrn.tp.api.ProductoService;
import ar.unrn.tp.modelo.Categoria;
import ar.unrn.tp.modelo.Producto;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class ProductoServiceJPAImpl extends ServiceJPAImpl implements ProductoService  {
    private EntityManagerFactory entityManager;

    public ProductoServiceJPAImpl(){
        super();
    }

    @Override
    public void crearProducto(String codigo, String descripcion, double precio, Long idCategoria) {
        inTransactionExecute((em) -> {
            Categoria categoria = em.find(Categoria.class, idCategoria);
            Producto producto = new Producto(codigo,descripcion,categoria,precio);
            em.persist(producto);
        });

    }

    @Override
    public void modificarProducto(Long idProducto, String codigo, String descripcion, Long idCategoria, Long idMarca, double precio) {
            inTransactionExecute((em) -> {
                Producto producto = em.find(Producto.class, idProducto);
                Categoria categoria = em.find(Categoria.class, idCategoria);
                producto.setCodigo(codigo);
                producto.setDescripcion(descripcion);
                producto.setCategoria(categoria);
                producto.setPrecio(precio);
                em.persist(producto);
            });
    }

    @Override
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        inTransactionExecute((em) -> {
            productos.addAll(em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList());
        });
        return productos;
    }
    @Override
    public List<Producto> encontrarProductos(List<Long> idProductos){
        List<Producto> productos = new ArrayList<>();
        inTransactionExecute((em) -> {
            for (Long idProducto : idProductos) {
                Producto producto = em.find(Producto.class, idProducto);
                productos.add(producto);
            }
        });
        return productos;
    }
}
