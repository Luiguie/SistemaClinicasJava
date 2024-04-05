/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back.front;

import com.luisguilherme.sistemaclinicas.back.SistemaClinicas;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author souzlui03
 */
public class CRUD_JPanel extends javax.swing.JPanel{
    private CardLayout cl;
    private javax.swing.JPanel container;
    private SistemaClinicas back;
    
    public CardLayout getCl() {
        return cl;
    }

    public void setCl(CardLayout cl) {
        this.cl = cl;
    }

    public JPanel getContainer() {
        return container;
    }

    public void setContainer(JPanel container) {
        this.container = container;
    }
    
    public SistemaClinicas getBack() {
        return back;
    }

    public void setBack(SistemaClinicas back) {
        this.back = back;
    }
    
    public void loadResponsaveis(){
        
    }
    
    public CRUD_JPanel(CardLayout cl, JPanel container, SistemaClinicas back) {
        this.cl = cl;
        this.container = container;
        this.back = back;
    }
    
    
}
