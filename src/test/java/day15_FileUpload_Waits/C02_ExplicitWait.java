package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_ExplicitWait extends TestBase {
    /*
   https://the-internet.herokuapp.com/dynamic_loading/1
   Start buttonuna tıklayın
   Hello World! Yazının sitede oldugunu test edin
    */
    @Test
    public void test(){
//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//        Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

//        Hello World! Yazının sitede oldugunu test edin
//        WebElement helloText= driver.findElement(By.xpath("//div[@id='finish']/h4"));
//        assertTrue(helloText.isDisplayed());
        //element gorunurlugu sonradan geliyor. Implicit wait ise yaramadi. Explicit wait kullanacagiz

    }
}
