package day20_ReadExcel_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
  /*
Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
Kullanılan satır sayısın bulun
Ülke-Başkent şeklinde verileri yazdırın
 */
@Test
    public void test() throws IOException {
    //Dosyayi al:
    FileInputStream fileInputStream= new FileInputStream("src/test/java/resources/Capitals.xlsx");

    //FileInputStream objesini WorkBook (excel) dosyasi olarak aç
    Workbook workbook=WorkbookFactory.create(fileInputStream);

    //sayfayi ac
    Sheet sheet1=workbook.getSheet("Sheet1");

    //satira(row) git
    Row row=sheet1.getRow(0); //index 0'dan baslar. 1.satir indexi 0'dir.

    //1.hucreyi (cell) al
    Cell cell=row.getCell(0);
    System.out.println(cell);

//    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
Cell cell12=sheet1.getRow(0).getCell(1);
    System.out.println(cell12);

//    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    Cell cell2=sheet1.getRow(2).getCell(0);
    System.out.println(cell2);
    Assert.assertEquals("France",cell2.toString() );

//    Kullanılan satır sayısın bulun
    int sonKullanilanSatirIndexi= sheet1.getLastRowNum();
    System.out.println(sonKullanilanSatirIndexi); //en son veri girilen satirin indexi -->19
    int kullanilanToplamSatirSayisi= sheet1.getPhysicalNumberOfRows();
    System.out.println(sheet1.getPhysicalNumberOfRows());//toplam kullanilmis satir sayisi -->12

//    Ülke-Başkent şeklinde verileri yazdırın
    Map<String , String > ulkelerVeBaskentleri= new HashMap<>();

    try {
        for (int satirIndeks = 1; satirIndeks < kullanilanToplamSatirSayisi; satirIndeks++) {

            String ulkeAdi = sheet1.getRow(satirIndeks).getCell(0).toString();
            String baskentAdi = sheet1.getRow(satirIndeks).getCell(1).toString();

            ulkelerVeBaskentleri.put(ulkeAdi, baskentAdi);

        }
    }catch (Exception e){

    }
    System.out.println(ulkelerVeBaskentleri);
}




}
