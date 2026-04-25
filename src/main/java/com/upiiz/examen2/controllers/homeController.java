package com.upiiz.examen2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/home")
public class homeController {


    @GetMapping("/MostrarInicio")
    public String mostrarInicio() {
        return "index";
    }
    
    
}
