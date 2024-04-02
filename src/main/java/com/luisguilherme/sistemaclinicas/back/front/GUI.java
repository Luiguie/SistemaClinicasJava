/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back.front;

/**
 *
 * @author Guilg
 */
import com.luisguilherme.sistemaclinicas.back.SistemaClinicas;
import java.awt.CardLayout;
public class GUI extends javax.swing.JFrame {

    private CardLayout cl;
    private SistemaClinicas back = new SistemaClinicas();
    
    public GUI() {
        initComponents();
        setCl((CardLayout) container.getLayout());
    }

    public void setCl(CardLayout cl) {
        this.cl = cl;
    }

    public CardLayout getCl() {
        return cl;
    }
    
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        mainWindow = new javax.swing.JPanel();
        labelPaciente = new javax.swing.JLabel();
        consPaciente = new javax.swing.JButton();
        cadPaciente = new javax.swing.JButton();
        editPaciente = new javax.swing.JButton();
        remPaciente = new javax.swing.JButton();
        labelEnfermeiro = new javax.swing.JLabel();
        cadEnfermeiro = new javax.swing.JButton();
        consEnfermeiro = new javax.swing.JButton();
        editEnfermeiro = new javax.swing.JButton();
        remEnfermeiro = new javax.swing.JButton();
        editConsultas = new javax.swing.JButton();
        labelConsultas = new javax.swing.JLabel();
        consConsultas = new javax.swing.JButton();
        remConsultas = new javax.swing.JButton();
        cadConsultas = new javax.swing.JButton();
        editMedico = new javax.swing.JButton();
        cadMedico = new javax.swing.JButton();
        consMedico = new javax.swing.JButton();
        labelMedico = new javax.swing.JLabel();
        remMedico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setLayout(new java.awt.CardLayout());

        labelPaciente.setText("Paciente");

        consPaciente.setText("Consultar");
        consPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consPacienteActionPerformed(evt);
            }
        });

        cadPaciente.setText("Cadastrar");
        cadPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadPacienteActionPerformed(evt);
            }
        });

        editPaciente.setText("Editar");
        editPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPacienteActionPerformed(evt);
            }
        });

        remPaciente.setText("Remover");
        remPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remPacienteActionPerformed(evt);
            }
        });

        labelEnfermeiro.setText("Enfermeiro");

        cadEnfermeiro.setText("Cadastrar");
        cadEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadEnfermeiroActionPerformed(evt);
            }
        });

        consEnfermeiro.setText("Consultar");
        consEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consEnfermeiroActionPerformed(evt);
            }
        });

        editEnfermeiro.setText("Editar");
        editEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEnfermeiroActionPerformed(evt);
            }
        });

        remEnfermeiro.setText("Remover");
        remEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remEnfermeiroActionPerformed(evt);
            }
        });

        editConsultas.setText("Editar");
        editConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editConsultasActionPerformed(evt);
            }
        });

        labelConsultas.setText("Consultas Medicas");

        consConsultas.setText("Consultar");
        consConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consConsultasActionPerformed(evt);
            }
        });

        remConsultas.setText("Remover");
        remConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remConsultasActionPerformed(evt);
            }
        });

        cadConsultas.setText("Cadastrar");
        cadConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadConsultasActionPerformed(evt);
            }
        });

        editMedico.setText("Editar");
        editMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMedicoActionPerformed(evt);
            }
        });

        cadMedico.setText("Cadastrar");
        cadMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMedicoActionPerformed(evt);
            }
        });

        consMedico.setText("Consultar");
        consMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consMedicoActionPerformed(evt);
            }
        });

        labelMedico.setText("Medico");

        remMedico.setText("Remover");
        remMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainWindowLayout = new javax.swing.GroupLayout(mainWindow);
        mainWindow.setLayout(mainWindowLayout);
        mainWindowLayout.setHorizontalGroup(
            mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainWindowLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainWindowLayout.createSequentialGroup()
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addComponent(editPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addComponent(cadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(labelPaciente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addComponent(editMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addComponent(cadMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(labelMedico)))
                        .addGap(85, 85, 85))
                    .addGroup(mainWindowLayout.createSequentialGroup()
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addComponent(editEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addComponent(cadEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(labelEnfermeiro)))
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelConsultas)
                                .addGap(151, 151, 151))
                            .addGroup(mainWindowLayout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainWindowLayout.createSequentialGroup()
                                        .addComponent(editConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(remConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainWindowLayout.createSequentialGroup()
                                        .addComponent(cadConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(consConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 85, Short.MAX_VALUE))))))
        );
        mainWindowLayout.setVerticalGroup(
            mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainWindowLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainWindowLayout.createSequentialGroup()
                        .addComponent(labelPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadPaciente)
                            .addComponent(consPaciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editPaciente)
                            .addComponent(remPaciente)))
                    .addGroup(mainWindowLayout.createSequentialGroup()
                        .addComponent(labelMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadMedico)
                            .addComponent(consMedico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editMedico)
                            .addComponent(remMedico))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainWindowLayout.createSequentialGroup()
                        .addComponent(labelEnfermeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadEnfermeiro)
                            .addComponent(consEnfermeiro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editEnfermeiro)
                            .addComponent(remEnfermeiro)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainWindowLayout.createSequentialGroup()
                        .addComponent(labelConsultas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadConsultas)
                            .addComponent(consConsultas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editConsultas)
                            .addComponent(remConsultas))))
                .addGap(51, 51, 51))
        );

        container.add(mainWindow, "mainWindow");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadPacienteActionPerformed

    private void consPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consPacienteActionPerformed

    private void editPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editPacienteActionPerformed

    private void remPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remPacienteActionPerformed

    private void cadMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMedicoActionPerformed
        cadastrarMedico panel = new cadastrarMedico(cl, container, back);
        container.add(panel, "cadastraMedico");
        cl.show(container, "cadastraMedico");
    }//GEN-LAST:event_cadMedicoActionPerformed

    private void consMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consMedicoActionPerformed

    private void editMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMedicoActionPerformed

    private void remMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remMedicoActionPerformed

    private void cadEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadEnfermeiroActionPerformed
        cadastrarEnfermeiroPanel panel = new cadastrarEnfermeiroPanel(cl, container, back);
        container.add(panel, "cadastraEnfermeiro");
        cl.show(container, "cadastraEnfermeiro");
    }//GEN-LAST:event_cadEnfermeiroActionPerformed

    private void consEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consEnfermeiroActionPerformed
        consultarEnfermeiroPanel panel = new consultarEnfermeiroPanel(cl, container, back);
        container.add(panel, "consultaEnfermeiro");
        cl.show(container, "consultaEnfermeiro");
    }//GEN-LAST:event_consEnfermeiroActionPerformed

    private void editEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEnfermeiroActionPerformed
        editarEnfermeiroPanel panel = new editarEnfermeiroPanel(cl, container, back);
        container.add(panel, "editaEnfermeiro");
        cl.show(container, "editaEnfermeiro");
    }//GEN-LAST:event_editEnfermeiroActionPerformed

    private void remEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remEnfermeiroActionPerformed
        deletarEnfermeiro panel = new deletarEnfermeiro(cl, container, back);
        container.add(panel, "deletaEnfermeiro");
        cl.show(container, "deletaEnfermeiro");
    }//GEN-LAST:event_remEnfermeiroActionPerformed

    private void cadConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadConsultasActionPerformed

    private void consConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consConsultasActionPerformed

    private void editConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editConsultasActionPerformed

    private void remConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remConsultasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadConsultas;
    private javax.swing.JButton cadEnfermeiro;
    private javax.swing.JButton cadMedico;
    private javax.swing.JButton cadPaciente;
    private javax.swing.JButton consConsultas;
    private javax.swing.JButton consEnfermeiro;
    private javax.swing.JButton consMedico;
    private javax.swing.JButton consPaciente;
    private javax.swing.JPanel container;
    private javax.swing.JButton editConsultas;
    private javax.swing.JButton editEnfermeiro;
    private javax.swing.JButton editMedico;
    private javax.swing.JButton editPaciente;
    private javax.swing.JLabel labelConsultas;
    private javax.swing.JLabel labelEnfermeiro;
    private javax.swing.JLabel labelMedico;
    private javax.swing.JLabel labelPaciente;
    private javax.swing.JPanel mainWindow;
    private javax.swing.JButton remConsultas;
    private javax.swing.JButton remEnfermeiro;
    private javax.swing.JButton remMedico;
    private javax.swing.JButton remPaciente;
    // End of variables declaration//GEN-END:variables
}
