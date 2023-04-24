package day21_JSExecuter;

import org.junit.Test;
import utilities.TestBase;

public class C04_JSExecuter_GetValue extends TestBase {
    //  1)getValueTest metotu olustur
// 2)https://www.priceline.com/ a git
//  3)Tarih kısmındaki Yazili metinleri al ve yazdır
    @Test
    public void name() {
//  1)getValueTest metotu olustur


// 2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");

//  3)Tarih kısmındaki Yazili metinleri al ve yazdır
       getValueByJavaScript("hotelDates", "value" );

    }
}
