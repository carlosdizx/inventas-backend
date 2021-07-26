package arena.rest;

import arena.entity.Activo;
import arena.entity.Inventario;
import arena.serivces.api.ActivoService;
import arena.serivces.api.InventarioService;
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
@RequestMapping("api/activos/")
public class ActivoController
{
    private final static Map<String, Object> RESPONSE = new HashMap<>();

    @Autowired
    private ActivoService serivce;

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("all")
    public ResponseEntity<HashMap<String, Object>> getAll()
    {
        RESPONSE.clear();
        final List<Activo> listado = serivce.getAllByEstado();
        if ( !listado.isEmpty() )
        {
            RESPONSE.put("Mensaje",listado);
            return new ResponseEntity(RESPONSE, HttpStatus.OK);
        }
        RESPONSE.put("Mensaje","No hay activos");
        return new ResponseEntity(RESPONSE, HttpStatus.OK);
    }
}
