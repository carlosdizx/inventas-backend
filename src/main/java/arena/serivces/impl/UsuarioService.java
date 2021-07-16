package arena.serivces.impl;

import arena.auth.dao.UsuarioDao;
import arena.auth.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService
{
    @Autowired
    private UsuarioDao dao;

    private final static Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException
    {
        final Usuario usuario = dao.findByNombre(nombreUsuario);
        if (usuario==null){
            LOGGER.error("El usuario no existe el usuario '"+nombreUsuario+"'");
            throw new UsernameNotFoundException("El usuario no existe el usuario '"+nombreUsuario+"'");
        }
        final List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                .peek(authority -> LOGGER.info("Rol: "+authority.getAuthority()))
                .collect(Collectors.toList());
        return new User(usuario.getNombre(),usuario.getClave(),usuario.isHabilitado(),true,true,true,authorities);
    }
}
