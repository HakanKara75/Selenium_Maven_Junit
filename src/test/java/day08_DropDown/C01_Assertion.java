package day08_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C01_Assertion {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://amazon.com adresinegidin
        driver.get("https://amazon.com");
//        WebElement soru = driver.findElement(By.xpath("//input[@data-action-params='{\"toasterType\":\"AIS_INGRESS\"}']"));
//        soru.click();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //    Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
        //            ○ title Test  => Sayfa başlığının “Amazon” oldugunu test edin
        Thread.sleep(3000);
        String actualtitle = driver.getTitle();
        String expectedtitle = "Amazon";

        boolean iceriyorMu = actualtitle.contains(expectedtitle);
        Assert.assertTrue(iceriyorMu);

    }

    @Test
    public void test02() throws InterruptedException {

        //            ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        boolean imageIsDisplayed=image.isDisplayed();
        assertTrue(imageIsDisplayed);
        Thread.sleep(2000);
    }

    @Test
    public void test03() throws InterruptedException {
//            ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
       WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
       assertTrue(searchBox.isEnabled());
        Thread.sleep(2000);
    }
    @Test
    public void test04() throws InterruptedException {
        //            ○ wrongTitleTest => Sayfa basliginin “amazon” olmadigini dogrulayin
     String actualTitle=driver.getTitle();
     String expectedTitle="amazon";
     assertFalse(actualTitle.contains(expectedTitle));
    }
}