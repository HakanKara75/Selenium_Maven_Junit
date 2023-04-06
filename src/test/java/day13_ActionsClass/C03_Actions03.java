package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {

      /*
https://techproeducation.com adresine gidin
 Sayfanın alt tarafına gidin
 Sayfanın üst tarafına gidin
 */

    @Test
    public void name() {
//        https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");

        WebElement reklam=driver.findElement(By.xpath("//i[@class='eicon-close']"));
        if (reklam.isDisplayed())
                reklam.click();

//        Sayfanın alt tarafına gidin
        Actions actions=new Actions(driver);
        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        bekle(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

//        Sayfanın üst tarafına gidin
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).perform();
        bekle(2);




    }
}
