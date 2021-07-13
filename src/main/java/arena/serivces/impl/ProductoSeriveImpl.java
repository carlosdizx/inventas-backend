package arena.serivces.impl;

import arena.commons.GenericServiceImpl;
import arena.dao.ProductoDao;
import arena.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoSeriveImpl extends GenericServiceImpl<Producto, Integer>
{
    @Autowired
    private ProductoDao dao;

    @Override
    public CrudRepository<Producto, Integer> getDao()
    {
        return dao;
    }
}
