/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back.front;

import com.luisguilherme.sistemaclinicas.back.ContatoTelEmail;
import com.luisguilherme.sistemaclinicas.back.Endereco;
import com.luisguilherme.sistemaclinicas.back.Genero;
import com.luisguilherme.sistemaclinicas.back.Medico;
import com.luisguilherme.sistemaclinicas.back.SistemaClinicas;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Guilg
 */
public class editarMedico extends CRUD_JPanel {

    /**
     * Creates new form editarMedico
     */
    public editarMedico(CardLayout cl, JPanel container, SistemaClinicas back) {
        super(cl, container, back);
        initComponents();
        listMedicos();
    }
    
    public void listMedicos(){
        //carrega opções no comboBox
        for(Medico e : getBack().getMedicos()){
            selectionComboBox.addItem(e.getNomeCompleto());
        }
    }
    
    public void loadInfo(int index){
        
        Medico m = getBack().getMedicos().get(index);
        Endereco end = m.getEndereco();
        ContatoTelEmail cont = m.getContato();
        
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
        nomeField.setText(m.getNomeCompleto());
        nascimentoField.setDate(m.getDataNascimento());
        if(m.getGenero() == Genero.MASCULINO){
            generoComboBox.setSelectedIndex(0);
        }
        else{
            generoComboBox.setSelectedIndex(1);
        }
        
        //carrego informações especificas
        idField.setText(Long.toString(m.getIdMedico()));
        setorField.setText(m.getSetor());
        chField.setText(Integer.toString(m.getChSemanal()));
        crmField.setText(Integer.toString(m.getNumeroCRM()));
        if(m.isCirurgiao()){
            cirurgiaoComboBox.setSelectedIndex(0);
        }
        else{
            cirurgiaoComboBox.setSelectedIndex(1);
        }
        
        //limpo e carrego especialidades
        especialidadesField.setText("");
        for(String area : m.getAreasEspecialidade()){
            especialidadesField.setText(especialidadesField.getText() + 
                    area + ",");
        }
        //removo a virgula adicional
        int especLen = especialidadesField.getText().length();
        especialidadesField.setText(
                especialidadesField.getText().substring(0,especLen-1));
            
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
        if(!v.validarNum(CEPField)){
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
        if(!v.validarNum(crmField)){
            JOptionPane.showMessageDialog(null, "CRM Invalido");
            return false;
        }
        if(!v.validarCampo(especialidadesField)){
            JOptionPane.showMessageDialog(null, "Especialidades Invalidas");
            return false;
        }
        
       return true;
    }
    
    public boolean editarInfo(int index){
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
            Integer.parseInt(CEPField.getText()));
        //populo objeto contato
        ContatoTelEmail c = new ContatoTelEmail(
            telefoneField.getText(),
            celularField.getText(),
            emailField.getText());

        //checo o genero selecionado e populo os demais campos
        if(generoComboBox.getSelectedIndex() == 0){
            Medico med = new Medico(
                Long.parseLong(idField.getText()),
                Integer.parseInt(crmField.getText()),
                cirurgiaoComboBox.getSelectedItem() == "Sim",
                setorField.getText(),
                Integer.parseInt(chField.getText()),
                nomeField.getText(),
                nascimentoField.getDate(),
                e,
                c,
                Genero.MASCULINO,
                especialidadesField.getText());
            Medico.setIcountId(Medico.getcountId() - 1);
            getBack().getMedicos().set(index, med);

        }
        else{
            Medico med = new Medico(
                Long.parseLong(idField.getText()),
                Integer.parseInt(crmField.getText()),
                cirurgiaoComboBox.getSelectedItem() == "Sim",
                setorField.getText(),
                Integer.parseInt(chField.getText()),
                nomeField.getText(),
                nascimentoField.getDate(),
                e,
                c,
                Genero.FEMININO,
                especialidadesField.getText());
            Medico.setIcountId(Medico.getcountId() - 1);
            getBack().getMedicos().set(index, med);
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

        editarMedico = new javax.swing.JPanel();
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
        backBtn = new javax.swing.JButton();
        selectionComboBox = new javax.swing.JComboBox<>();
        selectionLabel = new javax.swing.JLabel();
        cirurgiaoLabel = new javax.swing.JLabel();
        cirurgiaoComboBox = new javax.swing.JComboBox<>();
        crmField = new javax.swing.JTextField();
        crmLabel = new javax.swing.JLabel();
        especialidadesLabel = new javax.swing.JLabel();
        especialidadesField = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();

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
        generoComboBox.setFocusable(false);

        infoGeraisLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoGeraisLabel.setText("Informações Gerais");

        infoEspecificasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoEspecificasLabel.setText("Informações Especificas");

        setorLabel.setText("Setor");

        chLabel.setText("Carga Horaria Semanal");

        idField.setEditable(false);
        idField.setFocusable(false);

        idLabel.setText("Id Medico");

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

        selectionLabel.setText("Medico");

        cirurgiaoLabel.setText("Cirurgião?");

        cirurgiaoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        crmLabel.setText("CRM");

        especialidadesLabel.setText("Especialidades (Separar por Virgula)");

        editBtn.setText("Editar");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editarMedicoLayout = new javax.swing.GroupLayout(editarMedico);
        editarMedico.setLayout(editarMedicoLayout);
        editarMedicoLayout.setHorizontalGroup(
            editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarMedicoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(backBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarMedicoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectionLabel)
                    .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(231, 231, 231))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarMedicoLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarMedicoLayout.createSequentialGroup()
                        .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cidadeField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estadoField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CEPField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoGeraisLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(bairroField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editarMedicoLayout.createSequentialGroup()
                                .addComponent(bairroLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(68, 68, 68))
                    .addGroup(editarMedicoLayout.createSequentialGroup()
                        .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CEPLabel)
                            .addComponent(estadoLabel)
                            .addComponent(cidadeLabel)
                            .addComponent(infoEspecificasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cirurgiaoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cirurgiaoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(telefoneLabel)
                    .addComponent(telefoneField)
                    .addComponent(celularLabel)
                    .addComponent(celularField)
                    .addComponent(emailLabel)
                    .addComponent(emailField)
                    .addComponent(generoComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(generoLabel)
                    .addComponent(crmLabel)
                    .addComponent(crmField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especialidadesField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especialidadesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        editarMedicoLayout.setVerticalGroup(
            editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarMedicoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(backBtn)
                .addGap(32, 32, 32)
                .addComponent(selectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editarMedicoLayout.createSequentialGroup()
                        .addComponent(infoGeraisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarMedicoLayout.createSequentialGroup()
                                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(editarMedicoLayout.createSequentialGroup()
                                        .addComponent(telefoneLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(editarMedicoLayout.createSequentialGroup()
                                        .addComponent(bairroLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarMedicoLayout.createSequentialGroup()
                                .addComponent(celularLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(celularField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(editarMedicoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nascimentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaLabel)
                    .addComponent(cidadeLabel)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroLabel)
                    .addComponent(CEPLabel)
                    .addComponent(generoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CEPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(infoEspecificasLabel)
                .addGap(9, 9, 9)
                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editarMedicoLayout.createSequentialGroup()
                        .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(editarMedicoLayout.createSequentialGroup()
                                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(setorLabel)
                                    .addComponent(idLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(setorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(editarMedicoLayout.createSequentialGroup()
                                .addComponent(crmLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(crmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(editarMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(editarMedicoLayout.createSequentialGroup()
                                    .addComponent(chLabel)
                                    .addGap(35, 35, 35))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarMedicoLayout.createSequentialGroup()
                                    .addComponent(cirurgiaoLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cirurgiaoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(editarMedicoLayout.createSequentialGroup()
                                .addComponent(especialidadesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(especialidadesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editBtn)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(editarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(editarMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int index = selectionComboBox.getSelectedIndex();
        if(editarInfo(index)){
            getCl().show(getContainer(),"mainWindow");
        }

    }//GEN-LAST:event_editBtnActionPerformed


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
    private javax.swing.JComboBox<String> cirurgiaoComboBox;
    private javax.swing.JLabel cirurgiaoLabel;
    private javax.swing.JTextField crmField;
    private javax.swing.JLabel crmLabel;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel editarMedico;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField especialidadesField;
    private javax.swing.JLabel especialidadesLabel;
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
    private javax.swing.JComboBox<String> selectionComboBox;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.JTextField setorField;
    private javax.swing.JLabel setorLabel;
    private javax.swing.JTextField telefoneField;
    private javax.swing.JLabel telefoneLabel;
    // End of variables declaration//GEN-END:variables
}
