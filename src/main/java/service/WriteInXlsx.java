package service;

import Entity.Developer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

//Запись в Xlsx сущности Developer
public class WriteInXlsx {
    Row row1;
    public void writeInFile(List<Developer> list) throws IOException {
        File file = new File("Жилые комплексы "+ LocalDate.now() +".xlsx");
        if(!file.exists()){
            CreateXlsx createXlsx = new CreateXlsx();
            createXlsx.createxls();
        }
        FileInputStream in=new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (var i: list){
            int lastRow = sheet.getLastRowNum()+1;
            row1 =sheet.createRow(lastRow);
            row1.createCell(0).setCellValue(i.getName());
            row1.createCell(1).setCellValue(i.getDeveloperName());
            row1.createCell(2).setCellValue(i.getAdress());
            row1.createCell(3).setCellValue(i.getDate());
            row1.createCell(4).setCellValue(i.getClassDeveloper());
        }
        try(FileOutputStream out=new FileOutputStream(file)){
            workbook.write(out);
        }catch (IOException e){
            e.printStackTrace();
        }
        in.close();
    }
}
