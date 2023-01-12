package com.med.voll.model.records;

import com.med.voll.model.entity.Medico;
import com.med.voll.model.enums.Especialidade;

public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
