/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

/**
 *
 * @author Guilg
 */
public class Responsavel extends ContatoTelEmail{
    private long idResponsavel;
    private static long countId=0;
    private String nomeResponsavel;
    
    public static long getcountId() {
        return countId;
    }

    public static void setIcountId(long id) {
        countId = id;
    }

    public long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    
    
    
    //ele por algum motivo HERDA de contato no UML, então tenho que passar atributo a atributo
    public Responsavel(long idResponsavel, String nomeResponsavel, String telefone, String celular, String email) {
        super(telefone, celular, email);
        this.idResponsavel = idResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        countId+=1;
    }
    
    
}
