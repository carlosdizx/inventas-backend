package arena.dao;

import arena.entity.Activo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActivoDao extends CrudRepository<Activo, Long>
{
    @Query("SELECT a FROM Activo a " +
            "WHERE a.estado=true")
    List<Activo> getAllByEstado();
}
