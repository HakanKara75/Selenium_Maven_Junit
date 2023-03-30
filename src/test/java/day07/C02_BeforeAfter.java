package day07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
   @Before
    public void setup(){
       System.out.println("Her test methodu oncesi bir kez calisir");
    }
    @After
    public void tearDown(){
        System.out.println("Her test methodu sonrasi bir kez calisacak");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test Methodu");
    }

    @Test
    public void test02(){
        System.out.println("Ikinci Test Methodu");
    }
}
