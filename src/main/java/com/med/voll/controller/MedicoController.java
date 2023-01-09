package com.med.voll.controller;

import com.med.voll.model.entity.Medico;
import com.med.voll.model.records.MedicoRecord;
import com.med.voll.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping("/cadastro")
    public Medico cadastroMedico(@RequestBody MedicoRecord medico){
        return medicoRepository.save(new Medico(medico));
    }
}

