/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.luisguilherme.sistemaclinicas.back;

import java.util.ArrayList;

/**
 *
 * @author Guilg
 */
public class SistemaClinicas {
    
    private ArrayList<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
    private ArrayList<Medico> medicos = new ArrayList<Medico>();
    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    private ArrayList<Responsavel> tempResponsaveis = new ArrayList<Responsavel>();
    
    private ExportarExcel exportadorExcel = new ExportarExcel(medicos, pacientes, enfermeiros);
    private ImportarExcel importadorExcel = new ImportarExcel(this);
    
    public ArrayList<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(ArrayList<Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Responsavel> getTempResponsaveis() {
        return tempResponsaveis;
    }

    public void setTempResponsaveis(ArrayList<Responsavel> tempResponsaveis) {
        this.tempResponsaveis = tempResponsaveis;
    }

    public ExportarExcel getExportadorExcel() {
        return exportadorExcel;
    }

    public void setExportadorExcel(ExportarExcel exportadorExcel) {
        this.exportadorExcel = exportadorExcel;
    }

    public ImportarExcel getImportadorExcel() {
        return importadorExcel;
    }

    public void setImportadorExcel(ImportarExcel importadorExcel) {
        this.importadorExcel = importadorExcel;
    }
    
    
    
    
}
