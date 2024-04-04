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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author souzlui03
 */
public class cadastrarConsultaMed extends CRUD_JPanel {

    /**
     * Creates new form cadastrarConsultaMed
     */
    public cadastrarConsultaMed(CardLayout cl, JPanel container, SistemaClinicas back) {
        super(cl, container, back);
        initComponents();
        loadId();
        listMedicos();
        listPacientes();
    }
    
    public void loadId(){
        //carrega o proximo id no campo bloqueado
        idField.setText(Long.toString(ConsultaMedica.getcountId()+ 1));
    }
    
    public void listMedicos(){
        //carrega opções no comboBox
        for(Medico e : getBack().getMedicos()){
            medicoComboBox.addItem(e.getNomeCompleto());
        }
    }
    
    public void listPacientes(){
        //carrega opções no comboBox
        for(Paciente e : getBack().getPacientes()){
            pacienteComboBox.addItem(e.getNomeCompleto());
        }
    }
    public boolean validar(){
        //valida todos os campos presentes no Jpanel e retorna falso caso algum
        //esteja invalido
        if(!validarCampo(diagnosticoField))
            return false;
        if(!validarCampo(prescricaoTextArea))
            return false;
        if(!validarCampo(queixasTextArea))
            return false;
        
       return true;
    }
    
    public boolean cadastrar(){
        //valido
        if(!validar()){
            JOptionPane.showMessageDialog(null, "Campo(s) Invalido(s)");
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
        pacSelecionado.getHistoricoConsultasMedicas().add(c);
        
        
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

        cadastrarConsultaMedica = new javax.swing.JPanel();
        pacienteLabel = new javax.swing.JLabel();
        medicoLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        salvarBtn = new javax.swing.JButton();
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

        pacienteLabel.setText("Paciente");

        medicoLabel.setText("Medico");

        idField.setEditable(false);
        idField.setFocusable(false);

        idLabel.setText("Id Consulta");

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

        javax.swing.GroupLayout cadastrarConsultaMedicaLayout = new javax.swing.GroupLayout(cadastrarConsultaMedica);
        cadastrarConsultaMedica.setLayout(cadastrarConsultaMedicaLayout);
        cadastrarConsultaMedicaLayout.setHorizontalGroup(
            cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(backBtn))
                    .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cirurgiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prescricaoLabel)
                            .addComponent(pacienteLabel)
                            .addComponent(cirurgiaLabel)
                            .addComponent(pacienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77)
                .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                        .addComponent(diagnosticoLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarConsultaMedicaLayout.createSequentialGroup()
                        .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                                .addComponent(medicoLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(medicoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(diagnosticoField))
                        .addGap(57, 57, 57)
                        .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                                .addComponent(idLabel)
                                .addGap(110, 110, 110))
                            .addComponent(idField))
                        .addGap(97, 97, 97))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarConsultaMedicaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salvarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(queixasLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(97, 97, 97))
        );
        cadastrarConsultaMedicaLayout.setVerticalGroup(
            cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(backBtn)
                .addGap(33, 33, 33)
                .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pacienteLabel)
                    .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                        .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medicoLabel)
                            .addComponent(idLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medicoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pacienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarConsultaMedicaLayout.createSequentialGroup()
                        .addComponent(cirurgiaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadastrarConsultaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cirurgiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diagnosticoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(diagnosticoLabel))
                .addGap(18, 18, 18)
                .addComponent(prescricaoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(queixasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(salvarBtn)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cadastrarConsultaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cadastrarConsultaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtnActionPerformed

        if(cadastrar()){
            getCl().show(getContainer(),"mainWindow");
        }
    }//GEN-LAST:event_salvarBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        getCl().show(getContainer(),"mainWindow");
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel cadastrarConsultaMedica;
    private javax.swing.JComboBox<String> cirurgiaComboBox;
    private javax.swing.JLabel cirurgiaLabel;
    private javax.swing.JTextField diagnosticoField;
    private javax.swing.JLabel diagnosticoLabel;
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
    private javax.swing.JButton salvarBtn;
    // End of variables declaration//GEN-END:variables
}
