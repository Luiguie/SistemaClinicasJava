/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisguilherme.sistemaclinicas.back;

/**
 *
 * @author Guilg
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ImportarExcel {
    private SistemaClinicas back;

    public ImportarExcel(SistemaClinicas back) {
        this.back = back;
    }
    
    
    public void importar(String importPath) throws IOException{
        
        importPath.replace("\\", "\\\\");
        
        try (FileInputStream inputStream = new FileInputStream(importPath)) {
            XSSFWorkbook book = new XSSFWorkbook(inputStream);
            
            XSSFSheet enfermeiroSheet = book.getSheet("Enfermeiros");
            XSSFSheet medicosSheet = book.getSheet("Medicos");
            XSSFSheet pacienteSheet = book.getSheet("Pacientes");
            
            importarEnfermeiro(enfermeiroSheet);
            importarMedico(medicosSheet);
            importarPaciente(pacienteSheet);
            
            book.close();
        }
      }
    
    private void importarEnfermeiro(XSSFSheet sheet){
        // Pulando a primeira linha que tem o cabeçalho
        int startIndex = 1;

        // itero e preencho o objeto
        for (int i = startIndex; i <= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            
            if (row == null){
                continue;
            }
            
            Endereco end = new Endereco(
                    row.getCell(3).getStringCellValue(), 
                    (int) row.getCell(4).getNumericCellValue(), 
                    row.getCell(5).getStringCellValue(), 
                    row.getCell(6).getStringCellValue(), 
                    row.getCell(7).getStringCellValue(), 
                    (int) row.getCell(8).getNumericCellValue());
            
            ContatoTelEmail cont = new ContatoTelEmail(
                    row.getCell(9).getStringCellValue(), 
                    row.getCell(10).getStringCellValue(), 
                    row.getCell(11).getStringCellValue());
            
            if(row.getCell(12).getStringCellValue() == "Masculino"){
                Enfermeiro e = new Enfermeiro(
                    (long) row.getCell(0).getNumericCellValue(), 
                    row.getCell(15).getBooleanCellValue(), 
                    row.getCell(13).getStringCellValue(), 
                    (int) row.getCell(14).getNumericCellValue(), 
                    row.getCell(1).getStringCellValue(), 
                    row.getCell(2).getDateCellValue(), 
                    end, 
                    cont, 
                    Genero.MASCULINO);
                
                back.getEnfermeiros().add(e);
            }
            else{
                Enfermeiro e = new Enfermeiro(
                    (long) row.getCell(0).getNumericCellValue(), 
                    row.getCell(15).getBooleanCellValue(), 
                    row.getCell(13).getStringCellValue(), 
                    (int) row.getCell(14).getNumericCellValue(), 
                    row.getCell(1).getStringCellValue(), 
                    row.getCell(2).getDateCellValue(), 
                    end, 
                    cont, 
                    Genero.FEMININO);
                
                back.getEnfermeiros().add(e);
            }
            
            
        }
    }

    private void importarMedico(XSSFSheet sheet){
        // Pulando a primeira linha que tem o cabeçalho
        int startIndex = 1;
        
        // itero e preencho o objeto
        for (int i = startIndex; i <= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            
            if (row == null){
                continue;
            }
            
            Endereco end = new Endereco(
                    row.getCell(3).getStringCellValue(), 
                    (int) row.getCell(4).getNumericCellValue(), 
                    row.getCell(5).getStringCellValue(), 
                    row.getCell(6).getStringCellValue(), 
                    row.getCell(7).getStringCellValue(), 
                    (int) row.getCell(8).getNumericCellValue());
            
            ContatoTelEmail cont = new ContatoTelEmail(
                    row.getCell(9).getStringCellValue(), 
                    row.getCell(10).getStringCellValue(), 
                    row.getCell(11).getStringCellValue());
            
            if(row.getCell(12).getStringCellValue() == "Masculino"){
                Medico e = new Medico(
                    (long) row.getCell(0).getNumericCellValue(), 
                    (int) row.getCell(16).getNumericCellValue(), 
                    row.getCell(15).getBooleanCellValue(), 
                    row.getCell(13).getStringCellValue(), 
                    (int) row.getCell(14).getNumericCellValue(), 
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getDateCellValue(),
                    end, 
                    cont, 
                    Genero.MASCULINO,
                    row.getCell(17).getStringCellValue());
                
                back.getMedicos().add(e);
            }
            else{
                Medico e = new Medico(
                    (long) row.getCell(0).getNumericCellValue(), 
                    (int) row.getCell(16).getNumericCellValue(), 
                    row.getCell(15).getBooleanCellValue(), 
                    row.getCell(13).getStringCellValue(), 
                    (int) row.getCell(14).getNumericCellValue(), 
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getDateCellValue(),
                    end, 
                    cont, 
                    Genero.FEMININO,
                    row.getCell(17).getStringCellValue());
                
                back.getMedicos().add(e);
            }
            
            
        }
    }
    
   private ArrayList<Responsavel> loadResponsaveis(XSSFSheet sheetPai, long idPaciente){
       int startIndex = 1;
       
       XSSFWorkbook book = sheetPai.getWorkbook();
       XSSFSheet sheet = book.getSheet("Responsaveis");
       ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
       
        // itero e preencho o objeto
        for (int i = startIndex; i <= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            
            if (row == null){
                continue;
            }
            
            if((long) row.getCell(5).getNumericCellValue() == idPaciente){
                Responsavel r = new Responsavel(
                        (long) row.getCell(0).getNumericCellValue(), 
                        row.getCell(1).getStringCellValue(), 
                        row.getCell(2).getStringCellValue(), 
                        row.getCell(3).getStringCellValue(), 
                        row.getCell(4).getStringCellValue());
                
                responsaveis.add(r);
            }
            
        }
        return responsaveis;
   }
   private ArrayList<ConsultaMedica> loadConsultas(XSSFSheet sheetPai, long idPaciente){
       int startIndex = 1;
       
       XSSFWorkbook book = sheetPai.getWorkbook();
       XSSFSheet sheet = book.getSheet("Consultas Medicas");
       ArrayList<ConsultaMedica> consultas = new ArrayList<ConsultaMedica>();
       
        // itero e preencho o objeto
        for (int i = startIndex; i <= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            
            if (row == null){
                continue;
            }
            
            if((long) row.getCell(1).getNumericCellValue() == idPaciente){
                ConsultaMedica c = new ConsultaMedica(
                        (long) row.getCell(0).getNumericCellValue(),
                        idPaciente, 
                        (long) row.getCell(2).getNumericCellValue(),
                        row.getCell(6).getStringCellValue(), 
                        row.getCell(3).getStringCellValue(), 
                        row.getCell(5).getStringCellValue(),
                        row.getCell(4).getBooleanCellValue());
                
                consultas.add(c);
            }
            
        }
        return consultas;
   }
    private void importarPaciente(XSSFSheet sheet){
        // Pulando a primeira linha que tem o cabeçalho
        int startIndex = 1;
        
        // itero e preencho o objeto
        for (int i = startIndex; i <= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            
            if (row == null){
                continue;
            }
            
            Endereco end = new Endereco(
                    row.getCell(3).getStringCellValue(), 
                    (int) row.getCell(4).getNumericCellValue(), 
                    row.getCell(5).getStringCellValue(), 
                    row.getCell(6).getStringCellValue(), 
                    row.getCell(7).getStringCellValue(), 
                    (int) row.getCell(8).getNumericCellValue());
            
            ContatoTelEmail cont = new ContatoTelEmail(
                    row.getCell(9).getStringCellValue(), 
                    row.getCell(10).getStringCellValue(), 
                    row.getCell(11).getStringCellValue());
            
            if(row.getCell(12).getStringCellValue() == "Masculino"){
                Paciente e = new Paciente(
                    (long) row.getCell(0).getNumericCellValue(),
                    row.getCell(15).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getDateCellValue(),
                    end,
                    cont,
                    Genero.MASCULINO,
                    loadResponsaveis(sheet,
                            (long) row.getCell(0).getNumericCellValue()));
                
                e.setHistoricoConsultasMedicas(
                        loadConsultas(sheet, 
                        (long) row.getCell(0).getNumericCellValue()));
                back.getPacientes().add(e);
            }
            else{
                Paciente e = new Paciente(
                    (long) row.getCell(0).getNumericCellValue(),
                    row.getCell(15).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getDateCellValue(),
                    end,
                    cont,
                    Genero.FEMININO,
                    loadResponsaveis(sheet,
                            (long) row.getCell(0).getNumericCellValue()));
                
                e.setHistoricoConsultasMedicas(
                        loadConsultas(sheet, 
                        (long) row.getCell(0).getNumericCellValue()));
                
                back.getPacientes().add(e);
            }
            
            
        }
    }
    
}
