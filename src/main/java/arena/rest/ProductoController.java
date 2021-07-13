package arena.rest;

import arena.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import arena.serivces.api.ProductoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("api/productos/")
public class ProductoController
{
    private final static Map<String, Object> RESPONSE = new HashMap<>();

    @Autowired
    private ProductoService serivce;

    @GetMapping("allData")
    public List<Producto> getAllData()
    {
        return serivce.getAll();
    }
}
