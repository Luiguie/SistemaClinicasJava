/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

/**
 *
 * @author souzlui03
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportarExcel {
    private ArrayList<Medico> medicos = new ArrayList<Medico>();
    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    private ArrayList<ConsultaMedica> consultas = new ArrayList<ConsultaMedica>();
    private ArrayList<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();

    public ExportarExcel(ArrayList<Medico> medicos, ArrayList<Paciente> pacientes, ArrayList<Enfermeiro> enfermeiros) {
        this.medicos = medicos;
        this.pacientes = pacientes;
        this.enfermeiros = enfermeiros;
    }
    
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<ConsultaMedica> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<ConsultaMedica> consultas) {
        this.consultas = consultas;
    }

    public ArrayList<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(ArrayList<Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }
    
    public void exportar(String exportPath) throws IOException {
        //crio workbook e worksheet
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet enfermeiroSheet = book.createSheet("Enfermeiros");
        XSSFSheet medicosSheet = book.createSheet("Medicos");
        XSSFSheet pacientesSheet = book.createSheet("Pacientes");
        XSSFSheet responsaveisSheet = book.createSheet("Responsaveis");
        XSSFSheet consultaSheet = book.createSheet("Consultas Medicas");

        //gravo nas sheets
        gravarEnfermeiros(enfermeiroSheet);
        gravarMedico(medicosSheet);
        gravarPaciente(pacientesSheet);
        gravarResponsavel(responsaveisSheet);
        gravarConsultas(consultaSheet);
        
        exportPath.replace("\\", "\\\\");
        Path filePath = Paths.get(exportPath + ".xlsx");
        try (OutputStream outputStream = Files.newOutputStream(filePath)) {
          book.write(outputStream);
        }
              
    }
    
    private void gravarEnfermeiros(XSSFSheet sheet){
        //inicio cabecalho
        String[] cabecalho = {"ID","Nome","Data de Nascimentos","Rua","Numero","Bairro",
            "Cidade","Estado","CEP","Telefone","Celular","Email","Genero",
            "Setor","Carga Horaria","Treinado em Raio X?"};
        
        Row linhaCabecalho = sheet.createRow(0);
        for(int i=0; i<cabecalho.length; i++){
            linhaCabecalho.createCell(i).setCellValue(cabecalho[i]);
        }
        //itero e preencho campos
        int index = 1;
        for(Enfermeiro e : enfermeiros){
            Row row = sheet.createRow(index);
            
            row.createCell(0).setCellValue(e.getIdEnfermeiro());
            row.createCell(1).setCellValue(e.getNomeCompleto());
            row.createCell(2).setCellValue(e.getDataNascimento());
            row.createCell(3).setCellValue(e.getEndereco().getRua());
            row.createCell(4).setCellValue(e.getEndereco().getNumero());
            row.createCell(5).setCellValue(e.getEndereco().getBairro());
            row.createCell(6).setCellValue(e.getEndereco().getCidade());
            row.createCell(7).setCellValue(e.getEndereco().getEstado());
            row.createCell(8).setCellValue(e.getEndereco().getCep());
            row.createCell(9).setCellValue(e.getContato().getTelefone());
            row.createCell(10).setCellValue(e.getContato().getCelular());
            row.createCell(11).setCellValue(e.getContato().getEmail());
            
            if(e.getGenero() == Genero.MASCULINO){
                row.createCell(12).setCellValue("Masculino");
            }
            else{
                row.createCell(12).setCellValue("Feminino");
            }
            
            row.createCell(13).setCellValue(e.getSetor());
            row.createCell(14).setCellValue(e.getChSemanal());
            row.createCell(15).setCellValue(e.isTreinadoOpRX());
            
            index+=1;
        }
    }
    
    private void gravarMedico(XSSFSheet sheet){
        //inicio cabecalho
        String[] cabecalho = {"ID","Nome","Data de Nascimentos","Rua","Numero","Bairro",
            "Cidade","Estado","CEP","Telefone","Celular","Email","Genero",
            "Setor","Carga Horaria","Cirurgião?","CRM","Areas de Especialidade"};
        
        Row linhaCabecalho = sheet.createRow(0);
        for(int i=0; i<cabecalho.length; i++){
            linhaCabecalho.createCell(i).setCellValue(cabecalho[i]);
        }
        //itero e preencho campos
        int index = 1;
        for(Medico m : medicos){
            Row row = sheet.createRow(index);
            
            row.createCell(0).setCellValue(m.getIdMedico());
            row.createCell(1).setCellValue(m.getNomeCompleto());
            row.createCell(2).setCellValue(m.getDataNascimento());
            row.createCell(3).setCellValue(m.getEndereco().getRua());
            row.createCell(4).setCellValue(m.getEndereco().getNumero());
            row.createCell(5).setCellValue(m.getEndereco().getBairro());
            row.createCell(6).setCellValue(m.getEndereco().getCidade());
            row.createCell(7).setCellValue(m.getEndereco().getEstado());
            row.createCell(8).setCellValue(m.getEndereco().getCep());
            row.createCell(9).setCellValue(m.getContato().getTelefone());
            row.createCell(10).setCellValue(m.getContato().getCelular());
            row.createCell(11).setCellValue(m.getContato().getEmail());
            
            if(m.getGenero() == Genero.MASCULINO){
                row.createCell(12).setCellValue("Masculino");
            }
            else{
                row.createCell(12).setCellValue("Feminino");
            }
            
            row.createCell(13).setCellValue(m.getSetor());
            row.createCell(14).setCellValue(m.getChSemanal());
            row.createCell(15).setCellValue(m.isCirurgiao());
            row.createCell(16).setCellValue(m.getNumeroCRM());
            
            String areas = "";
            for(String a : m.getAreasEspecialidade()){
                areas+= (a + ", ");
            }
            //retiro espaço e virgula extra no final
            areas = areas.substring(0, areas.length() -2);
            
            row.createCell(17).setCellValue(areas);
            
            index+=1;
        }
    }
    
    private void gravarPaciente(XSSFSheet sheet){
        //inicio cabecalho
        String[] cabecalho = {"ID","Nome","Data de Nascimentos","Rua","Numero","Bairro",
            "Cidade","Estado","CEP","Telefone","Celular","Email","Genero",
            "Data de Cadastro","Idade","Observação Geral"};
        
        Row linhaCabecalho = sheet.createRow(0);
        for(int i=0; i<cabecalho.length; i++){
            linhaCabecalho.createCell(i).setCellValue(cabecalho[i]);
        }
        //itero e preencho campos
        int index = 1;
        for(Paciente p : pacientes){
            Row row = sheet.createRow(index);
            
            row.createCell(0).setCellValue(p.getIdPaciente());
            row.createCell(1).setCellValue(p.getNomeCompleto());
            row.createCell(2).setCellValue(p.getDataNascimento());
            row.createCell(3).setCellValue(p.getEndereco().getRua());
            row.createCell(4).setCellValue(p.getEndereco().getNumero());
            row.createCell(5).setCellValue(p.getEndereco().getBairro());
            row.createCell(6).setCellValue(p.getEndereco().getCidade());
            row.createCell(7).setCellValue(p.getEndereco().getEstado());
            row.createCell(8).setCellValue(p.getEndereco().getCep());
            row.createCell(9).setCellValue(p.getContato().getTelefone());
            row.createCell(10).setCellValue(p.getContato().getCelular());
            row.createCell(11).setCellValue(p.getContato().getEmail());
            
            if(p.getGenero() == Genero.MASCULINO){
                row.createCell(12).setCellValue("Masculino");
            }
            else{
                row.createCell(12).setCellValue("Feminino");
            }
            
            row.createCell(13).setCellValue(p.getDataCadastro());
            row.createCell(14).setCellValue(p.getIdade());
            row.createCell(15).setCellValue(p.getObsGeral());
            
            index+=1;
        }
    }
    
    private void gravarResponsavel(XSSFSheet sheet){
        //inicio cabecalho
        String[] cabecalho = {"ID","Nome","Telefone","Celular","Email",
            "Id Paciente"};
        
        Row linhaCabecalho = sheet.createRow(0);
        for(int i=0; i<cabecalho.length; i++){
            linhaCabecalho.createCell(i).setCellValue(cabecalho[i]);
        }
        //itero e preencho campos
        int index = 1;
        for(Paciente p : pacientes){
            if(!p.getContatoResponsavel().isEmpty()){
                for(Responsavel r : p.getContatoResponsavel()){
                    Row row = sheet.createRow(index);
                    row.createCell(0).setCellValue(r.getIdResponsavel());
                    row.createCell(1).setCellValue(r.getNomeResponsavel());
                    row.createCell(2).setCellValue(r.getTelefone());
                    row.createCell(3).setCellValue(r.getCelular());
                    row.createCell(4).setCellValue(r.getEmail());
                    row.createCell(5).setCellValue(p.getIdPaciente());
                    
                    index+=1;
                }
            }
        }
    }
    
    private void gravarConsultas(XSSFSheet sheet){
        //inicio cabecalho
        String[] cabecalho = {"ID Consulta","ID Paciente","ID Medico",
            "Diagnostico","Indicação Cirurgica","Prescrição",
            "Queixa"};
        
        Row linhaCabecalho = sheet.createRow(0);
        for(int i=0; i<cabecalho.length; i++){
            linhaCabecalho.createCell(i).setCellValue(cabecalho[i]);
        }
        //itero e preencho campos
        int index = 1;
        for(Paciente p : pacientes){
            if(!p.getHistoricoConsultasMedicas().isEmpty()){
                for(ConsultaMedica cm : p.getHistoricoConsultasMedicas()){
                    Row row = sheet.createRow(index);
                    row.createCell(0).setCellValue(cm.getIdConsulta());
                    row.createCell(1).setCellValue(cm.getIdPaciente());
                    row.createCell(2).setCellValue(cm.getIdMedico());
                    row.createCell(3).setCellValue(cm.getDiagnostico());
                    row.createCell(4).setCellValue(cm.isIndicacaoCirurgica());
                    row.createCell(5).setCellValue(cm.getPrescricao());
                    row.createCell(6).setCellValue(cm.getExameQueixa());
                    
                    index+=1;
                }
            }
        }
    }
    

    
    
    
}
