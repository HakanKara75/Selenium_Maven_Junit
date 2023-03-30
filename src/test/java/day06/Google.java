package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Google {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01() throws InterruptedException {
    //    https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //google basliginin olup olmadigini kontrol edin
        String google = driver.getTitle();
        if (google.equals("Google"))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");

//    Arama cubuguna "Nutella" yazip aratin
        WebElement arama = driver.findElement(By.xpath("//input[@jsaction='paste:puy29d;']"));
        arama.sendKeys("Nutella" + Keys.ENTER);

//    Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String snc = sonuc.getText();
        System.out.println(snc);

//    sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        String[] sayi = snc.split(" ");
        String sonuc1 = sayi[1];
        String duzelmis = sonuc1.replaceAll("\\D", "");
        System.out.println("Sonuc:" + sonuc1);
        int yaz = Integer.parseInt(duzelmis);

        String kesinSonuc = yaz > 10000000 ? "Buyuktur" : "10 milyondan kucuk";
        System.out.println(kesinSonuc);


        Thread.sleep(3000);


//    Sayfayi kapatin
//driver.close();


    }
}
