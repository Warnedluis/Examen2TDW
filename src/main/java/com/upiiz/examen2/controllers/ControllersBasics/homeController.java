package com.upiiz.examen2.controllers.ControllersBasics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import com.upiiz.examen2.repositories.RepositoriesBasics.ProductoRepository;
import com.upiiz.examen2.repositories.RepositoriesBasics.VentaRepository;
import com.upiiz.examen2.repositories.RepositoriesSesion.UsuarioRepository;


@Controller
@RequestMapping("/home")
public class homeController {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private VentaRepository ventaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
    @GetMapping("/MostrarInicio")
    public String mostrarInicio(Model model) {
        // Agregar estadísticas al modelo
        model.addAttribute("totalProductos", productoRepository.count());
        model.addAttribute("totalVentas", ventaRepository.count());
        model.addAttribute("totalUsuarios", usuarioRepository.count());
        return "index";
    }
    
    
}
