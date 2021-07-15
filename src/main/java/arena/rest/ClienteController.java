package arena.rest;

import arena.entity.Cliente;
import arena.serivces.api.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/clientes/")
public class ClienteController
{
    private final static Map<String, Object> RESPONSE = new HashMap<>();

    @Autowired
    private ClienteService serivce;

    @GetMapping("all")
    public ResponseEntity<HashMap<String, Object>> getAll()
    {
        RESPONSE.clear();
        final List<Cliente> listado = serivce.getAll();
        if ( !listado.isEmpty() )
        {
            RESPONSE.put("Mensaje",listado);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        RESPONSE.put("Mensaje","No hay clientes");
        return new ResponseEntity(RESPONSE, HttpStatus.OK);
    }

    @PostMapping("all")
    public ResponseEntity<HashMap<String, Object>> create(@RequestBody Cliente pCliente)
    {
        RESPONSE.clear();
        try
        {
            final Cliente cliente = serivce.save(pCliente);
            if (cliente == null) {
                RESPONSE.put("Mensaje", "No se pudo agregar el cliente");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", cliente );
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
            final Cliente cliente = serivce.get(id);
            if (cliente == null) {
                RESPONSE.put("Mensaje", "No se encontró el cliente");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", cliente );
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
    public ResponseEntity<HashMap<String, Object>> update(@PathVariable Integer id,@RequestBody Cliente pCliente)
    {
        RESPONSE.clear();
        try
        {
            Cliente cliente = serivce.get(id);
            if (cliente == null) {
                RESPONSE.put("Mensaje", "No se encontró el cliente, no se pudo actualizar");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            cliente.setNombres( pCliente.getNombres() );
            cliente.setDocumento( pCliente.getDocumento() );
            cliente.setCelular(pCliente.getCelular());
            serivce.save(cliente);
            RESPONSE.put("Mensaje", cliente );
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
            Cliente cliente = serivce.get(id);
            if (cliente == null) {
                RESPONSE.put("Mensaje", "No se encontró el cliente, no se pudo eliminar");
                return new ResponseEntity(RESPONSE, HttpStatus.NOT_FOUND);
            }
            serivce.delete(id);
            RESPONSE.put("Mensaje", "Cliente eliminado!" );
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
