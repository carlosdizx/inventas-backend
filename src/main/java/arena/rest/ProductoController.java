package arena.rest;

import arena.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import arena.serivces.api.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        RESPONSE.put("Mensajes","No hay productos");
        return new ResponseEntity(RESPONSE, HttpStatus.OK);
    }
}
