package arena.rest;

import arena.entity.Inventario;
import arena.entity.Producto;
import arena.serivces.api.InventarioService;
import arena.serivces.api.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/inventarios/")
public class InventarioController
{
    private final static Map<String, Object> RESPONSE = new HashMap<>();

    @Autowired
    private InventarioService serivce;

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("all")
    public ResponseEntity<HashMap<String, Object>> getAll()
    {
        RESPONSE.clear();
        final List<Inventario> listado = serivce.getAll();
        if ( !listado.isEmpty() )
        {
            RESPONSE.put("Mensaje",listado);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        RESPONSE.put("Mensaje","No hay inventarios");
        return new ResponseEntity(RESPONSE, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @PostMapping("all")
    public ResponseEntity<HashMap<String, Object>> create(@RequestBody Inventario pInventario)
    {
        RESPONSE.clear();
        try
        {
            final Inventario inventario = serivce.save(pInventario);
            if (inventario == null) {
                RESPONSE.put("Mensaje", "No se pudo registrar el inventario");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", inventario );
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("get/{id}")
    public ResponseEntity<HashMap<String, Object>> findByID(@PathVariable Long id)
    {
        RESPONSE.clear();
        try {
            final Inventario inventario = serivce.get(id);
            if (inventario == null) {
                RESPONSE.put("Mensaje", "No se encontró el inventario");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", inventario);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        } catch (DataAccessException e) {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
