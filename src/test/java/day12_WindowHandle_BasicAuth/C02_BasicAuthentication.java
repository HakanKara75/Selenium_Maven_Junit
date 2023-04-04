package day12_WindowHandle_BasicAuth;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02_BasicAuthentication extends TestBase {
    /*
      Aşağıdaki bilgileri kullanarak authentication yapınız:

      Url: https://the-internet.herokuapp.com/basic_auth
      Username: admin
      Password: admin

      Başarılı girişi doğrulayın.
       */
    @Test
    public void newTabTest1() {
//https://the-internet.herokuapp.com/basic_auth sayfasina gidin, kullanici adi sifre giriniz
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(2);

    //paragrafin "congratulations" kelimesini icerdigini dogrulayin
        String paragraf=driver.findElement(By.xpath("//p")).getText();
        assertTrue(paragraf.contains("Congratulations!"));

    }


}
