package arena.serivces.api;

import arena.commons.GenericServiceAPI;
import arena.entity.Cliente;

public interface ClienteService extends GenericServiceAPI<Cliente, Integer>
{
    Cliente findByDocumento(Long documento);
}
