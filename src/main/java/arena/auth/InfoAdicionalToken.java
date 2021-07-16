package arena.auth;

import arena.auth.entity.Usuario;
import arena.auth.serivces.api.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer
{
    private final static Map<String, Object> INFO = new HashMap<>();

    @Autowired
    private UsuarioService service;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication)
    {
        INFO.clear();
        final Usuario usuario = service.findByUsername(oAuth2Authentication.getName());
        INFO.put("info","Hola, ¿como estas? ".concat(usuario.getUsername()));
        INFO.put("usuario",usuario.getUsername().concat("-").concat(usuario.getId().toString()));
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(INFO);
        return oAuth2AccessToken;
    }
}
