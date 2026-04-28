package com.upiiz.examen2.services.ServicesBasics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upiiz.examen2.entities.EntitiesBasics.ProductoEntity;
import com.upiiz.examen2.repositories.RepositoriesBasics.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public ProductoEntity crearProducto(ProductoEntity productoEntity)
    {
        return productoRepository.save(productoEntity);
    }

    @Override
    public ProductoEntity actualizarProducto(ProductoEntity productoEntity)
    {
        return productoRepository.save(productoEntity);
    }

    @Override
    public List<ProductoEntity> listarProductos()
    {
        return productoRepository.findAll();
    }

    @Override
    public void borrarProducto(Long idProducto)
    {
        productoRepository.deleteById(idProducto);
    }

    @Override
    public ProductoEntity getProductoPorId(Long idProducto)
    {
        return productoRepository.findById(idProducto).orElse(null);
    }
}
