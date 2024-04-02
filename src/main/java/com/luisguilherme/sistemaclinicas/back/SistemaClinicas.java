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
    
    
    
}
