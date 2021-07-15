package arena.rest;

import arena.entity.Factura;
import arena.serivces.api.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/facturas/")
public class FacturaController
{
    private final static Map<String, Object> RESPONSE = new HashMap<>();

    @Autowired
    private FacturaService serivce;

    @GetMapping("all")
    public ResponseEntity<HashMap<String, Object>> getAll()
    {
        RESPONSE.clear();
        final List<Factura> listado = serivce.getAll();
        if ( !listado.isEmpty() )
        {
            RESPONSE.put("Mensaje",listado);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        RESPONSE.put("Mensaje","No hay facturas");
        return new ResponseEntity(RESPONSE, HttpStatus.OK);
    }

    @PostMapping("all")
    public ResponseEntity<HashMap<String, Object>> create(@RequestBody Factura pFactura)
    {
        RESPONSE.clear();
        try
        {
            System.out.println(pFactura);
            final Factura factura = serivce.save(pFactura);
            if (factura == null) {
                RESPONSE.put("Mensaje", "No se pudo agregar la factura");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", factura );
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
            final Factura factura = serivce.get(id);
            if (factura == null) {
                RESPONSE.put("Mensaje", "No se encontró la factura");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", factura );
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
    public ResponseEntity<HashMap<String, Object>> update(@PathVariable Integer id,@RequestBody Factura pFactura)
    {
        RESPONSE.clear();
        try
        {
            Factura factura = serivce.get(id);
            if (factura == null) {
                RESPONSE.put("Mensaje", "No se encontró la factura, no se pudo actualizar");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            factura.setCliente(pFactura.getCliente());
            factura.setDescripcion(pFactura.getDescripcion());
            factura.setItems(pFactura.getItems());
            serivce.save(factura);
            RESPONSE.put("Mensaje", factura );
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("get/{id}")
    public ResponseEntity<HashMap<String, Object>> delete(@PathVariable Integer id)
    {
        RESPONSE.clear();
        try
        {
            Factura factura = serivce.get(id);
            if (factura == null) {
                RESPONSE.put("Mensaje", "No se encontró la factura, no se pudo eliminar");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            serivce.delete(id);
            RESPONSE.put("Mensaje", "Factura eliminada!" );
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
