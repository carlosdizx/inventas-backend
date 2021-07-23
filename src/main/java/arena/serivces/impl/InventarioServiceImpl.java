package arena.serivces.impl;

import arena.commons.GenericServiceImpl;
import arena.dao.InventarioDao;
import arena.dao.ProductoDao;
import arena.entity.Inventario;
import arena.entity.Producto;
import arena.serivces.api.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl extends GenericServiceImpl<Inventario, Long> implements InventarioService
{
    @Autowired
    private InventarioDao dao;

    @Override
    public CrudRepository<Inventario, Long> getDao()
    {
        return dao;
    }
}
