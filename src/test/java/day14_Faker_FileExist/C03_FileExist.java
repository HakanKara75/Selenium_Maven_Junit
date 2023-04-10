package day14_Faker_FileExist;

import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/*
Masaüstünde "logo.jpeg" dosyası oluşturun.
Bu dosyanın varlığını doğrulayın.
*/
public class C03_FileExist extends TestBase {
    @Test
    public void test(){

//Masaüstünde "logo.jpeg" dosyası oluşturun.
        boolean isExist=Files.exists(Paths.get("C:/Users/Hakan Batirhan.DESKTOP-KA8SOKR/Desktop/logo.jpeg"));

//Bu dosyanın varlığını doğrulayın.
        assertTrue(isExist);

        //2.yol
String userHome= System.getProperty("user.home"); //C:/Users/Hakan Batirhan.DESKTOP-KA8SOKR/ kismini verir
        boolean isExist1=Files.exists(Paths.get(userHome+"/Desktop/logo.jpeg"));
        assertTrue(isExist1);


String userDirectory = System.getProperty("user.dir");//C:\Users\Hakan Batirhan.DESKTOP-KA8SOKR\IdeaProjects\Batch129Selenium_MavenJunit\src\test\java\day14_Faker_FileExist\C03_FileExist.java
        //IDE proje yolunu dinamik olarak verir
        boolean isExist2=Files.exists(Paths.get(userDirectory+"/src/test/java/day14_Faker_FileExist/C03_FileExist.java"));
        assertTrue(isExist2);
    }
}
