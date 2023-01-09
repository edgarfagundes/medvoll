package com.med.voll.model.records;

import com.med.voll.model.enums.Especialidade;

public record MedicoRecord(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
