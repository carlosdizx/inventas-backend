package arena.serivces.impl;

import arena.commons.GenericServiceImpl;
import arena.dao.ProductoDao;
import arena.entity.Producto;
import arena.serivces.api.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements ProductoService
{
    @Autowired
    private ProductoDao dao;

    @Override
    public CrudRepository<Producto, Integer> getDao()
    {
        return dao;
    }
}
