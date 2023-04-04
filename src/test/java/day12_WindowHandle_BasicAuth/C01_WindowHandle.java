package day12_WindowHandle_BasicAuth;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C01_WindowHandle extends TestBase {
    @Test
    public void newTabTest1() {
//        https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

//        Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assertEquals("Techpro Education | Online It Courses & Bootcamps", driver.getTitle());
        bekle(3);

//        Tab 2'de https://www.youtube.com sayfasını açınız. sayfa basliginin "https://www.youtube.com" oldugunu dogrulayin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        assertEquals("https://www.youtube.com", driver.getTitle());
        bekle(3);

//        Tab 3'te https://www.linkedin.com sayfasını açınız. sayfa basliginin "LinkedIn" icerdigini dogrulayin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));
        bekle(3);

//        techproeducation sayfasına geçiniz
        List<String> windowHandleList= new ArrayList<>(driver.getWindowHandles());
        bekle(3);
        driver.switchTo().window(windowHandleList.get(0));

//        youtube sayfasına geçiniz
        driver.switchTo().window(windowHandleList.get(1));
        bekle(3);

//        linkedIn sayfasına geçiniz
        driver.switchTo().window(windowHandleList.get(2));
        bekle(3);

    }

    @Test
    public void newTabTest2() {
        //        https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

//        Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assertEquals("Techpro Education | Online It Courses & Bootcamps", driver.getTitle());

//        Tab 2'de https://www.google.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"));

//        Tab 3'te https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));

//        techproeducation sayfasına geçiniz
        switchTab(0);

//        youtube sayfasına geçiniz
        switchTab(1);

//        linkedIn sayfasına geçiniz
        switchTab(2);

    }


}