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
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Guilg
 */

public class cadastrarEnfermeiroPanel extends CRUD_JPanel {

    public cadastrarEnfermeiroPanel(CardLayout cl, JPanel container, SistemaClinicas back) {
        super(cl, container, back);
        initComponents();
        loadId();
    }
    
    public void loadId(){
        //carrega o proximo id no campo bloqueado
        idField.setText(Long.toString(Enfermeiro.getcountId()+ 1));
    }
    
    public boolean validar(){
        //valida todos os campos presentes no Jpanel e retorna falso caso algum
        //esteja invalido
        Validador v = new Validador();
        if(!v.validarCampo(nomeField)){
            JOptionPane.showMessageDialog(null, "Nome Invalido");
            return false;
        }
        if(!v.validarCampo(bairroField)){
            JOptionPane.showMessageDialog(null, "Bairro Invalido");
            return false;
        }
        if(!v.validarCampo(telefoneField)){
            JOptionPane.showMessageDialog(null, "Telefone Invalido");
            return false;
        }
        if(!v.validarData(nascimentoField)){
            JOptionPane.showMessageDialog(null, "Data de Nascimento Invalida");
            return false;
        }
        if(!v.validarCampo(estadoField)){
            JOptionPane.showMessageDialog(null, "Estado Invalido");
            return false;
        }
        if(!v.validarCampo(celularField)){
            JOptionPane.showMessageDialog(null, "Celular Invalido");
            return false;
        }
        if(!v.validarCampo(ruaField)){
            JOptionPane.showMessageDialog(null, "Rua Invalida");
            return false;
        }
        if(!v.validarCampo(cidadeField)){
            JOptionPane.showMessageDialog(null, "Cidade Invalida");
            return false;
        }
        if(!v.validarEmail(emailField)){
            JOptionPane.showMessageDialog(null, "Email Invalido");
            return false;
        }
        if(!v.validarNum(numeroField)){
            JOptionPane.showMessageDialog(null, "Numero Invalido");
            return false;
        }
        if(!v.validarNum(CEPFieldl)){
            JOptionPane.showMessageDialog(null, "CEP Invalido");
            return false;
        }
        if(!v.validarCampo(setorField)){
            JOptionPane.showMessageDialog(null, "Setor Invalido");
            return false;
        }
        if(!v.validarNum(chField)){
            JOptionPane.showMessageDialog(null, "Carga Horaria Invalida");
            return false;
        }
        
       return true;
    }
    
    public boolean cadastrar(){
        if(!validar()){
            return false;
        }
            
        
        //populo objeto endereço
        Endereco e = new Endereco(
            ruaField.getText(),
            Integer.parseInt(numeroField.getText()),
            bairroField.getText(),
            cidadeField.getText(),
            estadoField.getText(),
            Integer.parseInt(CEPFieldl.getText()));
        //populo objeto contato
        ContatoTelEmail c = new ContatoTelEmail(
            telefoneField.getText(),
            celularField.getText(),
            emailField.getText());

        //checo o genero selecionado e populo os demais campos
        if(generoComboBox.getSelectedIndex() == 0){
            Enfermeiro enf = new Enfermeiro(
                Long.parseLong(idField.getText()),
                rxComboBox.getSelectedItem() == "Treinado",
                setorField.getText(),
                Integer.parseInt(chField.getText()),
                nomeField.getText(),
                nascimentoField.getDate(),
                e,
                c,
                Genero.MASCULINO);
            getBack().getEnfermeiros().add(enf);

        }
        else{
            Enfermeiro enf = new Enfermeiro(
                Long.parseLong(idField.getText()),
                rxComboBox.getSelectedItem() == "Treinado",
                setorField.getText(),
                Integer.parseInt(chField.getText()),
                nomeField.getText(),
                nascimentoField.getDate(),
                e,
                c,
                Genero.FEMININO);
            getBack().getEnfermeiros().add(enf);
        }
        return true;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastrarEnfermeiro = new javax.swing.JPanel();
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
        CEPFieldl = new javax.swing.JTextField();
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
        salvarBtn = new javax.swing.JButton();

        nomeLabel.setText("Nome");

        nascimentoLabel.setText("Data de Nascimento");

        ruaLabel.setText("Rua");

        numeroLabel.setText("Numero");

        bairroLabel.setText("Bairro");

        estadoLabel.setText("Estado");

        cidadeLabel.setText("Cidade");

        CEPLabel.setText("CEP");

        telefoneLabel.setText("Telefone");

        celularLabel.setText("Celular");

        emailLabel.setText("Email");

        generoLabel.setText("Genero");

        generoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        generoComboBox.setToolTipText("");

        infoGeraisLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoGeraisLabel.setText("Informações Gerais");

        infoEspecificasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoEspecificasLabel.setText("Informações Especificas");

        setorLabel.setText("Setor");

        chLabel.setText("Carga Horaria Semanal");

        idField.setEditable(false);
        idField.setFocusable(false);

        idLabel.setText("Id Enfermeiro");

        rxLabel.setText("Treinado em Raio X?");

        rxComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Treinado", "Não Treinado" }));

        backBtn.setText("<----");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        salvarBtn.setText("Salvar");
        salvarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadastrarEnfermeiroLayout = new javax.swing.GroupLayout(cadastrarEnfermeiro);
        cadastrarEnfermeiro.setLayout(cadastrarEnfermeiroLayout);
        cadastrarEnfermeiroLayout.setHorizontalGroup(
            cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                            .addComponent(chField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(backBtn)))
                .addGap(59, 59, 59)
                .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(idLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rxLabel)
                            .addComponent(rxComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoEspecificasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(infoGeraisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bairroField)
                            .addComponent(estadoField)
                            .addComponent(cidadeField)
                            .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                                .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CEPLabel)
                                    .addComponent(cidadeLabel)
                                    .addComponent(estadoLabel)
                                    .addComponent(bairroLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(CEPFieldl))
                        .addGap(68, 68, 68)
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(telefoneLabel)
                            .addComponent(telefoneField)
                            .addComponent(celularLabel)
                            .addComponent(celularField)
                            .addComponent(emailLabel)
                            .addComponent(emailField)
                            .addComponent(generoLabel)
                            .addComponent(generoComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 170, Short.MAX_VALUE))
                        .addGap(86, 86, 86))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarEnfermeiroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salvarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        cadastrarEnfermeiroLayout.setVerticalGroup(
            cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(infoGeraisLabel))
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(backBtn)))
                .addGap(18, 18, 18)
                .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addComponent(bairroLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(estadoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidadeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CEPLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CEPFieldl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeLabel)
                            .addComponent(telefoneLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                                .addComponent(nascimentoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                                .addComponent(celularLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(celularField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                                .addComponent(ruaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ruaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                                .addComponent(numeroLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                                .addComponent(generoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(47, 47, 47)
                .addComponent(infoEspecificasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addComponent(setorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrarEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addComponent(chLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cadastrarEnfermeiroLayout.createSequentialGroup()
                        .addComponent(rxLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rxComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(salvarBtn)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cadastrarEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cadastrarEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        
        getCl().show(getContainer(),"mainWindow");
        getContainer().remove(this);
    }//GEN-LAST:event_backBtnActionPerformed

    private void salvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtnActionPerformed

        if(cadastrar()){
            getCl().show(getContainer(),"mainWindow");
            getContainer().remove(this);
        }
        
    }//GEN-LAST:event_salvarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CEPFieldl;
    private javax.swing.JLabel CEPLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField bairroField;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JPanel cadastrarEnfermeiro;
    private javax.swing.JTextField celularField;
    private javax.swing.JLabel celularLabel;
    private javax.swing.JTextField chField;
    private javax.swing.JLabel chLabel;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JLabel cidadeLabel;
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
    private javax.swing.JButton salvarBtn;
    private javax.swing.JTextField setorField;
    private javax.swing.JLabel setorLabel;
    private javax.swing.JTextField telefoneField;
    private javax.swing.JLabel telefoneLabel;
    // End of variables declaration//GEN-END:variables
}
