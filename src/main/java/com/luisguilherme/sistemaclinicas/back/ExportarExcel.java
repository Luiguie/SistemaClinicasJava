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
    
    
    
    public void exportar(String exportName) throws IOException {
        //crio workbook e worksheet
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Enfermeiros");

        gravarEnfermeiros(sheet);
        
        Path filePath = Paths.get("C:\\Temp\\" + exportName + ".xlsx");
        try (OutputStream outputStream = Files.newOutputStream(filePath)) {
          book.write(outputStream);
        }
        
              
    }
    
    private void gravarEnfermeiros(XSSFSheet sheet){
        //inicio cabecalho
        String[] cabecalho = {"ID","Nome","Rua","Numero","Bairro",
            "Cidade","Estado","CEP","Telefone","Celular","Email","Genero",
            "Setor","Carga Horaria","Treinado em Raio X?"};
        
        Row linhaCabecalho = sheet.createRow(0);
        for(int i=0; i<cabecalho.length; i++){
            linhaCabecalho.createCell(i).setCellValue(cabecalho[i]);
        }
        int index = 1;
        for(Enfermeiro e : enfermeiros){
            Row row = sheet.createRow(index);
            
            row.createCell(0).setCellValue(e.getIdEnfermeiro());
            row.createCell(1).setCellValue(e.getNomeCompleto());
            row.createCell(2).setCellValue(e.getEndereco().getRua());
            row.createCell(3).setCellValue(e.getEndereco().getNumero());
            row.createCell(4).setCellValue(e.getEndereco().getBairro());
            row.createCell(5).setCellValue(e.getEndereco().getCidade());
            row.createCell(6).setCellValue(e.getEndereco().getEstado());
            row.createCell(7).setCellValue(e.getEndereco().getCep());
            row.createCell(8).setCellValue(e.getContato().getTelefone());
            row.createCell(9).setCellValue(e.getContato().getCelular());
            row.createCell(10).setCellValue(e.getContato().getEmail());
            
            if(e.getGenero() == Genero.MASCULINO){
                row.createCell(10).setCellValue("Masculino");
            }
            else{
                row.createCell(10).setCellValue("Feminino");
            }
            
            row.createCell(12).setCellValue(e.getSetor());
            row.createCell(13).setCellValue(e.getChSemanal());
            row.createCell(14).setCellValue(e.isTreinadoOpRX());
            
            index+=1;
        }
    }
    

    
    
    
}
