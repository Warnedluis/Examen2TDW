package com.upiiz.examen2.entities.EntitiesBasics;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name = "productos")

public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private double costoUnitarioProducto;
    private String nombreProducto;

    @ManyToMany(mappedBy = "productos")
    List<VentasEntity> ventas;

    public ProductoEntity()
    {

    }

    public ProductoEntity(Long idProducto, double costoUnitarioProducto, String nombreProducto)
    {
        this.idProducto = idProducto;
        this.costoUnitarioProducto = costoUnitarioProducto;
        this.nombreProducto = nombreProducto;
    }

    public Long getIdProducto()
    {
        return idProducto;
    }

    public String getNombreProducto()
    {
        return nombreProducto;
    }

    public double getCostoUnitarioProducto()
    {
        return costoUnitarioProducto;
    }

    public void setIdProducto(Long idProducto)
    {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto)
    {
        this.nombreProducto=nombreProducto;
    }

    public void setCostoUnitarioProducto(double costoUnitarioProducto)
    {
        this.costoUnitarioProducto = costoUnitarioProducto;
    }

}