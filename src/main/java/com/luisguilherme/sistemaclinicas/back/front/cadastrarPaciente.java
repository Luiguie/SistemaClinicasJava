/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back.front;

import com.luisguilherme.sistemaclinicas.back.ContatoTelEmail;
import com.luisguilherme.sistemaclinicas.back.Endereco;
import com.luisguilherme.sistemaclinicas.back.Genero;
import com.luisguilherme.sistemaclinicas.back.Paciente;
import com.luisguilherme.sistemaclinicas.back.Responsavel;
import com.luisguilherme.sistemaclinicas.back.SistemaClinicas;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author souzlui03
 */
public class cadastrarPaciente extends CRUD_JPanel {

    /**
     * Creates new form cadastrarPaciente
     */
    public cadastrarPaciente(CardLayout cl, JPanel container, SistemaClinicas back) {
        super(cl, container, back);
        initComponents();
        loadId();
        loadResponsaveis();
    }
    
    public void loadId(){
        //carrega o proximo id no campo bloqueado
        idField.setText(Long.toString(Paciente.getcountId()+ 1));
    }
    
    @Override
    public void loadResponsaveis(){
        listResponsaveis.removeAll();
        DefaultListModel<String> model = new DefaultListModel<>();
        for(Responsavel r : getBack().getTempResponsaveis()){
            model.addElement(r.getNomeResponsavel());  
        }
        listResponsaveis.setModel(model);
    }
    
    public boolean validar(){
        //valida todos os campos presentes no Jpanel e retorna falso caso algum
        //esteja invalido
        if(!validarCampo(ruaField))
            return false;
        if(!validarNum(numeroField))
            return false;
        if(!validarCampo(bairroField))
            return false;
        if(!validarCampo(cidadeField))
            return false;
        if(!validarCampo(estadoField))
            return false;
        if(!validarNum(CEPFieldl))
            return false;
        if(!validarCampo(telefoneField))
            return false;
        if(!validarCampo(celularField))
            return false;
        if(!validarEmail(emailField))
            return false;
        //if(!validarData(nascimentoField))
        //    return false;
        if(!validarCampo(nomeField))
            return false;
        if(!validarCampo(obsTextArea))
            return false;
        
       return true;
    }
    
    public ArrayList<Responsavel> copyArrResp(ArrayList<Responsavel> arr){
        ArrayList<Responsavel> temp = new ArrayList<Responsavel>();
        for(Responsavel r : arr){
            temp.add(r);
        }
        return temp;
    }
    
    public boolean cadastrar(){
        if(!validar()){
            JOptionPane.showMessageDialog(null, "Campo(s) Invalido(s)");
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

        //checo o genero selecionado e populo os demais 
        //copio o arraylist em um novo para evitar referencias de memoria
        ArrayList<Responsavel> temp = copyArrResp(getBack().getTempResponsaveis());
        
        if(generoComboBox.getSelectedIndex() == 0){
            Paciente pac = new Paciente(
                Long.parseLong(idField.getText()),
                obsTextArea.getText(),
                nomeField.getText(),
                nascimentoField.getDate(),
                e,
                c,
                Genero.MASCULINO,
                temp);
            getBack().getPacientes().add(pac);

        }
        else{
            Paciente pac = new Paciente(
                Long.parseLong(idField.getText()),
                obsTextArea.getText(),
                nomeField.getText(),
                nascimentoField.getDate(),
                e,
                c,
                Genero.FEMININO,
                temp);
            getBack().getPacientes().add(pac);
        }
        getBack().getTempResponsaveis().clear();
        return true;
    }
    public void deletarResponsavel(int index){
        getBack().getTempResponsaveis().remove(index);
        loadResponsaveis();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastrarPaciente = new javax.swing.JPanel();
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
        idField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        salvarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        obsTextArea = new javax.swing.JTextArea();
        obsLabel = new javax.swing.JLabel();
        infoEspecificasLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listResponsaveis = new javax.swing.JList<>();
        addRespBtn = new javax.swing.JButton();
        editRespBtn = new javax.swing.JButton();
        deleteRespBtn = new javax.swing.JButton();
        consRespBtn = new javax.swing.JButton();

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

        idField.setEditable(false);
        idField.setFocusable(false);

        idLabel.setText("Id Paciente");

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

        obsTextArea.setColumns(20);
        obsTextArea.setRows(5);
        jScrollPane1.setViewportView(obsTextArea);

        obsLabel.setText("Observações");

        infoEspecificasLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoEspecificasLabel1.setText("Responsaveis");

        jScrollPane2.setViewportView(listResponsaveis);

        addRespBtn.setText("➕");
        addRespBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRespBtnActionPerformed(evt);
            }
        });

        editRespBtn.setText("✎");
        editRespBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRespBtnActionPerformed(evt);
            }
        });

        deleteRespBtn.setText("X");
        deleteRespBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRespBtnActionPerformed(evt);
            }
        });

        consRespBtn.setText("🔍");
        consRespBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consRespBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadastrarPacienteLayout = new javax.swing.GroupLayout(cadastrarPaciente);
        cadastrarPaciente.setLayout(cadastrarPacienteLayout);
        cadastrarPacienteLayout.setHorizontalGroup(
            cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarPacienteLayout.createSequentialGroup()
                .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarPacienteLayout.createSequentialGroup()
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(backBtn))
                            .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(numeroLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ruaLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nascimentoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numeroField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nascimentoField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(nomeField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ruaField, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(94, 94, 94)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoGeraisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CEPFieldl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(cidadeField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(estadoField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CEPLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cidadeLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(estadoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bairroLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bairroField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(infoEspecificasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(obsLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addRespBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editRespBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteRespBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consRespBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(salvarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarPacienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telefoneLabel)
                                .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(celularLabel)
                                .addComponent(celularField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailLabel)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(generoLabel)
                                .addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(infoEspecificasLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))))
        );
        cadastrarPacienteLayout.setVerticalGroup(
            cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(infoGeraisLabel))
                    .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backBtn)
                            .addComponent(salvarBtn))))
                .addGap(18, 18, 18)
                .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                        .addComponent(bairroLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estadoLabel)
                            .addComponent(celularLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(celularField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cidadeLabel)
                            .addComponent(emailLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CEPLabel)
                            .addComponent(generoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CEPFieldl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefoneLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nascimentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ruaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ruaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(infoEspecificasLabel)
                .addGap(18, 18, 18)
                .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(infoEspecificasLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(obsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(cadastrarPacienteLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(addRespBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consRespBtn)
                        .addGap(1, 1, 1)
                        .addComponent(editRespBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteRespBtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(cadastrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cadastrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtnActionPerformed

        if(cadastrar()){
            getCl().show(getContainer(),"mainWindow");
        }
    }//GEN-LAST:event_salvarBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        getBack().getTempResponsaveis().clear();
        getCl().show(getContainer(),"mainWindow");
    }//GEN-LAST:event_backBtnActionPerformed

    private void addRespBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRespBtnActionPerformed
        cadastrarResponsavel panel = new cadastrarResponsavel(getCl(), getContainer(), getBack(),"cadastraPaciente",this);
        getContainer().add(panel, "cadastrarResponsavel");
        getCl().show(getContainer(), "cadastrarResponsavel");
    }//GEN-LAST:event_addRespBtnActionPerformed

    private void deleteRespBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRespBtnActionPerformed
        if(!listResponsaveis.isSelectionEmpty()){
            int index = listResponsaveis.getSelectedIndex();
            deletarResponsavel(index);
        }
    }//GEN-LAST:event_deleteRespBtnActionPerformed

    private void consRespBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consRespBtnActionPerformed
        if(!listResponsaveis.isSelectionEmpty()){
            int index = listResponsaveis.getSelectedIndex();
            Responsavel r = getBack().getTempResponsaveis().get(index);
            
            consultarResponsavel panel = new consultarResponsavel(getCl(), getContainer(), getBack(),"cadastraPaciente",r);
            getContainer().add(panel, "consultarResponsavel");
            getCl().show(getContainer(), "consultarResponsavel");
        
        }
    }//GEN-LAST:event_consRespBtnActionPerformed

    private void editRespBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRespBtnActionPerformed
        if(!listResponsaveis.isSelectionEmpty()){
            int index = listResponsaveis.getSelectedIndex();
            Responsavel r = getBack().getTempResponsaveis().get(index);
            
            editarResponsavel panel = new editarResponsavel(getCl(), getContainer(), getBack(),"cadastraPaciente",this,r);
            getContainer().add(panel, "editarResponsavel");
            getCl().show(getContainer(), "editarResponsavel");
        
        }
    }//GEN-LAST:event_editRespBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CEPFieldl;
    private javax.swing.JLabel CEPLabel;
    private javax.swing.JButton addRespBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField bairroField;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JPanel cadastrarPaciente;
    private javax.swing.JTextField celularField;
    private javax.swing.JLabel celularLabel;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JButton consRespBtn;
    private javax.swing.JButton deleteRespBtn;
    private javax.swing.JButton editRespBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField estadoField;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JComboBox<String> generoComboBox;
    private javax.swing.JLabel generoLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel infoEspecificasLabel;
    private javax.swing.JLabel infoEspecificasLabel1;
    private javax.swing.JLabel infoGeraisLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listResponsaveis;
    private com.toedter.calendar.JDateChooser nascimentoField;
    private javax.swing.JLabel nascimentoLabel;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField numeroField;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JLabel obsLabel;
    private javax.swing.JTextArea obsTextArea;
    private javax.swing.JTextField ruaField;
    private javax.swing.JLabel ruaLabel;
    private javax.swing.JButton salvarBtn;
    private javax.swing.JTextField telefoneField;
    private javax.swing.JLabel telefoneLabel;
    // End of variables declaration//GEN-END:variables
}
