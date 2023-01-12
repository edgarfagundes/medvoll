package com.med.voll.model.entity;

import com.med.voll.model.enums.Especialidade;
import com.med.voll.model.records.DadosAtualizarMedico;
import com.med.voll.model.records.MedicoRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends IdGenerator{

    private String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo = true;

    public Medico(MedicoRecord medico) {
        this.nome = medico.nome();
        this.email = medico.email();
        this.crm = medico.crm();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(medico.endereco());
    }

    public void atualizarMedico(DadosAtualizarMedico dados){
        this.setId(dados.id()) ;
        this.nome = dados.nome();
        this.email = dados.email();
    }

    public void excluir() {
        this.ativo = false;
    }
}
