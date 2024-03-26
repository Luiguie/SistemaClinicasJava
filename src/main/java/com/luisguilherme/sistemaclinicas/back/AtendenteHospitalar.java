/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

/**
 *
 * @author Guilg
 */
public class AtendenteHospitalar extends DadoPessoal{
    private String setor;
    private int chSemanal;
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getChSemanal() {
        return chSemanal;
    }

    public void setChSemanal(int chSemanal) {
        this.chSemanal = chSemanal;
    }
    
}
