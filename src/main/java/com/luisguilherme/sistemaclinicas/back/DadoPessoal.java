/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

/**
 *
 * @author Guilg
 */

import java.time.LocalDate;
public class DadoPessoal {
    
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private ContatoTelEmail contato;
    private Genero genero;
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ContatoTelEmail getContato() {
        return contato;
    }

    public void setContato(ContatoTelEmail contato) {
        this.contato = contato;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public DadoPessoal(String nomeCompleto, LocalDate dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contato = contato;
        this.genero = genero;
    }
    
    
    
    
    
}
