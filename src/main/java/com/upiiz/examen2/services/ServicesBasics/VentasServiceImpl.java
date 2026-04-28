package com.upiiz.examen2.services.ServicesBasics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upiiz.examen2.entities.EntitiesBasics.VentasEntity;
import com.upiiz.examen2.repositories.RepositoriesBasics.ventasRepositorie;

@Service
public class VentasServiceImpl implements VentasService {


    @Autowired
    ventasRepositorie ventasRepositorie;


    @Override
    public VentasEntity crearVenta(VentasEntity ventasEntity)
    {

        return ventasRepositorie.save(ventasEntity);
    }

    @Override
    public VentasEntity actualizarVenta(VentasEntity ventasEntity)
    {
        return ventasRepositorie.save(ventasEntity);
    }

    @Override
    public List<VentasEntity> listarVentas()
    {
        return ventasRepositorie.findAll();
    }

    @Override
    public void borrarVenta(Long idVenta)
    {
         ventasRepositorie.deleteById(idVenta);
    }

    @Override
    public VentasEntity getVentaPorId(Long idVenta)
    {
        return ventasRepositorie.findById(idVenta).orElse(null);
    }
    
}
