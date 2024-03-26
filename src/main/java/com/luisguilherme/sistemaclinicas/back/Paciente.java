/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

import java.time.LocalDate;

/**
 *
 * @author Guilg
 */
import java.util.ArrayList;
public class Paciente extends DadoPessoal{
    private long idPaciente;
    private int idade;
    private LocalDate dataCadastro;
    private String obsGeral;
    private ArrayList<ConsultaMedica> historicoConsultasMedicas = new ArrayList<ConsultaMedica>();
    private ArrayList<Responsavel> contatoResponsavel = new ArrayList<Responsavel>();

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObsGeral() {
        return obsGeral;
    }

    public void setObsGeral(String obsGeral) {
        this.obsGeral = obsGeral;
    }

    public ArrayList<ConsultaMedica> getHistoricoConsultasMedicas() {
        return historicoConsultasMedicas;
    }

    public void setHistoricoConsultasMedicas(ArrayList<ConsultaMedica> historicoConsultasMedicas) {
        this.historicoConsultasMedicas = historicoConsultasMedicas;
    }

    public ArrayList<Responsavel> getContatoResponsavel() {
        return contatoResponsavel;
    }

    public void setContatoResponsavel(ArrayList<Responsavel> contatoResponsavel) {
        this.contatoResponsavel = contatoResponsavel;
    }
    
}
