package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C04_ExplicitWait extends TestBase {
    /*
https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
Add tuşuna basın
"It's gone!" yazısını doğrulayın
     */
    @Test
    public void test(){
//        https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//        Remove tuşuna basın
        bekle(2);
driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

//        "It's gone!" yazısını doğrulayın
assertTrue(driver.findElement(By.id("message")).isDisplayed());

//Enable tuşuna basın
driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

// 'It's enabled!' yazisinin gorunur oldugunu test edin
        assertTrue(driver.findElement(By.xpath("//form[@id='input-example']/p")).isDisplayed());
    }
}
