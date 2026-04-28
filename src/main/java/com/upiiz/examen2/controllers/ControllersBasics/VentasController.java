package com.upiiz.examen2.controllers.ControllersBasics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upiiz.examen2.entities.EntitiesBasics.ProductoEntity;
import com.upiiz.examen2.entities.EntitiesBasics.VentasEntity;
import com.upiiz.examen2.services.ServicesBasics.ProductoServiceImpl;
import com.upiiz.examen2.services.ServicesBasics.VentasServiceImpl;

import org.springframework.ui.Model;




@Controller
@RequestMapping("Ventas")
public class VentasController {

    @Autowired
    VentasServiceImpl ventasServiceImpl;

    @Autowired
    ProductoServiceImpl productoServiceImpl;


    //CRUD

    //C Create

    //Mostramos la página con el modelo precargado

    @GetMapping("/MostrarFormularioNombrarClienteCrearVenta")
    public String nombrarClienteCrearVenta(Model model)
    {
        VentasEntity venta = new VentasEntity();
        model.addAttribute("venta",venta);
        return "/Basics/CrearVentaNombre";
    }

    @PostMapping("/CrearVentaNombre")
    public String crearVentaNombre(@ModelAttribute VentasEntity venta)
    {
        VentasEntity ventaGuardada = ventasServiceImpl.crearVenta(venta);
        return "redirect:/Ventas/MostrarFormularioCrearVenta/" + ventaGuardada.getIdVenta();
    }

    @GetMapping("/MostrarFormularioCrearVenta/{idVenta}")
    public String crearVenta(@PathVariable Long idVenta, Model model)
    {
        VentasEntity venta = ventasServiceImpl.getVentaPorId(idVenta);
        model.addAttribute("venta", venta);

        List<ProductoEntity> productosPapeleria = productoServiceImpl.listarProductos();
        model.addAttribute("catalogo", productosPapeleria);

        double total = 0;

        for (ProductoEntity producto : venta.getProductos())
        {
            total+= producto.getCostoUnitarioProducto();
        }

        model.addAttribute("total", total);
        return "Basics/CrearVenta";

    }

    @PostMapping("/AgregarProductoAVenta")
    public String agregarProductoAVenta(@RequestParam Long idVenta, @RequestParam Long idProducto)
    {
        VentasEntity venta = ventasServiceImpl.getVentaPorId(idVenta);
        ProductoEntity producto = productoServiceImpl.getProductoPorId(idProducto);

        venta.getProductos().add(producto);

        ventasServiceImpl.actualizarVenta(venta);

        return "redirect:/Ventas/MostrarFormularioCrearVenta/"+idVenta;
    }

    @PostMapping("/CrearVenta")
    public String crearVenta(@ModelAttribute VentasEntity venta) {
        //TODO: process POST request
        ventasServiceImpl.actualizarVenta(venta);
        return "redirect:/MostrarVentas";
    }
    

    //R Read

    @GetMapping("/MostrarVentas")
    public String mostrarTablaVentas(Model model)
    {
        List<VentasEntity> ventas = ventasServiceImpl.listarVentas();
        model.addAttribute("ventas",ventas);
        return "Basics/TablasVentas";

    }

    //U Update

    @GetMapping("/MostrarFormularioActualizarVenta/{idVenta}")
    public String mostrarFormularioActualizarVenta(@PathVariable Long idVenta, Model model)
    {
        VentasEntity venta = ventasServiceImpl.getVentaPorId(idVenta);
        model.addAttribute("venta", venta);
        return "/Basics/ActualizarProducto";
    }
    
    @PostMapping("/ActualizarProducto")
    public String actualizarProducto(@ModelAttribute VentasEntity venta)
    {
        ventasServiceImpl.actualizarVenta(venta);
        return "redirect:/MostrarTablaVentas";
    }

    //D Delete

    @GetMapping("/BorrarVenta/{idVenta}")
    public String borrarVenta(@PathVariable Long idVenta)
    {
        ventasServiceImpl.borrarVenta(idVenta);
        return "redirect:/home/MostrarInicio";
    }
    
}
