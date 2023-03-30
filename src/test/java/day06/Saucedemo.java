package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Saucedemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //        "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

//        Username kutusuna "standard_user" yazdirin
        WebElement arama= driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"));
        arama.sendKeys("standard_user");

//        Password kutusuna "secret_sauce" yazdirin
        WebElement password= driver.findElement(with(By.tagName("input")).below(arama));
        password.sendKeys("secret_sauce");

//        Login tusuna basin
        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

//        Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun=driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]"));
        String ilkUrunStr=ilkUrun.getText();
        System.out.println(ilkUrunStr);
        ilkUrun.click();
        Thread.sleep(2000);

//        Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

//        Alisveris sepetine tiklayin
        WebElement sepet=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();

//        Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement element = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        if(element.isDisplayed()){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");

//        Sayfayi kapatin
            driver.close();
    }
}
}