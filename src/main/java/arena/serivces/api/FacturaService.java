package arena.serivces.api;

import arena.commons.GenericServiceAPI;
import arena.entity.Factura;

import java.util.List;

public interface FacturaService extends GenericServiceAPI<Factura, Integer>
{
    List<Factura> findAllByCliente(final Long pDopcumento);
}
