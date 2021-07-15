package arena.serivces.impl;

import arena.commons.GenericServiceImpl;
import arena.dao.FacturaDao;
import arena.entity.Factura;
import arena.serivces.api.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura, Integer> implements FacturaService
{
    @Autowired
    private FacturaDao dao;

    @Override
    public CrudRepository<Factura, Integer> getDao()
    {
        return dao;
    }
}
