package arena.auth.serivces.api;

import arena.auth.entity.Usuario;

public interface UsuarioService
{
    Usuario findByUsername(String nombre);

}
