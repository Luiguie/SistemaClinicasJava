/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back.front;

import com.luisguilherme.sistemaclinicas.back.ConsultaMedica;
import com.luisguilherme.sistemaclinicas.back.Medico;
import com.luisguilherme.sistemaclinicas.back.Paciente;
import com.luisguilherme.sistemaclinicas.back.SistemaClinicas;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author souzlui03
 */
public class editarConsultaMed extends CRUD_JPanel {

    /**
     * Creates new form editarConsultaMed
     */
    private Paciente pacSelecionado;
    public editarConsultaMed(CardLayout cl, JPanel container, SistemaClinicas back) {
        super(cl, container, back);
        initComponents();
        listPacientes(selecPacienteComboBox);
    }
    
    public Paciente getPacSelecionado() {
        return pacSelecionado;
    }

    public void setPacSelecionado(Paciente pacSelecionado) {
        this.pacSelecionado = pacSelecionado;
    }
    
    public void listPacientes(JComboBox cb){
        //carrega opções no comboBox
        cb.removeAllItems();
        for(Paciente e : getBack().getPacientes()){
            cb.addItem(e.getNomeCompleto());
        }
    }
    public void listConsultas(){
        //carrega opções no comboBox
        selecConsultaComboBox.removeAllItems();
        for(ConsultaMedica e : pacSelecionado.getHistoricoConsultasMedicas()){
            selecConsultaComboBox.addItem(Long.toString(e.getIdConsulta()));
        }
    }
    public void listMedicos(){
        //carrega opções no comboBox
        for(Medico e : getBack().getMedicos()){
            medicoComboBox.addItem(e.getNomeCompleto());
        }
    }
    
    public void loadInfo(int index){
        
        ConsultaMedica cm = pacSelecionado.getHistoricoConsultasMedicas().get(index);
        pacienteComboBox.removeAllItems();
        medicoComboBox.removeAllItems();
        //populo paciente
        for(Paciente p : getBack().getPacientes()){
            if(p.getIdPaciente() == cm.getIdPaciente()){
                pacienteComboBox.addItem(p.getNomeCompleto());
                break;
            }
        }
        //populo medico
        listMedicos();
        
       //populo demais informações
       idField.setText(Long.toString(cm.getIdConsulta()));
       if(cm.isIndicacaoCirurgica()){
           cirurgiaComboBox.setSelectedIndex(0);
       }
       else{
           cirurgiaComboBox.setSelectedIndex(1);
       }
       diagnosticoField.setText(cm.getDiagnostico());
       prescricaoTextArea.setText(cm.getPrescricao());
       queixasTextArea.setText(cm.getExameQueixa());
            
    }
    
    public boolean validar(){
        //valida todos os campos presentes no Jpanel e retorna falso caso algum
        //esteja invalido
        Validador v = new Validador();
        if(!v.validarCampo(diagnosticoField)){
            JOptionPane.showMessageDialog(null, "Diagnostico Invalido");
            return false;
        }
        if(!v.validarCampo(prescricaoTextArea)){
            JOptionPane.showMessageDialog(null, "Prescrição Invalida");
            return false;
        }
        if(!v.validarCampo(queixasTextArea)){
            JOptionPane.showMessageDialog(null, "Queixas Invalidas");
            return false;
        }
        
       return true;
    }
    
    public boolean editarInfo(int index){
        //valido
        if(!validar()){
            return false;
        }
        //pego o id dos medicos e pacientes selecionados
        Medico medSelecionado = getBack().getMedicos().get(medicoComboBox.getSelectedIndex());
        Paciente pacSelecionado = getBack().getPacientes().get(pacienteComboBox.getSelectedIndex());
        long idMed = medSelecionado.getIdMedico();
        long idPac = pacSelecionado.getIdPaciente();
        
        //populo consulta
        ConsultaMedica c = new ConsultaMedica(
                Long.parseLong(idField.getText()), 
                idPac, 
                idMed, 
                queixasTextArea.getText(), 
                diagnosticoField.getText(), 
                prescricaoTextArea.getText(), 
                cirurgiaComboBox.getSelectedItem() == "Sim");
       //adiciono consulta ao paciente
       ConsultaMedica.setIcountId(ConsultaMedica.getcountId() -1);
        pacSelecionado.getHistoricoConsultasMedicas().set(index, c);
        
        
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

        editarConsultaMedica = new javax.swing.JPanel();
        pacienteLabel = new javax.swing.JLabel();
        medicoLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        medicoComboBox = new javax.swing.JComboBox<>();
        cirurgiaComboBox = new javax.swing.JComboBox<>();
        cirurgiaLabel = new javax.swing.JLabel();
        diagnosticoLabel = new javax.swing.JLabel();
        diagnosticoField = new javax.swing.JTextField();
        prescricaoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prescricaoTextArea = new javax.swing.JTextArea();
        queixasLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        queixasTextArea = new javax.swing.JTextArea();
        pacienteComboBox = new javax.swing.JComboBox<>();
        selecPacienteComboBox = new javax.swing.JComboBox<>();
        selecConsultaComboBox = new javax.swing.JComboBox<>();
        selecPacienteLabel = new javax.swing.JLabel();
        selecConsultaLabel = new javax.swing.JLabel();
        editarBtn = new javax.swing.JButton();

        pacienteLabel.setText("Paciente");

        medicoLabel.setText("Medico");

        idLabel.setText("Id Consulta");

        backBtn.setText("<----");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        cirurgiaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        cirurgiaLabel.setText("Indicação Cirurgica?");

        diagnosticoLabel.setText("Diagnostico");

        prescricaoLabel.setText("Precrição");

        prescricaoTextArea.setColumns(20);
        prescricaoTextArea.setRows(5);
        jScrollPane1.setViewportView(prescricaoTextArea);

        queixasLabel.setText("Queixas");

        queixasTextArea.setColumns(20);
        queixasTextArea.setRows(5);
        jScrollPane2.setViewportView(queixasTextArea);

        pacienteComboBox.setEnabled(false);

        selecPacienteComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecPacienteComboBoxActionPerformed(evt);
            }
        });

        selecConsultaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecConsultaComboBoxActionPerformed(evt);
            }
        });

        selecPacienteLabel.setText("Selecione o Paciente");

        selecConsultaLabel.setText("Selecione a Consulta");

        editarBtn.setText("Editar");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editarConsultaMedicaLayout = new javax.swing.GroupLayout(editarConsultaMedica);
        editarConsultaMedica.setLayout(editarConsultaMedicaLayout);
        editarConsultaMedicaLayout.setHorizontalGroup(
            editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarConsultaMedicaLayout.createSequentialGroup()
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarConsultaMedicaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(backBtn))
                    .addGroup(editarConsultaMedicaLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selecPacienteLabel)
                            .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cirurgiaComboBox, 0, 170, Short.MAX_VALUE)
                                .addComponent(prescricaoLabel)
                                .addComponent(pacienteLabel)
                                .addComponent(cirurgiaLabel)
                                .addComponent(pacienteComboBox, 0, 170, Short.MAX_VALUE)
                                .addComponent(selecPacienteComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarConsultaMedicaLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarConsultaMedicaLayout.createSequentialGroup()
                                .addComponent(diagnosticoField, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addGap(324, 324, 324))
                            .addGroup(editarConsultaMedicaLayout.createSequentialGroup()
                                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(selecConsultaComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(diagnosticoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(medicoComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 170, Short.MAX_VALUE)
                                        .addComponent(medicoLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(selecConsultaLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarConsultaMedicaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
            .addGroup(editarConsultaMedicaLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarConsultaMedicaLayout.createSequentialGroup()
                        .addComponent(queixasLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarConsultaMedicaLayout.createSequentialGroup()
                        .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(editarConsultaMedicaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(97, 97, 97))))
        );
        editarConsultaMedicaLayout.setVerticalGroup(
            editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarConsultaMedicaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(editarBtn))
                .addGap(18, 18, 18)
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecPacienteLabel)
                    .addComponent(selecConsultaLabel))
                .addGap(5, 5, 5)
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecPacienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selecConsultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacienteLabel)
                    .addComponent(medicoLabel)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cirurgiaLabel)
                    .addComponent(diagnosticoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cirurgiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagnosticoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prescricaoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(queixasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(editarConsultaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(editarConsultaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        getCl().show(getContainer(),"mainWindow");
    }//GEN-LAST:event_backBtnActionPerformed

    private void selecPacienteComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecPacienteComboBoxActionPerformed
        int index = selecPacienteComboBox.getSelectedIndex();
        pacSelecionado = getBack().getPacientes().get(index);
        listConsultas();

    }//GEN-LAST:event_selecPacienteComboBoxActionPerformed

    private void selecConsultaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecConsultaComboBoxActionPerformed
        int index = selecConsultaComboBox.getSelectedIndex();
        if(index != -1){
            loadInfo(index);
        }

    }//GEN-LAST:event_selecConsultaComboBoxActionPerformed

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        int index = selecConsultaComboBox.getSelectedIndex();
        if(index != -1){
            if(editarInfo(index)){
                getCl().show(getContainer(),"mainWindow");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Sem Consultas");
        }
        
    }//GEN-LAST:event_editarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> cirurgiaComboBox;
    private javax.swing.JLabel cirurgiaLabel;
    private javax.swing.JTextField diagnosticoField;
    private javax.swing.JLabel diagnosticoLabel;
    private javax.swing.JButton editarBtn;
    private javax.swing.JPanel editarConsultaMedica;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> medicoComboBox;
    private javax.swing.JLabel medicoLabel;
    private javax.swing.JComboBox<String> pacienteComboBox;
    private javax.swing.JLabel pacienteLabel;
    private javax.swing.JLabel prescricaoLabel;
    private javax.swing.JTextArea prescricaoTextArea;
    private javax.swing.JLabel queixasLabel;
    private javax.swing.JTextArea queixasTextArea;
    private javax.swing.JComboBox<String> selecConsultaComboBox;
    private javax.swing.JLabel selecConsultaLabel;
    private javax.swing.JComboBox<String> selecPacienteComboBox;
    private javax.swing.JLabel selecPacienteLabel;
    // End of variables declaration//GEN-END:variables
}
