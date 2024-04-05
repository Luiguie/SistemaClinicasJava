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
    
}
