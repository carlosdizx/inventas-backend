package arena.rest;

import arena.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import arena.serivces.api.ProductoService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080","*"})
@CrossOrigin(origins = "*")
@RequestMapping("api/productos/")
public class ProductoController
{
    private final static Map<String, Object> RESPONSE = new HashMap<>();

    @Autowired
    private ProductoService serivce;

    @GetMapping("all")
    public ResponseEntity<HashMap<String, Object>> getAll()
    {
        RESPONSE.clear();
        final List<Producto> listado = serivce.getAll();
        if ( !listado.isEmpty() )
        {
            RESPONSE.put("Mensaje",listado);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        RESPONSE.put("Mensaje","No hay productos");
        return new ResponseEntity(RESPONSE, HttpStatus.OK);
    }

    @PostMapping("all")
    public ResponseEntity<HashMap<String, Object>> create(@RequestBody Producto pProducto)
    {
        RESPONSE.clear();
        try
        {
            final Producto producto = serivce.save(pProducto);
            if (producto == null) {
                RESPONSE.put("Mensaje", "No se pudo agregar el producto");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", producto );
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("get/{id}")
    public ResponseEntity<HashMap<String, Object>> findByID(@PathVariable Integer id)
    {
        RESPONSE.clear();
        try
        {
            final Producto producto = serivce.get(id);
            if (producto == null) {
                RESPONSE.put("Mensaje", "No se encontró el producto");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", producto );
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("get/{id}")
    public ResponseEntity<HashMap<String, Object>> update(@PathVariable Integer id,@RequestBody Producto pProducto)
    {
        RESPONSE.clear();
        try
        {
            Producto producto = serivce.get(id);
            if (producto == null) {
                RESPONSE.put("Mensaje", "No se encontró el producto, no se pudo actualizar");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            producto.setNombre( pProducto.getNombre() );
            producto.setPrecioCompra( pProducto.getPrecioCompra() );
            producto.setPrecioVenta( pProducto.getPrecioVenta() );
            serivce.save(producto);
            RESPONSE.put("Mensaje", producto );
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
