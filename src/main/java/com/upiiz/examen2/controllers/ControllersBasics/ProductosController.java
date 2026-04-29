package com.upiiz.examen2.controllers.ControllersBasics;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.upiiz.examen2.entities.EntitiesBasics.ProductoEntity;
import com.upiiz.examen2.services.ServicesBasics.ProductoServiceImpl;

@RequestMapping("/Productos")
@Controller
public class ProductosController
{

    @Autowired
    ProductoServiceImpl productoServiceImpl;


    //CRUD 

    //C Create

    @GetMapping("/MostrarFormularioCrearProducto")
    public String mostrarFormularioCrearProducto(Model model)
    {
        ProductoEntity producto = new ProductoEntity();
        model.addAttribute("producto", producto);
        return "Basics/CrearProducto";
    }

    @PostMapping("/CrearProducto")
    public String crearProducto(@ModelAttribute ProductoEntity producto)
    {
        productoServiceImpl.crearProducto(producto);
        return "redirect:/home/MostrarInicio";
    }

    //R Read
    @GetMapping("/MostrarTablaProductos")
    public String mostrarTablaProductos(Model model)
    {
        List<ProductoEntity> productos = productoServiceImpl.listarProductos();
        model.addAttribute("productos", productos);
        return "Basics/TablasProductos";
    }

    //U Update

    @GetMapping("/MostrarFormularioActualizarProducto/{idProducto}")
    public String actualizarProductos(@PathVariable Long idProducto, Model model)
    {
        ProductoEntity producto = productoServiceImpl.getProductoPorId(idProducto);
        model.addAttribute("producto", producto);
        return "Basics/ActualizarProducto";
    }

    @PostMapping("/ActualizarProducto")
    public String actualizarProducto(@ModelAttribute ProductoEntity producto)
    {
        productoServiceImpl.actualizarProducto(producto);
        return "redirect:/home/MostrarInicio";
    }


    //D Delete

    @GetMapping("/EliminarProducto/{idProducto}")
    public String borrarProducto(@PathVariable Long idProducto)
    {
        productoServiceImpl.borrarProducto(idProducto);
        return "redirect:/home/MostrarInicio";
    }
}