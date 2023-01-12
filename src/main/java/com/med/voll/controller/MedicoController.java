package com.med.voll.controller;

import com.med.voll.model.entity.Medico;
import com.med.voll.model.records.DadosAtualizarMedico;
import com.med.voll.model.records.DadosListagemMedico;
import com.med.voll.model.records.MedicoRecord;
import com.med.voll.model.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public Medico cadastroMedico(@RequestBody @Valid MedicoRecord medico){
        new ResponseEntity<>(HttpStatus.CREATED);
        return medicoRepository.save(new Medico(medico));

    }

    @GetMapping
    public Page<DadosListagemMedico> listarTodos(@PageableDefault(sort = "nome", size = 3) Pageable pageable) {
        new ResponseEntity<>(HttpStatus.FOUND);
        return medicoRepository.findAll(pageable).map(DadosListagemMedico::new);

    }

    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        new ResponseEntity<>(HttpStatus.FOUND);
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PostMapping("update/{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarMedico(dados);
        new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("delete/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        new ResponseEntity<>(HttpStatus.ACCEPTED);
        medicoRepository.deleteById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }


}

