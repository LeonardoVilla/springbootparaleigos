package com.escola.controller;

import com.escola.entity.Aluno;
import com.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.findAll());
        return "alunos/listar";
    }
    
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/form";
    }
    
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Aluno> aluno = alunoService.findById(id);
        if (aluno.isPresent()) {
            model.addAttribute("aluno", aluno.get());
            return "alunos/form";
        }
        return "redirect:/alunos";
    }
    
    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute Aluno aluno) {
        alunoService.atualizar(id, aluno);
        return "redirect:/alunos";
    }
    
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return "redirect:/alunos";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam String nome, Model model) {
        model.addAttribute("alunos", alunoService.buscarPorNome(nome));
        return "alunos/listar";
    }

}
