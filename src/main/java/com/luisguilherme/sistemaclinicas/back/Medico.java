/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

/**
 *
 * @author Guilg
 */
import java.util.ArrayList;
import java.util.Date;
public class Medico extends AtendenteHospitalar{
    private long idMedico;
    private static long countId=0;
    private int numeroCRM;
    private ArrayList<String> areasEspecialidade = new ArrayList<String>();
    private boolean cirurgiao;
    
    public static long getcountId() {
        return countId;
    }

    public static void setIcountId(long id) {
        countId = id;
    }
    
    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public int getNumeroCRM() {
        return numeroCRM;
    }

    public void setNumeroCRM(int numeroCRM) {
        this.numeroCRM = numeroCRM;
    }

    public ArrayList<String> getAreasEspecialidade() {
        return areasEspecialidade;
    }

    public void setAreasEspecialidade(String areas) {
        areasEspecialidade.clear();
        String[] str = areas.split("[,]",0);
        for(String area : str){
            areasEspecialidade.add(area);
        }
        
    }

    public boolean isCirurgiao() {
        return cirurgiao;
    }

    public void setCirurgiao(boolean cirurgiao) {
        this.cirurgiao = cirurgiao;
    }

    public Medico(
            long idMedico, int numeroCRM, boolean cirurgiao, String setor, 
            int chSemanal, String nomeCompleto, Date dataNascimento, 
            Endereco endereco, ContatoTelEmail contato, Genero genero,
            String areas) 
    {
        super(setor, chSemanal, nomeCompleto, dataNascimento, endereco, contato, genero);
        this.idMedico = idMedico;
        this.numeroCRM = numeroCRM;
        this.cirurgiao = cirurgiao;
        setAreasEspecialidade(areas);
        countId+=1;
    }
    
}
