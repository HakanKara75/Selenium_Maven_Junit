package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    /*
   https://the-internet.herokuapp.com/dynamic_loading/1
   Start buttonuna tıklayın
   Hello World! Yazının sitede oldugunu test edin
    */
    @Test
    public void test() {
//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//        Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

//        Hello World! Yazının sitede oldugunu test edin
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)). //toplamda 30 saniye bekle
                        pollingEvery(Duration.ofSeconds(3)). //3'er saniye aralikla bekle sonra işlemi tekrarla
                        withMessage("Ignore Exception").ignoring(NoSuchMethodException.class);
        WebElement helloText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='xfinish']/h4")));
    }

}
