package day18_ScreenShoot_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_ExtentsReport extends TestBase {
    /*
EXTENTREPORT kullanabilmemiz icin;
1-pom.xml dosyasina extentreport dependency'si eklenir
2-ExtentReport class'indan bir obje olusturulur
3-HTML formatinda duzenlenecegi icin ExtentHtmlReporter class'indan obje olusturulur.
4-Rapora test ile ilgili bilgiler girebilmek icin ExtentTest class'indan bir obje olusturulur
*/


    @Test
    public void test() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh__mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/Reports/extentReports" + tarih + ".html";
        extentHtmlReporter=new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

//Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Hakan");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");

        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Amazon sayfasında iphone araması yapıldı");
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi.getText());
        extentTest.info("Sonuc yazısı konsola yazdırıldı");
        extentTest.pass("Sayfa kapatıldı");

    }
}
