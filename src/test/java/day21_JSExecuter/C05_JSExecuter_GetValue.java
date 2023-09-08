package day21_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_JSExecuter_GetValue extends TestBase {    //  1)getValueTest metotu olustur
// 2)https://www.priceline.com/ a git
//  3)Tarih kısmındaki Yazili metinleri al ve yazdır

    @Test
    public void name() {

        //  1)getValueTest metotu olustur
// 2)https://www.carettahotel.com/ a git
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

//  3)Tarih kısmındaki Yazili metinleri al ve yazdır
    String webElement=driver.findElement(By.id("checkin_date")).getText();
//        System.out.println(webElement); bu kod calismadi

        //1.yol
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//       String str= js.executeScript("return document.getElementById('checkin_date').value").toString();
//        System.out.println(str);


        //2.yol metot ile
        getValueByJavaScript("checkin_date", "value");
    }
}
