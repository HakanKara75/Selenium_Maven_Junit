import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("chromeDriver", "src/source/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //a.	https://yahoo.com adresine gidiniz.
        driver.get("https://www.automationexercise.com/login");

        WebElement mailGir=driver.findElement(By.xpath("//input[@type='password']"));
        WebElement click=driver.findElement(with(By.tagName("input")).above(mailGir));
        click.click();

        click.sendKeys("istanbul@evim.com");
        mailGir.sendKeys("12345"+Keys.ENTER);

/*

2.	Main method oluşturun ve aşağıdaki görevi tamamlayın.

b.	Sign in butonuna basin
c.	email textbox,password textbox, and signin button elementlerini locate ediniz..
d.	Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
i.	Username : testtechproed@gmail.com
ii.	Password : Test1234!
e.	Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
f.	“Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
3.	Sayfada kac tane link oldugunu bulun.
         */



    }
}
