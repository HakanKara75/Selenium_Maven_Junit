package day14_Faker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    /*
"https://techproeducation.com/" gidin
İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
     */
    @Test
    public void test(){
//"https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com/");

//İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

WebElement searchBox=driver.findElement(By.xpath("//input[@name='s']"));
        Actions actions=new Actions(driver);
        actions.
                keyDown(searchBox, Keys.SHIFT).
                sendKeys("techpro ").
                keyUp(Keys.SHIFT).  //buraya searchBox,Keys.SHIFT yaparsak ilk yazilani siler, ustune yazar. HATA
                sendKeys("education"+Keys.ENTER).
                build().perform();





    }
}
