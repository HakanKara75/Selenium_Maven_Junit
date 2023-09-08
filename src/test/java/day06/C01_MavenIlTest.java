package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_MavenIlTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        1.https://www.amazon.com/ sayfasına gidelim
        driver.get("https://www.amazon.com");

//        2.Arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

//        3.“Samsung headphones” ile arama yapalım
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

//        4.Bulunan sonuç yazısını yazdıralım
        WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("arama sonucu: "+aramaSonucu.getText());

//        5.İlk ürünü tıklayalım
        WebElement urunSec=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        urunSec.click();
        //2.yol: arama sonucu cikan tum urunler list icine koyulur. get(0) diyerek list icinden ilk elemana tiklanir.
//        List<WebElement> urunSec=driver.findElements(By.xpath("//img[@class='s-image']"));
//        urunSec.get(0).click();

//        6.Sayfadaki tüm başlıkları yazdıralım
        List<WebElement> basliklar=driver.findElements(By.xpath("//h1"));
        for (WebElement w: basliklar){
            System.out.println(w.getText());
        }
        //2.yol: lambda ile
        basliklar.forEach(t-> System.out.println(t.getText()));

        driver.close();
    }
}
