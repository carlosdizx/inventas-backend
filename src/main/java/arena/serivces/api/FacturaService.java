package arena.serivces.api;

import arena.commons.GenericServiceAPI;
import arena.entity.Factura;
import arena.models.FacturaInfo;

import java.util.List;

public interface FacturaService extends GenericServiceAPI<Factura, Integer>
{
    List listadoGastosClietes();

    List<FacturaInfo> findAllFacturas();
}
