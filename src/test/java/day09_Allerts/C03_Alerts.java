package day09_Allerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_Alerts extends TestBase {

    @Test
    public void alerts() throws InterruptedException {
        //    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        Thread.sleep(2000);

//    Bir metod olusturun: acceptAlert
//1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


        String actualText= driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText= "You successfully clicked an alert";
        Assert.assertTrue(actualText.contains(expectedText));
    }
    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        Thread.sleep(2000);
        //    Bir metod olusturun: dismissAlert
//2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
// “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        String actualText= driver.findElement(By.xpath("//p[@style='color:green']")).getText();
        String expectedText= "successfuly";
        Assert.assertFalse(actualText.contains(expectedText));

    }

@Test
    public void sendKeysAlert() throws InterruptedException {
    driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
    Thread.sleep(2000);
    //    Bir metod olusturun: sendKeysAlert
//3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
}




}
