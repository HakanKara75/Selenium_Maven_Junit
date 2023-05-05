package day14_Faker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class SSG_FileExists extends TestBase {

    @Test
    public void name() {
        String dosyaYolu= "C:/Users/Hakan Batirhan.DESKTOP-KA8SOKR/Desktop/data.xlsx";

        assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    @Test
    public void teste()  {
        //user.home bilgisayarin ortak yolunu verir
        //user.dir serverin ortak yolunu verir
        System.out.println(System.getProperty("user.home")); //C:\Users\Hakan Batirhan.DESKTOP-KA8SOKR
        String farkliYol= System.getProperty("user.home");

        String ortalYol= System.getProperty("/Desktop/data.xlsx");
        String dosyaYolu= farkliYol+ortalYol;
        assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
    @Test
    public void test2() {
     driver.get("https://bonigarcia.dev/selenium-webdriver-java/download.html");
     driver.findElement(By.xpath("//*[text()='WebDriverManager logo']")).click();
     bekle(5);
        String dosyaYolu= "C:/Users/Hakan Batirhan.DESKTOP-KA8SOKR/Downloads/webdrivermanager.png";
        //tekrar eden dosya indirmelerde dosyayi silmek icin
        File silinecekDosya= new File(dosyaYolu);
        System.out.println(silinecekDosya);

     //2.yol
//        String farkliYol= System.getProperty("user.home");
//        String ortalYol= System.getProperty("/Downloads/webdrivermanager.png");
//        String dosyaYolu= farkliYol+ortalYol;

     assertTrue(Files.exists(Paths.get(dosyaYolu)));
        driver.close();
    }

}
