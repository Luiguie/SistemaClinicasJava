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
    private String idResponsavel;
    private String nomeResponsavel;

    public Responsavel(String idResponsavel, String nomeResponsavel, String telefone, String celular, String email) {
        super(telefone, celular, email);
        this.idResponsavel = idResponsavel;
        this.nomeResponsavel = nomeResponsavel;
    }
    
    
}
