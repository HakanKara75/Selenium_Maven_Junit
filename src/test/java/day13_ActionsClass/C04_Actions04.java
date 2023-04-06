package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
/*
https://jqueryui.com/droppable/ adresine gidin
"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
 */

    @Test
    public void name() {
//        https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        Actions actions=new Actions(driver);


        //iframe oldugu icin kod calismadi. Handle edecegiz
        driver.switchTo().frame(0);

        bekle(2);
        WebElement sourceElement=driver.findElement(By.id("draggable"));
        WebElement targetElement=driver.findElement(By.id("droppable"));
        actions.dragAndDrop(sourceElement,targetElement).perform();
    }

    @Test
    public void test() {
        https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        Actions actions=new Actions(driver);


        //iframe oldugu icin kod calismadi. Handle edecegiz
        driver.switchTo().frame(0);

        bekle(2);
        WebElement sourceElement=driver.findElement(By.id("draggable"));
        WebElement targetElement=driver.findElement(By.id("droppable"));
        actions.
                clickAndHold(sourceElement).//clickAndHold web elementi tıklar ve tutar
                moveToElement(targetElement).//moveToElement mouse'u bir element üzerine taşır
                release().//release methodu tıklanıp tutulan mouse'u bırakır
                perform();
        //Burada dragAndDrop'tan farklı olarak işlemleri kendimiz sırayla belirttik.
    }
    @Test
    public void test2() {
        https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        Actions actions=new Actions(driver);


        //iframe oldugu icin kod calismadi. Handle edecegiz
        driver.switchTo().frame(0);

        bekle(2);
        WebElement sourceElement=driver.findElement(By.id("draggable"));

        actions.clickAndHold(sourceElement).
                moveByOffset(390,260).//inspect yaparak koordinat aliriz.
                perform();
}
}