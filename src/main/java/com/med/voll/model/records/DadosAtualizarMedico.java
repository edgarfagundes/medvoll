package com.med.voll.model.records;

import com.med.voll.model.entity.Medico;
import com.med.voll.model.enums.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(@NotNull Long id, @NotNull String nome, @NotNull @Email String email) {

    public DadosAtualizarMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail());
    }


}
