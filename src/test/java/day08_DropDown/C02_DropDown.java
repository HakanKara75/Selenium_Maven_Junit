package day08_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // https://testcenter.techproeducation.com/index.php?page=dropdown adresinegidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }
        @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }

        @Test
        public void test01() throws InterruptedException {
        //locate dropdown element
       WebElement year= driver.findElement(By.xpath("//select[@id='year']"));


       //select objesi olustur
       Select yearDropDown=new Select(year);
            Thread.sleep(3000);
       //select objesini kullanarak 3 farkli sekilde secim yapin
            yearDropDown.selectByIndex(11);
            Thread.sleep(3000);


            //ay secimi
            WebElement month= driver.findElement(By.xpath("//select[@id='month']"));
            Select monthDropDown=new Select(month);
            monthDropDown.selectByValue("5");

            //gun secimi
            WebElement day= driver.findElement(By.xpath("//select[@id='day']"));
            Select dayDropDown=new Select(day);
            dayDropDown.selectByValue("21");

        }

        @Test
    public void selectOpsions(){

            //tum eyalet isimlerini yazdirin
            WebElement state= driver.findElement(By.xpath("//select[@id='state']"));
            Select stateDropDown=new Select(state);
            List<WebElement> stateList=stateDropDown.getOptions();

//            for (WebElement w:stateList){
//                System.out.println(w.getText());
//            }

            stateList.stream().forEach(t-> System.out.println(t.getText()));
        }

}
