/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

import java.util.Date;

/**
 *
 * @author Guilg
 */
public class Enfermeiro extends AtendenteHospitalar{
    private static long countId=0;
    private long idEnfermeiro;
    private boolean treinadoOpRX;

    public static long getcountId() {
        return countId;
    }

    public static void setIcountId(long id) {
        countId = id;
    }

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
        countId+=1;
    }
    
    
    
}
