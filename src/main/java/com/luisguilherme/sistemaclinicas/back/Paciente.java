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
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Paciente extends DadoPessoal{
    
    private long idPaciente;
    private static long countId=0;
    private int idade;
    private Date dataCadastro;
    private String obsGeral;
    private ArrayList<ConsultaMedica> historicoConsultasMedicas = new ArrayList<ConsultaMedica>();
    private ArrayList<Responsavel> contatoResponsavel = new ArrayList<Responsavel>();
    
    public static long getcountId() {
        return countId;
    }

    public static void setIcountId(long id) {
        countId = id;
    }
    
    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(Date dataNascimento) {
        
        long dif = Math.abs(dataCadastro.getTime() - dataNascimento.getTime());
        long days = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
        idade = (int) (days/365);
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
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

    public Paciente(long idPaciente, String obsGeral, String nomeCompleto, 
            Date dataNascimento, Endereco endereco, 
            ContatoTelEmail contato, Genero genero, ArrayList<Responsavel> contatoResponsavel) {
        super(nomeCompleto, dataNascimento, endereco, contato, genero);
        //inicializa data com a data atual
        this.dataCadastro = new Date();
        this.idPaciente = idPaciente;
        setIdade(dataNascimento);
        this.obsGeral = obsGeral;
        this.contatoResponsavel = contatoResponsavel;
        countId+=1;
    }
    
    
    
}
