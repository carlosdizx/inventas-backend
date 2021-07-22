package arena.dao;

import arena.entity.Factura;
import arena.models.FacturaInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface FacturaDao extends CrudRepository<Factura, Integer>
{
    @Query("SELECT f.descripcion,sum(p.precioVenta*if.cantidad),avg(p.precioVenta*if.cantidad) FROM Factura f " +
            "INNER JOIN ItemFactura if on f.id = if.factura.id " +
            "INNER JOIN Producto p on p.id=if.producto.id " +
            "GROUP BY f.descripcion")
    List listadoGastosClietes();
}
