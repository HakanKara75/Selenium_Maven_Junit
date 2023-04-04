package day12_WindowHandle_BasicAuth;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C03_Cookies extends TestBase {
/*
1-Amazon anasayfaya gidin
2-tum cookie'leri listeleyin
3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie  olusturun ve sayfaya ekleyin
6-eklediginiz cookie'nin sayfaya eklendigini test edin
7-ismi skin olan cookie'yi silin ve silindigini test edin
8-tum cookie'leri silin ve silindigini test edin
 */
@Test
public void newTabTest1() {
//    1-Amazon anasayfaya gidin
    driver.get("https://amazon.com");

//    2-tum cookie'leri listeleyin
    Set<Cookie> cookies=driver.manage().getCookies();
    for(Cookie c:cookies){
        System.out.println(c);
    }
    //2.yol
    //cookies.stream().forEach(t-> System.out.println(t));
//    cookies.stream().forEach(t-> System.out.println(t.getName()));
//    cookies.stream().forEach(t-> System.out.println(t.getValue()));

//    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    int tumCookiesSayisi=cookies.size();
    System.out.println(tumCookiesSayisi);
    assertTrue(cookies.size()>5);

//    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
String value= driver.manage().getCookieNamed("i18n-prefs").getValue();
    assertEquals("USD", value);

//    5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie  olusturun ve sayfaya ekleyin
    Cookie yeniCookie=new Cookie("en sevdigim cookie", "cikolatali");
    driver.manage().addCookie(yeniCookie);

//    6-eklediginiz cookie'nin sayfaya eklendigini test edin
    int eklenmisHaliCookies=driver.manage().getCookies().size();
    assertTrue(eklenmisHaliCookies>tumCookiesSayisi);

    //2.yol
    String yeniCookieValue= driver.manage().getCookieNamed("en sevdigim cookie").getValue();
    assertEquals("cikolatali", yeniCookieValue);

//    7-ismi skin olan cookie'yi silin ve silindigini test edin
    int silinmedenOnce=driver.manage().getCookies().size();
    driver.manage().deleteCookieNamed("skin");
    int silindiktenSonra=driver.manage().getCookies().size();
    assertEquals(1, (silinmedenOnce-silindiktenSonra));

//    8-tum cookie'leri silin ve silindigini test edin
    driver.manage().deleteAllCookies();
    int silinenCookies=driver.manage().getCookies().size();
    assertEquals(0, silinenCookies);
}

}
