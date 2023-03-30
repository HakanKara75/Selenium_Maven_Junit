package day07;

import org.junit.*;

public class C04_BeforeClassAfterClass {
/*
BeforeClass ve AfterClass notasyonlari static olmak zorundadir.
 */
    @BeforeClass
    public static void setUp(){
        System.out.println("tum testlerden once bir kez calisir");
        System.out.println("===============");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("tum testlerden sonra bir kez calisir");
        System.out.println("===============");
    }
    @Before
    public static void setUp01(){
        System.out.println("her testten once calisir");
        System.out.println("===============");
    }

    @After
    public static void tearDown01(){
        System.out.println("her testten sonra calisir");
        System.out.println("===============");
    }
@Test
    public void test01(){
    System.out.println("ilk test");
    System.out.println("===============");

}
    @Test
    public void test02(){
        System.out.println("ikinci test");
        System.out.println("===============");

    }
    @Test
    public void test03(){
        System.out.println("ucuncu test");
        System.out.println("===============");

    }








}
