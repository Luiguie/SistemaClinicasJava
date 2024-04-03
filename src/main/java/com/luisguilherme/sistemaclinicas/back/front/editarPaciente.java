/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back.front;

import com.luisguilherme.sistemaclinicas.back.ContatoTelEmail;
import com.luisguilherme.sistemaclinicas.back.Endereco;
import com.luisguilherme.sistemaclinicas.back.Genero;
import com.luisguilherme.sistemaclinicas.back.Paciente;
import com.luisguilherme.sistemaclinicas.back.SistemaClinicas;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author souzlui03
 */
public class editarPaciente extends CRUD_JPanel {

    /**
     * Creates new form editarPaciente
     */
    public editarPaciente(CardLayout cl, JPanel container, SistemaClinicas back) {
        super(cl, container, back);
        initComponents();
        listPacientes();
    }
    
    public void listPacientes(){
        //carrega opções no comboBox
        for(Paciente e : getBack().getPacientes()){
            selectionComboBox.addItem(e.getNomeCompleto());
        }
    }
    
    public void loadInfo(int index){
        
        Paciente p = getBack().getPacientes().get(index);
        Endereco end = p.getEndereco();
        ContatoTelEmail cont = p.getContato();
        
        //carrego endereço
        ruaField.setText(end.getRua());
        numeroField.setText(Integer.toString(end.getNumero()));
        bairroField.setText(end.getBairro());
        cidadeField.setText(end.getCidade());
        estadoField.setText(end.getEstado());
        CEPFieldl.setText(Integer.toString(end.getCep()));
        
        //carrego contato
        telefoneField.setText(cont.getTelefone());
        celularField.setText(cont.getCelular());
        emailField.setText(cont.getEmail());
        
        //carrego o resto das informações gerais
        nomeField.setText(p.getNomeCompleto());
        nascimentoField.setDate(p.getDataNascimento());
        if(p.getGenero() == Genero.MASCULINO){
            generoComboBox.setSelectedIndex(0);
        }
        else{
            generoComboBox.setSelectedIndex(1);
        }
        
        //carrego informações especificas
        idField.setText(Long.toString(p.getIdPaciente()));
             
            
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
        
       return true;
    }
    
    public boolean editarInfo(int index){
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

        //checo o genero selecionado e populo os demais campos
        if(generoComboBox.getSelectedIndex() == 0){
            Paciente pac = new Paciente(
                Long.parseLong(idField.getText()),
                obsTextArea.getText(),
                nomeField.getText(),
                nascimentoField.getDate(),
                e,
                c,
                Genero.MASCULINO);
            Paciente.setIcountId(Paciente.getcountId() - 1);
            getBack().getPacientes().set(index, pac);

        }
        else{
            Paciente pac = new Paciente(
                Long.parseLong(idField.getText()),
                obsTextArea.getText(),
                nomeField.getText(),
                nascimentoField.getDate(),
                e,
                c,
                Genero.FEMININO);
            Paciente.setIcountId(Paciente.getcountId() - 1);
            getBack().getPacientes().set(index, pac);
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

        consultarPaciente = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        obsTextArea = new javax.swing.JTextArea();
        obsLabel = new javax.swing.JLabel();
        infoEspecificasLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        selectionComboBox = new javax.swing.JComboBox<>();
        selectionLabel = new javax.swing.JLabel();
        editarBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        CEPFieldl.setEditable(false);
        CEPFieldl.setFocusable(false);

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

        obsTextArea.setColumns(20);
        obsTextArea.setRows(5);
        jScrollPane1.setViewportView(obsTextArea);

        obsLabel.setText("Observações");

        infoEspecificasLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoEspecificasLabel1.setText("Responsaveis");

        jScrollPane2.setViewportView(jList1);

        selectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionComboBoxActionPerformed(evt);
            }
        });

        selectionLabel.setText("Paciente");

        editarBtn.setText("Editar");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        jButton1.setText("➕");

        jButton2.setText("✎");

        jButton3.setText("X");

        javax.swing.GroupLayout consultarPacienteLayout = new javax.swing.GroupLayout(consultarPaciente);
        consultarPaciente.setLayout(consultarPacienteLayout);
        consultarPacienteLayout.setHorizontalGroup(
            consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultarPacienteLayout.createSequentialGroup()
                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultarPacienteLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(infoGeraisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(consultarPacienteLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(consultarPacienteLayout.createSequentialGroup()
                                .addComponent(backBtn)
                                .addGap(500, 500, 500)
                                .addComponent(editarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(obsLabel)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(consultarPacienteLayout.createSequentialGroup()
                                    .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(consultarPacienteLayout.createSequentialGroup()
                                            .addGap(493, 493, 493)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultarPacienteLayout.createSequentialGroup()
                                            .addComponent(idLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultarPacienteLayout.createSequentialGroup()
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(infoEspecificasLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(consultarPacienteLayout.createSequentialGroup()
                                    .addGap(540, 540, 540)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(consultarPacienteLayout.createSequentialGroup()
                                    .addGap(279, 279, 279)
                                    .addComponent(infoEspecificasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(ruaLabel)
                                .addGroup(consultarPacienteLayout.createSequentialGroup()
                                    .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(consultarPacienteLayout.createSequentialGroup()
                                            .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ruaField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(numeroLabel)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(CEPFieldl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(CEPLabel)))
                                        .addGroup(consultarPacienteLayout.createSequentialGroup()
                                            .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(nomeLabel)
                                                .addComponent(nascimentoLabel)
                                                .addComponent(nascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(74, 74, 74)
                                            .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(estadoLabel)
                                                    .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bairroLabel)
                                                    .addComponent(cidadeLabel)))))
                                    .addGap(79, 79, 79)
                                    .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telefoneLabel)
                                        .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(celularLabel)
                                        .addComponent(celularField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailLabel)
                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(generoLabel)
                                        .addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(consultarPacienteLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectionLabel)
                            .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        consultarPacienteLayout.setVerticalGroup(
            consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultarPacienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(editarBtn))
                .addGap(8, 8, 8)
                .addComponent(selectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoGeraisLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(consultarPacienteLayout.createSequentialGroup()
                        .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(consultarPacienteLayout.createSequentialGroup()
                                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(consultarPacienteLayout.createSequentialGroup()
                                        .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nomeLabel)
                                            .addComponent(bairroLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(consultarPacienteLayout.createSequentialGroup()
                                        .addComponent(telefoneLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nascimentoLabel)
                                    .addComponent(estadoLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(consultarPacienteLayout.createSequentialGroup()
                                .addComponent(celularLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(celularField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(consultarPacienteLayout.createSequentialGroup()
                                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ruaLabel)
                                    .addComponent(cidadeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ruaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(consultarPacienteLayout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroLabel)
                            .addComponent(CEPLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CEPFieldl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(consultarPacienteLayout.createSequentialGroup()
                        .addComponent(generoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultarPacienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(consultarPacienteLayout.createSequentialGroup()
                        .addGroup(consultarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(consultarPacienteLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(infoEspecificasLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(consultarPacienteLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(infoEspecificasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addGap(0, 15, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(consultarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(consultarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        int index = selectionComboBox.getSelectedIndex();

        if(editarInfo(index)){
            getCl().show(getContainer(),"mainWindow");
        }
    }//GEN-LAST:event_editarBtnActionPerformed

    private void selectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionComboBoxActionPerformed
        //mando o indice selecionado e carrego as informações
        int index = selectionComboBox.getSelectedIndex();
        loadInfo(index);
    }//GEN-LAST:event_selectionComboBoxActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        getCl().show(getContainer(),"mainWindow");
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CEPFieldl;
    private javax.swing.JLabel CEPLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField bairroField;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JTextField celularField;
    private javax.swing.JLabel celularLabel;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JPanel consultarPaciente;
    private javax.swing.JButton editarBtn;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JComboBox<String> selectionComboBox;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.JTextField telefoneField;
    private javax.swing.JLabel telefoneLabel;
    // End of variables declaration//GEN-END:variables
}
