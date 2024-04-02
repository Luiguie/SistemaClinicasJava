/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Guilg
 */
public class Enfermeiro extends AtendenteHospitalar{
    private long idEnfermeiro;
    private boolean treinadoOpRX;

    public long getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(long idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public boolean isTreinadoOpRX() {
        return treinadoOpRX;
    }

    public void setTreinadoOpRX(boolean treinadoOpRX) {
        this.treinadoOpRX = treinadoOpRX;
    }

    public Enfermeiro(long idEnfermeiro, boolean treinadoOpRX, String setor, int chSemanal, String nomeCompleto, Date dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        super(setor, chSemanal, nomeCompleto, dataNascimento, endereco, contato, genero);
        this.idEnfermeiro = idEnfermeiro;
        this.treinadoOpRX = treinadoOpRX;
    }
    
    
    
}
