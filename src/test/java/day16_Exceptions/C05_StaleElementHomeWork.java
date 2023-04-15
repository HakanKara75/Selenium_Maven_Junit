package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_StaleElementHomeWork extends TestBase {
    /*
     public void StaleElementReferanceExceptionTest5() {
        /*
        NOT:StaleElementReferanceException hatası almamız gerekiyor
        //Amazon sayfasına gidelim
        //iphone aratalım
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        //Sayfayı kapatalım
         */


   /*

        NOT:Exception almadan doğru şekilde yapalım
        //Amazon sayfasına gidelim
        //iphone aratalım
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        //Sayfayı kapatalım

     */
    @Test
    public void test1(){
        //NOT:StaleElementReferanceException hatası almamız gerekiyor
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //iphone aratalım
        driver.findElement(By.id("twotavsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler=driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < urunler.size() ; i++) {
            urunler.get(i).click();
            bekle(3);
            driver.navigate().back(); //geri gittigi icin locate sifirlandı. locate for disinda. hata verecek
            bekle(3);
            if (i==4){
                break;
            }
        }

    }
    @Test
    public void test2(){
       // NOT:Exception almadan doğru şekilde yapalım
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //iphone aratalım
        driver.findElement(By.id("twotavsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
              List<WebElement> urunler=driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < urunler.size() ; i++) {
            urunler.get(i).click();
            bekle(3);
            driver.navigate().back(); //geri gittigi icin locate sifirlandı. locate for disinda. hata verecek
            bekle(3);
            if (i==4){
                break;
            }
            urunler=driver.findElements(By.xpath("//h2")); //for icine aldik. locate tekrar alinacak
        }
    }
}
