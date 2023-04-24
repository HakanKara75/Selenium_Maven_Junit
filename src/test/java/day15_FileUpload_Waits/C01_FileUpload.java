package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C01_FileUpload extends TestBase {
    /*
    https://the-internet.herokuapp.com/upload adresine gidin
    logo.jpeg dosyasını yükleyin(uopload)
    "File Uploaded!" textinin görüntülendiğini test edin
    */
    @Test
    public void test(){
//        https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");

//        logo.jpeg dosyasını yükleyin(uopload)
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        bekle(2);
                                                    //"C:/Users/TechProEd/Desktop/logo.jpeg"
        chooseFile.sendKeys(System.getProperty("user.home")+"/Desktop/logo.jpeg");
        bekle(2);

        driver.findElement(By.id("file-submit")).click();

//        "File Uploaded!" textinin görüntülendiğini test edin
        String actualText= driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
       String expectedText="File Uploaded!";
        assertEquals(actualText, expectedText);

        //2.yol
        WebElement fileUploadedText = driver.findElement(By.xpath("//h3"));
        assertTrue(fileUploadedText.isDisplayed());

    }

}
