package arena.dao;

import arena.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer>
{
    Cliente findByDocumento(Long documento);
}
