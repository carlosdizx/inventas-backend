package arena.serivces.impl;

import arena.commons.GenericServiceImpl;
import arena.dao.FacturaDao;
import arena.entity.Factura;
import arena.models.FacturaInfo;
import arena.serivces.api.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List listadoGastosClietes()
    {
        return dao.listadoGastosClietes();
    }
}
