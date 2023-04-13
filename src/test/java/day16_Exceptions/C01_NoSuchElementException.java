package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum

        driver.findElement(By.xpath("//input[@type='searchh']")).//org.openqa.selenium.NoSuchElementException: Web element bulunamadığında alınır.
                sendKeys("QA" + Keys.ENTER); //Cunku search yerine fazladan h harfi girip searchh yaptik. elementi bulamadi.

    }


}
