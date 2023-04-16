package day10_Alert_Iframe;

import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_AlertMethods extends TestBase {
    public void sendKeysAlert(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(3);
        //    Bir metod olusturun: sendKeysAlert
//3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna   tıklayın

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        alertprompt("Hakan Kara");
        bekle(3);
        alertAccept();


        //  result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedTesult= "Hakan Kara";
        Assert.assertTrue(actualResult.contains(expectedTesult));

    }
}
