package day18_ScreenShoot_ExtentReport;

import org.junit.Test;
import utilities.TestBase;

public class C01_ScreenShot extends TestBase {
    @Test
    public void test() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //sayfanin resmini alalim
        tumSayfaScreenShoot(); //Method kullanarak tüm ekran resmini aldık

        //Sonra amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Amazon sayfasının ekran görüntüsünü alalım
        tumSayfaScreenShoot(); //Method kullanarak tüm ekran resmini aldık

    }
}
