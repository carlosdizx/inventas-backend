package arena.serivces.impl;

import arena.commons.GenericServiceImpl;
import arena.dao.ClienteDao;
import arena.dao.ProductoDao;
import arena.entity.Cliente;
import arena.serivces.api.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements ClienteService
{
    @Autowired
    private ClienteDao dao;

    @Override
    public CrudRepository<Cliente, Integer> getDao()
    {
        return dao;
    }
}
