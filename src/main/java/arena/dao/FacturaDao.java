package arena.dao;

import arena.entity.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacturaDao extends CrudRepository<Factura, Integer>
{
}
