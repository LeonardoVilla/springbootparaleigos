package com.escola.service;

import com.escola.entity.Aluno;
import com.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    public List<Aluno> findAll() {
        return alunoRepository.findByAtivoTrue();
    }
    
    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }
    
    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()) {
            Aluno a = aluno.get();
            a.setNome(alunoAtualizado.getNome());
            a.setEmail(alunoAtualizado.getEmail());
            a.setMatricula(alunoAtualizado.getMatricula());
            a.setDataNascimento(alunoAtualizado.getDataNascimento());
            a.setTelefone(alunoAtualizado.getTelefone());
            a.setEndereco(alunoAtualizado.getEndereco());
            return alunoRepository.save(a);
        }
        throw new RuntimeException("Aluno não encontrado");
    }
    
    public void deletar(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()) {
            Aluno a = aluno.get();
            a.setAtivo(false);
            alunoRepository.save(a);
        }
    }
    
    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

}
