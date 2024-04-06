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
            
            importarEnfermeiro(enfermeiroSheet);
            
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
    
}
