package com.escola.controller;

import com.escola.entity.Usuario;
import com.escola.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
    @PostMapping("/register")
    public String registrar(@ModelAttribute Usuario usuario) {
        try {
            usuarioService.registrar(usuario);
            return "redirect:/login?success=true";
        } catch (Exception e) {
            return "redirect:/register?error=" + e.getMessage();
        }
    }

}
