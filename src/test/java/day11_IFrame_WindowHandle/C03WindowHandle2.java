package day11_IFrame_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C03WindowHandle2 extends TestBase {
    @Test
    public void test01() {
//https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproeducationWindowHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assertEquals("Techpro Education | Online It Courses & Bootcamps", driver.getTitle());

//Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

//techproeducation sayfasına geçiniz:
        bekle(2);
        driver.switchTo().window(techproeducationWindowHandle);

//youtube sayfasına geçiniz:
        bekle(2);
        driver.switchTo().window(youtubeWindowHandle);

//linkedIn sayfasına geçiniz:
        bekle(2);
        driver.switchTo().window(linkedinWindowHandle);

    }
}
