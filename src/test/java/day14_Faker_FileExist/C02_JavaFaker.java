package day14_Faker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C02_JavaFaker extends TestBase {
    @Test
    public void test(){
// Faker objesi olustur
        Faker faker= new Faker();

        //ya da Faker.instance() static metodu ile baslayabiliriz
        Faker.instance();

        //firstname yazdirin
        System.out.println(faker.name().firstName());

        //lastname yazdirin
        System.out.println(faker.name().lastName());

        //kullanici adi yazdirin
        System.out.println(faker.instance().name().username());

        //funny name yazdirin
        System.out.println(faker.funnyName().name());

        //meslek ismi yazdirin
        System.out.println(faker.name().title());

        //sehir ismi yazdirin
        System.out.println(faker.address().city());

        //eyalet ismi yazdirin
        System.out.println(faker.address().state());

        //full adres yazdirin
        System.out.println(faker.address().fullAddress());

        //cep numarasi yazdirin
        System.out.println(faker.phoneNumber().cellPhone());

        //email yazdirin
        System.out.println(faker.internet().emailAddress());

        //posta kodu yazdirin
        System.out.println(faker.address().zipCode());

        //ratgele 15 haneli bir numara yazdirin
        System.out.println(faker.number().digits(15));


    }
}
