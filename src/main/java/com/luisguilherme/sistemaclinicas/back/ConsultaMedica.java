/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

/**
 *
 * @author Guilg
 */
public class ConsultaMedica {
    private long idConsulta;
    private long idPaciente;
    private long idMedico;
    private static long countId=0;
    private String exameQueixa;
    private String diagnostico;
    private String prescricao;
    private boolean indicacaoCirurgica;
    
    public static long getcountId() {
        return countId;
    }

    public static void setIcountId(long id) {
        countId = id;
    }
    
    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public String getExameQueixa() {
        return exameQueixa;
    }

    public void setExameQueixa(String exameQueixa) {
        this.exameQueixa = exameQueixa;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public boolean isIndicacaoCirurgica() {
        return indicacaoCirurgica;
    }

    public void setIndicacaoCirurgica(boolean indicacaoCirurgica) {
        this.indicacaoCirurgica = indicacaoCirurgica;
    }

    public ConsultaMedica(long idConsulta, long idPaciente, long idMedico, String exameQueixa, String diagnostico, String prescricao, boolean indicacaoCirurgica) {
        this.idConsulta = idConsulta;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.exameQueixa = exameQueixa;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.indicacaoCirurgica = indicacaoCirurgica;
        countId+=1;
    }
    
    
    
}
