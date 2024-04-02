/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back.front;

import com.luisguilherme.sistemaclinicas.back.ContatoTelEmail;
import com.luisguilherme.sistemaclinicas.back.Endereco;
import com.luisguilherme.sistemaclinicas.back.Enfermeiro;
import com.luisguilherme.sistemaclinicas.back.Genero;
import com.luisguilherme.sistemaclinicas.back.SistemaClinicas;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author souzlui03
 */
public class deletarEnfermeiro extends CRUD_JPanel {

    /**
     * Creates new form deletarEnfermeiro
     */
    public deletarEnfermeiro(CardLayout cl, JPanel container, SistemaClinicas back) {
        super(cl, container, back);
        initComponents();
        listEnfermeiros();
    }
    
    public void loadInfo(int index){
        
        Enfermeiro e = getBack().getEnfermeiros().get(index);
        Endereco end = e.getEndereco();
        ContatoTelEmail cont = e.getContato();
        
        //carrego endereço
        ruaField.setText(end.getRua());
        numeroField.setText(Integer.toString(end.getNumero()));
        bairroField.setText(end.getBairro());
        cidadeField.setText(end.getCidade());
        estadoField.setText(end.getEstado());
        CEPField.setText(Integer.toString(end.getCep()));
        
        //carrego contato
        telefoneField.setText(cont.getTelefone());
        celularField.setText(cont.getCelular());
        emailField.setText(cont.getEmail());
        
        //carrego o resto das informações gerais
        nomeField.setText(e.getNomeCompleto());
        nascimentoField.setDate(e.getDataNascimento());
        if(e.getGenero() == Genero.MASCULINO){
            generoComboBox.setSelectedIndex(0);
        }
        else{
            generoComboBox.setSelectedIndex(1);
        }
        
        //carrego informações especificas
        idField.setText(Long.toString(e.getIdEnfermeiro()));
        setorField.setText(e.getSetor());
        chField.setText(Integer.toString(e.getChSemanal()));
        if(e.isTreinadoOpRX()){
            rxComboBox.setSelectedIndex(0);
        }
        else{
            rxComboBox.setSelectedIndex(1);
        }       
            
    }
    
    public void listEnfermeiros(){
        //carrega opções no comboBox
        for(Enfermeiro e : getBack().getEnfermeiros()){
            selectionComboBox.addItem(e.getNomeCompleto());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deletarEnfermeiro = new javax.swing.JPanel();
        nomeField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        nascimentoLabel = new javax.swing.JLabel();
        ruaLabel = new javax.swing.JLabel();
        ruaField = new javax.swing.JTextField();
        numeroLabel = new javax.swing.JLabel();
        numeroField = new javax.swing.JTextField();
        bairroLabel = new javax.swing.JLabel();
        estadoField = new javax.swing.JTextField();
        estadoLabel = new javax.swing.JLabel();
        cidadeField = new javax.swing.JTextField();
        cidadeLabel = new javax.swing.JLabel();
        nascimentoField = new com.toedter.calendar.JDateChooser();
        bairroField = new javax.swing.JTextField();
        CEPField = new javax.swing.JTextField();
        CEPLabel = new javax.swing.JLabel();
        telefoneField = new javax.swing.JTextField();
        telefoneLabel = new javax.swing.JLabel();
        celularField = new javax.swing.JTextField();
        celularLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        generoLabel = new javax.swing.JLabel();
        generoComboBox = new javax.swing.JComboBox<>();
        infoGeraisLabel = new javax.swing.JLabel();
        infoEspecificasLabel = new javax.swing.JLabel();
        setorLabel = new javax.swing.JLabel();
        setorField = new javax.swing.JTextField();
        chField = new javax.swing.JTextField();
        chLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        rxLabel = new javax.swing.JLabel();
        rxComboBox = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();
        selectionComboBox = new javax.swing.JComboBox<>();
        selectionLabel = new javax.swing.JLabel();
        deletarBtn = new javax.swing.JButton();

        nomeField.setEditable(false);
        nomeField.setFocusable(false);

        nomeLabel.setText("Nome");

        nascimentoLabel.setText("Data de Nascimento");

        ruaLabel.setText("Rua");

        ruaField.setEditable(false);
        ruaField.setFocusable(false);

        numeroLabel.setText("Numero");

        numeroField.setEditable(false);
        numeroField.setFocusable(false);

        bairroLabel.setText("Bairro");

        estadoField.setEditable(false);
        estadoField.setFocusable(false);

        estadoLabel.setText("Estado");

        cidadeField.setEditable(false);
        cidadeField.setFocusable(false);

        cidadeLabel.setText("Cidade");

        nascimentoField.setEnabled(false);

        bairroField.setEditable(false);
        bairroField.setFocusable(false);

        CEPField.setEditable(false);
        CEPField.setFocusable(false);

        CEPLabel.setText("CEP");

        telefoneField.setEditable(false);
        telefoneField.setFocusable(false);

        telefoneLabel.setText("Telefone");

        celularField.setEditable(false);
        celularField.setFocusable(false);

        celularLabel.setText("Celular");

        emailLabel.setText("Email");

        emailField.setEditable(false);
        emailField.setFocusable(false);

        generoLabel.setText("Genero");

        generoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        generoComboBox.setToolTipText("");
        generoComboBox.setEnabled(false);
        generoComboBox.setFocusable(false);

        infoGeraisLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoGeraisLabel.setText("Informações Gerais");

        infoEspecificasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoEspecificasLabel.setText("Informações Especificas");

        setorLabel.setText("Setor");

        setorField.setEditable(false);
        setorField.setFocusable(false);

        chField.setEditable(false);
        chField.setFocusable(false);

        chLabel.setText("Carga Horaria Semanal");

        idField.setEditable(false);
        idField.setFocusable(false);

        idLabel.setText("Id Enfermeiro");

        rxLabel.setText("Treinado em Raio X?");

        rxComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Treinado", "Não Treinado" }));
        rxComboBox.setEnabled(false);
        rxComboBox.setFocusable(false);

        backBtn.setText("<----");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        selectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionComboBoxActionPerformed(evt);
            }
        });

        selectionLabel.setText("Enfermeiro");

        deletarBtn.setText("Deletar");
        deletarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletarEnfermeiroLayout = new javax.swing.GroupLayout(deletarEnfermeiro);
        deletarEnfermeiro.setLayout(deletarEnfermeiroLayout);
        deletarEnfermeiroLayout.setHorizontalGroup(
            deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletarEnfermeiroLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(backBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(numeroLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ruaLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nascimentoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nomeLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ruaField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numeroField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nascimentoField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nomeField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(setorLabel)
                    .addComponent(setorField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chLabel)
                    .addComponent(chField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                        .addComponent(infoEspecificasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                        .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel)
                                    .addComponent(rxLabel)
                                    .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(idField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rxComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 170, Short.MAX_VALUE))
                                    .addComponent(CEPLabel)
                                    .addComponent(estadoLabel)
                                    .addComponent(cidadeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletarEnfermeiroLayout.createSequentialGroup()
                                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cidadeField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(estadoField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CEPField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(infoGeraisLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(bairroField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, deletarEnfermeiroLayout.createSequentialGroup()
                                        .addComponent(bairroLabel)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(68, 68, 68)))
                        .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(telefoneLabel)
                            .addComponent(telefoneField)
                            .addComponent(celularLabel)
                            .addComponent(celularField)
                            .addComponent(emailLabel)
                            .addComponent(emailField)
                            .addComponent(generoComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 170, Short.MAX_VALUE)
                            .addComponent(generoLabel)
                            .addComponent(deletarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(86, 86, 86))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletarEnfermeiroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectionLabel)
                    .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(231, 231, 231))
        );
        deletarEnfermeiroLayout.setVerticalGroup(
            deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(backBtn)
                .addGap(32, 32, 32)
                .addComponent(selectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                        .addComponent(infoGeraisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletarEnfermeiroLayout.createSequentialGroup()
                                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                                        .addComponent(telefoneLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                                        .addComponent(bairroLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletarEnfermeiroLayout.createSequentialGroup()
                                .addComponent(celularLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(celularField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nascimentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaLabel)
                    .addComponent(cidadeLabel)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroLabel)
                    .addComponent(CEPLabel)
                    .addComponent(generoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CEPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(infoEspecificasLabel)
                .addGap(9, 9, 9)
                .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(deletarEnfermeiroLayout.createSequentialGroup()
                        .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(setorLabel)
                            .addComponent(idLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(deletarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chLabel)
                            .addComponent(rxLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rxComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addComponent(chField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(deletarBtn)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(deletarEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(deletarEnfermeiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        getCl().show(getContainer(),"mainWindow");
    }//GEN-LAST:event_backBtnActionPerformed

    private void selectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionComboBoxActionPerformed
        //mando o indice selecionado e carrego as informações
        int index = selectionComboBox.getSelectedIndex();
        loadInfo(index);
    }//GEN-LAST:event_selectionComboBoxActionPerformed

    private void deletarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarBtnActionPerformed
        //deleta e volta para a mainWindow
        int index = selectionComboBox.getSelectedIndex();
        getBack().getEnfermeiros().remove(index);
        getCl().show(getContainer(),"mainWindow");
    }//GEN-LAST:event_deletarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CEPField;
    private javax.swing.JLabel CEPLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField bairroField;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JTextField celularField;
    private javax.swing.JLabel celularLabel;
    private javax.swing.JTextField chField;
    private javax.swing.JLabel chLabel;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JButton deletarBtn;
    private javax.swing.JPanel deletarEnfermeiro;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField estadoField;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JComboBox<String> generoComboBox;
    private javax.swing.JLabel generoLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel infoEspecificasLabel;
    private javax.swing.JLabel infoGeraisLabel;
    private com.toedter.calendar.JDateChooser nascimentoField;
    private javax.swing.JLabel nascimentoLabel;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField numeroField;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JTextField ruaField;
    private javax.swing.JLabel ruaLabel;
    private javax.swing.JComboBox<String> rxComboBox;
    private javax.swing.JLabel rxLabel;
    private javax.swing.JComboBox<String> selectionComboBox;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.JTextField setorField;
    private javax.swing.JLabel setorLabel;
    private javax.swing.JTextField telefoneField;
    private javax.swing.JLabel telefoneLabel;
    // End of variables declaration//GEN-END:variables
}
