package day20_ReadExcel_WriteExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    /*
Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
(D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
 */

    @Test
    public void test() throws IOException {
        //dosyayi al
        Workbook workbook= WorkbookFactory.create(new FileInputStream("src/test/java/resources/Capitals.xlsx"));

        //1.satir 3. sutuna gel
        Sheet sheet= workbook.getSheet("Sheet1");
        Cell cell= sheet.getRow(0).createCell(2);

    //   Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
        cell.setCellValue("NÜFUS"); //henüz excell dosyasina yazdirilmadigi icin dosyamizda gorulmez

        System.out.println(cell);

     //   (D.C: 712816, Paris: 2161000, London: 8982000, Athens: 5663000 ...)
        sheet.getRow(1).createCell(2).setCellValue(712816);
        sheet.getRow(2).createCell(2).setCellValue(2161000);
        sheet.getRow(3).createCell(2).setCellValue(8982000);
        sheet.getRow(4).createCell(2).setBlank(); //bos bırakıyor
        sheet.getRow(5).createCell(2).setCellValue(8982000);
        sheet.getRow(6).createCell(2).setBlank(); //bos bırakıyor
        sheet.getRow(7).createCell(2).setCellValue(2437396);


        FileOutputStream fileOutputStream=new FileOutputStream("src/test/java/resources/Capitals.xlsx");
        workbook.write(fileOutputStream);


    }
}
