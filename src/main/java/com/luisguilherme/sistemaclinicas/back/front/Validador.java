/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back.front;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author souzlui03
 */
public class Validador {
    public boolean validarCampo(JTextField f){
        //checa se o campo está vazio e retorna false caso esteja
        return !f.getText().equals("");
        
    }
    
    public boolean validarCampo(JTextArea f){
        //checa se o campo está vazio e retorna false caso esteja
        return !f.getText().equals("");
        
    }
    
    public boolean validarNum(JTextField f){
        if(!validarCampo(f)){
            return false;
        }
        try{
            //checa se o numero é um inteiro positivo;
            int n = Integer.parseInt(f.getText());
            
            return n>=0;
        }
        catch(Exception e){
            return false;
        }
        
    }
    public boolean validarEmail(JTextField f){
        if(!validarCampo(f)){
            return false;
        }
        return f.getText().contains("@");
    }
    
    public boolean validarData(JDateChooser dc){
        
       
        try{
            dc.getDate().getTime();
            return true;
        }
        catch(Exception e){
            return false;
        }
            
        
    }
}
