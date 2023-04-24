package day21_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_Type extends TestBase {
    /*
Techpro education ana sayfasina git
Arama kutusuna QA yaz
*/
    @Test
    public void name() {

//Techpro education ana sayfasına git
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

//Arama kutusuna QA yaz
        WebElement webElement=driver.findElement(By.xpath("//input[@placeholder='Search...']"));
        //1.yol
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('value', 'QA')", webElement);


        //2.yol metot ile
        typeWithJavaScript(webElement, "QA");
    }
}
