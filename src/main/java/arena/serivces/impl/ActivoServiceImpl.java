package arena.serivces.impl;

import arena.commons.GenericServiceImpl;
import arena.dao.ActivoDao;
import arena.entity.Activo;
import arena.serivces.api.ActivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivoServiceImpl extends GenericServiceImpl<Activo, Long> implements ActivoService
{
    @Autowired
    private ActivoDao dao;

    @Override
    public CrudRepository<Activo, Long> getDao()
    {
        return dao;
    }

    @Override
    public List<Activo> getAllByEstado()
    {
        return dao.getAllByEstado();
    }
}
