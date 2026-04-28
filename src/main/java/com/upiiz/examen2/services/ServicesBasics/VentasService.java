package com.upiiz.examen2.services.ServicesBasics;

import java.util.List;

import com.upiiz.examen2.entities.EntitiesBasics.VentasEntity;

public interface VentasService {

    VentasEntity crearVenta(VentasEntity ventasEntity);
    VentasEntity actualizarVenta(VentasEntity ventasEntity);
    List<VentasEntity> listarVentas();
    void borrarVenta(Long idVenta);
    VentasEntity getVentaPorId(Long idVenta);
    
}
