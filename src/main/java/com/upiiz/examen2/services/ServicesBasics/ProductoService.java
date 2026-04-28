package com.upiiz.examen2.services.ServicesBasics;

import java.util.List;

import com.upiiz.examen2.entities.EntitiesBasics.ProductoEntity;

public interface ProductoService
{
    ProductoEntity crearProducto(ProductoEntity productoEntity);
    ProductoEntity actualizarProducto(ProductoEntity productoEntity);
    List<ProductoEntity> listarProductos();
    void borrarProducto(Long idProducto);
    ProductoEntity getProductoPorId(Long idProducto);

}
