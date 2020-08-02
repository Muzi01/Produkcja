package bindings.cucumber;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class DataGenerator {


    @DataProvider

    public static Object[][] cusomter() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        String user_login = person.getFirstName() ;
        String user_pass  = "$P$BSNqytY1YyygAN8xxrQH..Kh5GJloo."; // Grudzien2021!
        String user_nicename = person.getFirstName();
        String user_email = person.getEmail();


        return new Object[][]{
                {user_login,user_pass,user_nicename,user_email}

        };
    }
}
