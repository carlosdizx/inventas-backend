package arena.serivces.api;

import arena.commons.GenericServiceAPI;
import arena.entity.Activo;

import java.util.List;

public interface ActivoService extends GenericServiceAPI<Activo, Long>
{
    List<Activo> getAllByEstado();
}
