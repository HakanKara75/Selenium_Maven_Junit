package day18_ScreenShoot_ExtentReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_ScreenShotClassWork extends TestBase {
    @Test
    public void test(){
    //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
       bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum

    //sayfanin resmini alalim
        tumSayfaScreenShoot();

    //Arama bolumunde java aratalim
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("java", Keys.ENTER);

    //sonuc yazisinin resmini alalim
        WebElement sonucYazisi= driver.findElement(By.xpath("//h1"));
        webElementScreenShoot(sonucYazisi); //Method kullanarak Webelementin resmini aldık

    //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

    //sayfanin resmini alalim
        tumSayfaScreenShoot();

    //arama bolumunde iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

    //sonuc yazisinin resmini alalim.
        WebElement sonucYazisi2= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        webElementScreenShoot(sonucYazisi2); //Method kullanarak Webelementin resmini aldık

    //Tekrar techproeducation sayfasina gecelim
        window(0); //method kullanarak onceki sayfaya gectim

    //sayfanin resmini alalim
        tumSayfaScreenShoot();

    }


}
