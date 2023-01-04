package com.med.voll.model.entity.records;

import com.med.voll.model.entity.enums.Especialidade;

public record MedicoRecord(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
