package arena.auth.dao;

import arena.auth.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario,Integer>
{
    Usuario findByUsername(String nombre);

    @Query("SELECT u From Usuario u WHERE u.username=?1")
    Usuario buscarPorNombre(String nombre);
}
