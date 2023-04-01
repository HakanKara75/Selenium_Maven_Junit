package day09_Allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

/*DropDown Nasıl Automate Edilir;
        ➢ Adim1: Dropdown menuyu herhangi bir locator ile locate edin.
        WebElement ddm=driver.findElement(By.id("value of id"));
        ➢ Adim 2: Yeni bir "Select" objesi olusturun ve daha once locate ettigimiz WebElement'i parametre olarak yeni objeye ekleyin
        Select options=new Select(ddm);
        ➢ Adim 3: Select class'indan kullanabileceginiz 3 yontemden biriyle dropdown menusundeki elemananlardan istediginizi secin
        options.selectByIndex(1);

 */
public class C01_DropDown {
   /*
           -DropDown Nedir : Altbaşlıkların olduğu açılır menü listesi
    -DropDown nasıl automate edilir(Handle):
           a-DropDown menuyu ilk olarak locate ederiz
           b-Select objesi oluştururuz
           c-Select objesinin ddm webelementi'nin içeriğine ve seçeneklerine
           erişim sağlaması için SELECT sınıfına arguman olarak locate ettiğimiz webelementi koyarız
           Syntax: Select select = new Select(ddm webelement)
           d-Select class'ı, sadece <select> tag'ı ile oluşturulmuş dropdown menulere uygulanabilir.
           e-select objesi ddm'yü handle edebilmek için 3 method kullanılır
                 -selectByVisibleText() ->Ddm deki elemente görünür metin ile ulaşmak için kullanılır
                 -selectByIndex() -> Index ile ulaşmak için kullanılır(Index 0 dan başlar)
                 -selectByValue() -> Elementin değeri ile ulaşmak için kullanılır(option tag'ındaki değer ile)
           f-getOptions()->Locate ettiğimiz ddm'deki tüm seçenekleri bize döndürür
           g-getFirstSelectedOption()->Ddm'deki en son seçili kalan ilk seçeneği bize döndürür
    */
   WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.testcenter.techproeducation.com adresinegidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //    WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
//    Select select = new Select(tumEyaletler);
//    List<WebElement> stateList = select.getOptions();//Bütün options taglarını getir
        //for (WebElement w:stateList) {
        //    System.out.println(w.getText());
        // }
//        stateList.forEach(t-> System.out.println(t.getText()));
        //a. Tüm eyalet isimlerini yazdıralım
        List<WebElement> tumEyaletler = driver.findElements(By.xpath("//*[@id='state']//option"));
        System.out.println(tumEyaletler.get(2).getText());
        System.out.println("****************************");
        tumEyaletler.forEach(t-> System.out.println(t.getText()));
//(//select)[5]//option[3] bir stati xpath ile secme

        //b. sayfadaki tum secenekleri (option) konsolda yazdirin.
        System.out.println("****************************");
        List<WebElement> eyaletlerList = driver.findElements(By.tagName("option"));
        eyaletlerList.forEach(t-> System.out.println(t.getText()));
        System.out.println("****************************");
        System.out.println(tumEyaletler.size());
    }
}

