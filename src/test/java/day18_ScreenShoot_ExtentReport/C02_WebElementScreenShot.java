package day18_ScreenShoot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {
    @Test
    public void test() throws IOException {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

    //Arama bölümünde iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

    //Sonuc yazısının resmini alınız
        WebElement sonucYazisi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String tarih=new SimpleDateFormat("_hh__mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu= "TestOutput/webElementScreenShot"+tarih+".png";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    /*
            Sadece bir webelementin resmini almak istersek, FileUtils.copyFile() methoduyla locate ettiğimiz
        webelementi getScreenshotAs() methoduyla kullanarak resmini alabiliriz
         */




    }
}
