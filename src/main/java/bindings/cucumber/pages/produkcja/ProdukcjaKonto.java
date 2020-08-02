package bindings.cucumber.pages.produkcja;



import bindings.driver.WebDriverFactory;
import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ProdukcjaKonto extends WebDriverFactory {

    private static final Logger LOGGER = LogManager.getLogger(ProdukcjaKonto.class);
    private static final String REG_EMAIL_NAME = "reg_email";
    private static final String REG_PASS_NAME = "reg_password";
    private static final String REG_BUTTON_NAME = "register";
    // TODO: 11/06/2020  naprawic selektor do subbmit buttona 
    private static final String LOGIN_USERNAME = "username";
    private static final String PASSWORD_FIELD = "password";

    // TODO: 11/06/2020 naprawic selektor do LOGIN BUTTOn 
    private static final String LOGIN_PASSWORD = "Grudzien2021!";
    private static final String PASSWORD_NAME = "password";
    private static final String CONFIRM_NAME = "confirmpassword";
    private static final String ZALOGUJ_XPATH = "//button[@type='submit']";
    private static final String PASSWORD = "Grudzien2021! ";
    private static final String SHOP_ID = "menu-item-198";

    Fairy fairy = Fairy.create();
    Person person = fairy.person();
   JavascriptExecutor jse = (JavascriptExecutor)  createChromeDriver() ;
   // Actions actions = new Actions(driver);

    @FindBy(name = "email")
    public WebElement regEmail;

    @FindBy(id = REG_PASS_NAME)
    public WebElement regPass;

    @FindBy(name = REG_BUTTON_NAME)
    public WebElement regButton;

    @FindBy(id = LOGIN_USERNAME)
    public WebElement loginUsername;

    @FindBy(id = PASSWORD_FIELD)
    public WebElement loginPass;

    @FindBy(name = "login")
    public WebElement loginButton;

    @FindBy(linkText = "Moje konto")
    public WebElement tekst;

    @FindBy(partialLinkText = "Log out")
    public WebElement wylogowanie;

    @FindBy(linkText = "Zarejestruj się")
    public WebElement registerText;

    @FindBy(id ="menu-item-198")
    public WebElement shopPage;


    public ProdukcjaKonto(WebDriverFactory webDriverFactory) {
        PageFactory.initElements(webDriverFactory.createChromeDriver(), this);
    }


    public void openMojeKontoFakeshop() {
       createChromeDriver().get("http://35.237.167.0/index.php/my-account/");
    }

    @Test
    public void registractionProdukcja( ) throws InterruptedException {
        regEmail.sendKeys(person.getEmail());
        jse.executeScript("scroll(239, 771)");
        regPass.sendKeys(PASSWORD);
        regButton.click();
        Assert.assertEquals(wylogowanie,wylogowanie);
         createChromeDriver().close();
    }






    public void loginProcessFakeshop2(final DataTable dataTable){
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        loginUsername.sendKeys (data.get(0).get("Username"));
        loginPass.sendKeys((data.get(0).get("Password")));
       jse.executeScript("scroll(239, 771)");
        loginButton.click();
        Assert.assertEquals(wylogowanie,wylogowanie);

    }

    public void textcheck() {
        Assert.assertEquals(tekst, tekst);
        System.out.println(tekst);

    }

    public void wylogowanieButton(){
        Assert.assertEquals(wylogowanie,wylogowanie);
    }

    public void wylogowanieUsera (){
        jse.executeScript("scroll(239, 771)");
        wylogowanie.click();
      Assert.assertEquals(regButton, regButton);
        jse.executeScript("scroll(239, 771)");
    createChromeDriver().close();;

    }
    public  void checkSelfService (){Assert.assertEquals(tekst, tekst);
    }

    public void  clickShopID () {
       Assert.assertEquals(shopPage,shopPage);
        shopPage.click();
    }
}
