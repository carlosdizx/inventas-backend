package arena.dao;

import arena.entity.Inventario;
import org.springframework.data.repository.CrudRepository;

public interface InventarioDao extends CrudRepository<Inventario, Long>
{
}
