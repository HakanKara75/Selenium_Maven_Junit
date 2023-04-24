package day21_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Scroll extends TestBase {
    /*
    Techpro education ana sayfasına git
    We Offer elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
    Aynı sayfada Enroll Free elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada WHY US? elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada tekrar Enroll Free elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
     */
    @Test
    public void name() {

//Techpro education ana sayfasına git
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

//We Offer elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement webElement= driver.findElement(By.xpath("//span[text()='we offer']"));

//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", webElement);

      scrollIntoViewByJavaScript(webElement);
      tumSayfaScreenShoot();
        bekle(2);

//Aynı sayfada Enroll Free elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement webElement1= driver.findElement(By.xpath("//span[text()='Enroll Free Course']"));
                scrollIntoViewByJavaScript(webElement1);
                tumSayfaScreenShoot();
                bekle(2);


//Aynı sayfada WHY US? elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement webElement2= driver.findElement(By.xpath("//h3[text()='WHY US?']"));
        scrollIntoViewByJavaScript(webElement2);
        tumSayfaScreenShoot();
        bekle(2);

//Aynı sayfada tekrar Enroll Free elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        scrollIntoViewByJavaScript(webElement1);
        tumSayfaScreenShoot();
        bekle(2);


        //sayfayi en alta goturur
       scrollEndByJavaScript();
       bekle(2);

        //sayfayi en yukari goturur
        scrollTopByJavaScript();
        bekle(2);
    }
}
