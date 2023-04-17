package day19_WebTables_ReadExcel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {


    /*       https://the-internet.herokuapp.com/tables sayfasına gidin
        Task 1 : Table1’i yazdırın
        Task 2 : 3. Satır verilerini yazdırın
        Task 3 : Son satirin verileri yazdırın
        Task 4 : 5. Sütun verilerini yazdırın
        Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        Parameter 1 = satır numarası
        Parameter 2 = sütun numarası
        printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

      */
    @Test
    public void table1Print() {
//    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

//    Task 1 : Table1’i yazdırın
        String table1 = driver.findElement(By.id("table1")).getText();
        System.out.println("Table1");
        System.out.println(table1);

        //elementleri tek tek yazdıralım
        List<WebElement> list = driver.findElements(By.id("//table[@id='table1']//td"));
        for (WebElement w : list) {
            System.out.println(w.getText());
        }

        //Lambda ile:
        list.forEach(t -> System.out.println(t.getText() + "==>>"));

    }

    @Test
    public void task2() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 2 : 3. Satır verilerini yazdırın
        List<WebElement> satir3List = driver.findElements(By.xpath("//table[@id='table1']//tr[3]/td"));

        satir3List.forEach(t -> System.out.print(t.getText() + " | "));
    }

    @Test
    public void task3() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 3 : Son satirin verileri yazdırın
        List<WebElement> sonSatirList = driver.findElements(By.xpath("//table[@id='table1']//tr[last()]/td"));
        //last() ile son satir indeksi girilebilir

        sonSatirList.forEach(t -> System.out.print(t.getText() + " | "));
    }

    @Test
    public void task4() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 4 : 5. Sütun verilerini yazdırın
        List<WebElement> sonSatirList = driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
        //last() ile son satir indeksi girilebilir

        sonSatirList.forEach(t -> System.out.print(t.getText() + " | "));
    }

    public void printData(int satir, int sutun) {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        WebElement belirliVeri = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + satir + "]/td[" + sutun + "]"));

        System.out.println(belirliVeri.getText());
    }

    @Test
    public void task5() {
        //    Parameter 1 = satır numarası
//    Parameter 2 = sütun numarası
//    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        printData(2, 3);
        printData(3, 5);

    }


}
