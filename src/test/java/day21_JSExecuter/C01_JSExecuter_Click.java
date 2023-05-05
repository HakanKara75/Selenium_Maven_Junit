package day21_JSExecuter;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C01_JSExecuter_Click extends TestBase {
    /*
http://www.uitestpractice.com/Students/Form sayfasına git
Formu doldur
Submit tuşuna tıkla
Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
*/
    @Test
    public void name() {
/*
        Eğer bir web sayfasının HTML kodları tamamen yada kısmen JavaScript kullanılarak oluşturulduysa
     o sayfaya müdahale etmek için genellikle JavaScriptExecutor arayüzünü kullanmak gerekir.
        Bu durumda, sayfayı manipüle etmek veya etkileşimde bulunmak için standart WebDriver komutları
     yetersiz kalabilir. Bu nedenle JSExecutor arayüzü, sayfanın JS kodlarına doğrudan erişebilir.
        Ancak, mümkünse WebDriver'in sunduğu standart yöntemlerle sorunları çözmek her zaman daha iyidir.
     Çünkü JS kullanımı, sayfanın daha yavaş yüklenmesine neden olabili.
    */

//http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");
        uitestReklamKapat();
        bekle(2);

//Formu doldur
        driver.findElement(By.id("firstname")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        bekle(2);
        WebElement webElement=driver.findElement(By.id("sel1"));
        Select select=new Select(webElement);
        select.selectByIndex(12);
        driver.findElement(By.id("datepicker")).sendKeys("2023-03-27");

//Submit tuşuna tıkla
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        //submitButton.click();//ElementClickInterceptedException. </button> is not clickable at point+
        //1. adim: driveri JavascriptExecutor classina cast ettik
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //2.adim executeScript() ile uygun scripti calistiriyoruz
        jse.executeScript("arguments[0].click();", submitButton);

//metot ile
//clickByJavaScript(submitButton);

//Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        assertEquals("http://www.uitestpractice.com/Students/Form?optradio=on", driver.getCurrentUrl());


    }

    public void uitestReklamKapat() {
        try {
            driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
            driver.findElement(By.xpath("//path[@stroke='#FAFAFA']")).click();
            Thread.sleep(2000);
        } catch (Exception s) {

        }
    }
}
