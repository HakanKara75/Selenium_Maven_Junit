package day16_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class C03_NullPointerException { //extend yapilmadigi icin driver'a tanimlama gerekir.
    WebDriver driver; // Durum 1
    Integer number;
       @Test
    public void test() {
        //driver=null;  Durum 2
        driver.get("https://techproeducation.com");
        //Her iki durumda da NullPointerException verir. Cunku driver'a atama yapılmıyor.
    }

    @Test
    public void test1() {
        String name;
        //System.out.println(name.charAt(0)); //initialize edilmedigi icin NullPointerException

        Faker faker;
        //System.out.println(faker.number().numberBetween(1,20)); //initialize edilmedigi icin NullPointerException
    }

    @Test
    public void test2() {
        System.out.println(number+6);

    }
    @Test
    public void nullPointerExceptionTest4() {


       // System.out.println(name.charAt(0));//java.lang.NullPointerException

    }

}