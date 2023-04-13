package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementException extends TestBase {
    @Test
    public void test() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum

        driver.navigate().refresh();
        WebElement login= driver.findElement(By.linkText("LMS LOGIN"));
        login.click(); //calisti
    }

    @Test
    public void test1() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum


        WebElement login= driver.findElement(By.linkText("LMS LOGIN"));
        driver.navigate().refresh(); //refresh yaptigimiz icin yukaridaki login adresi silindi.
        // org.openqa.selenium.StaleElementReferenceException
        login.click(); //calismadi.
    } //Locator doğru fakat adres refresh sonrası silindiği için "lmsLogin" container'ı artık kullanılamaz. Yeniden locate gerekir.

    @Test
    public void test2() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum


        WebElement login= driver.findElement(By.linkText("LMS LOGIN"));

        login.click();
        driver.navigate().back(); // https://techproeducation.com sayfasina geri dondum
        //Sayfa yeniden yüklendiği için locator adresi silindi.
        login.click(); // calismadi. org.openqa.selenium.StaleElementReferenceException aldik
    }

    @Test
    public void test3() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum


        WebElement login= driver.findElement(By.linkText("LMS LOGIN"));

        login.click();
        driver.navigate().back(); // https://techproeducation.com sayfasina geri dondum
       // Sayfa yeniden yüklendiği için locator adresi silindi.

        login= driver.findElement(By.linkText("LMS LOGIN"));// yeniden atama yaptigim icin test2 gibi hata vermez
        login.click();
    }
    @Test
    public void test4() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum


        WebElement login= driver.findElement(By.linkText("LMS LOGIN"));
        login.click();

        driver.get("https://techproeducation.com"); //LMS'e gittikten sonra techproeducation sayfasına geri dönerek sayfayı yenilemiş oluyorum.
        try {
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklam cikarsa kapatıyorum
        }catch (Exception e){ //reklam cikmazsa try/catch nosuchelementexception verilmesini engelliyor

        }

        login.click(); // org.openqa.selenium.StaleElementReferenceException
    }
}
