package day11_IFrame_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {
    @Test
    public void iframe01(){
//        https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

//        Kalın yazının "Editor" kelimesimi içerdiğini doğrulayınız
String str=driver.findElement(By.xpath("//h3")).getText();
Assert.assertTrue(str.contains("Editor") );

//        Textbox içindeki yazıyı siliniz.
        WebElement iFrame= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);

        WebElement textBox = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        textBox.clear();

//        Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

//                Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elemantalSelemium= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elemantalSelemium.isDisplayed());

    }



}
