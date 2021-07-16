package arena.auth.dao;

import arena.auth.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario,Integer>
{
    Usuario findByNombre(String nombre);

    @Query("SELECT u From Usuario u WHERE u.nombre=?1")
    Usuario buscarPorNombre(String nombre);
}
