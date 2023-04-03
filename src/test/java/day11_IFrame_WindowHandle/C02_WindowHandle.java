package day11_IFrame_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class C02_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {
//        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//        İlk sayfanın ID'sini alın.
        String window1Handle = driver.getWindowHandle();
        System.out.println(window1Handle);

//        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement window1Text = driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        assertEquals("Opening a new window", window1Text.getText());

//        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String sayfaBasligi = driver.getTitle();
        System.out.println(sayfaBasligi);
        assertEquals("The Internet", sayfaBasligi);

//        "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

//        Açılan pencereye geçin.
        Set<String> allWindowHandels = driver.getWindowHandles();
        for (String w : allWindowHandels) {
            if (!w.equals(window1Handle)) {
                driver.switchTo().window(w);
            }
        }

//                Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        assertEquals("New Window", driver.getTitle());
        String window2Handle=driver.getWindowHandle();

//        Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(window1Handle);
        assertEquals("The Internet", driver.getTitle());

//        2. pencereye tekrar geçin.
        driver.switchTo().window(window2Handle);

//        1. pencereye tekrar dönün.
        driver.switchTo().window(window1Handle);
    }
}
