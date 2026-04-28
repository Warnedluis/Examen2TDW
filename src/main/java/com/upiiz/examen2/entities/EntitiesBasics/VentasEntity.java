package com.upiiz.examen2.entities.EntitiesBasics;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "ventas")
public class VentasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private String nombreCliente;
    
    @ManyToMany
    @JoinTable(
        name = "venta_productos",
        joinColumns = @JoinColumn(name = "idVenta"),
        inverseJoinColumns = @JoinColumn(name = "idProducto")
    )
    private List<ProductoEntity> productos = new ArrayList<>();

    public VentasEntity()
    {
        
    }

    public VentasEntity(Long idVenta, String nombreCliente)
    {
        this.idVenta = idVenta;
        this.nombreCliente = nombreCliente;
    }

    public Long getIdVenta()
    {
        return idVenta;
    }
    
    public String getNombreCliente()
    {
        return nombreCliente;
    }

    public void setIdVenta(Long idVenta)
    {
        this.idVenta = idVenta;
    }
    
    public void setNombreCliente(String nombreCliente)
    {
        this.nombreCliente = nombreCliente;
    }

    public List<ProductoEntity> getProductos()
    {
        return productos;
    }

    public void setProductos(List<ProductoEntity> productos)
    {
        this.productos = productos;
    }

}
