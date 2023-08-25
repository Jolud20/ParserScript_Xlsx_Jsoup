package service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.io.File;
import java.io.FileOutputStream;
//Создаёт xlsx файл для данных с 5 столбцами
public class CreateXlsx {
    public void createxls() throws FileNotFoundException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Жилые комплексы "+ LocalDate.now().getYear());
        sheet.setColumnWidth(0,4000);
        sheet.setColumnWidth(1,8000);
        sheet.setColumnWidth(2,9000);
        sheet.setColumnWidth(3,4000);
        sheet.setColumnWidth(4,4000);


        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Название ЖК");
        row.createCell(1).setCellValue("Застройщик");
        row.createCell(2).setCellValue("Адрес");
        row.createCell(3).setCellValue("Срок сдачи");
        row.createCell(4).setCellValue("Класс ЖК");

        File file = new File("Жилые комплексы "+ LocalDate.now() +".xlsx");
        try(FileOutputStream out=new FileOutputStream(file)){
            workbook.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}