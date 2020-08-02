package bindings.cucumber.pages.linkedin;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedInLoginPage   {


    private static final Logger LOGGER = LogManager.getLogger (LinkedInLoginPage.class);
    private static final String EMAIL_ID = "Email or Phone";
    private static final String PASSWORD_ID = "password";
    private static final String DALEJ_TEXT = "Dalej";
    private static final String ZALOGUJ_TEXT = "Dalej";
    private static final String LOGINBUTTON_ID = "loginButton";
    private static final String KONTAKT_ID = "drawerLink-0";
    private static final String LOGIN2_ID = "emptyLogin";
    private static final String ZALOGUJ2_TEXT = "Zaloguj się";
    private static final String LOGIN = "piotr.kramkowski@gmail.com";
    private static final String PASSWORD = "Pioneer123!";

    @FindBy (linkText = EMAIL_ID  )
    public WebElement email;

    @FindBy (id = PASSWORD_ID  )
    public WebElement password;

    @FindBy (className = "btn__primary--large from__button--floating" )
    public WebElement loginButton;

    @FindBy (linkText ="Dalej")
    public   WebElement  Dalej;

    @FindBy (linkText = ZALOGUJ_TEXT)
    public   WebElement  Zaloguj;

    @FindBy (id =KONTAKT_ID)
    public   WebElement  Kontakt;

    @FindBy (id = LOGIN2_ID )
    public  WebElement Login2 ;






    public void fillLogin (){ email.sendKeys (); }
    public void fillPassword (){ password.sendKeys (); }



    public void loginProcessLinked () {
        fillLogin ();
        fillPassword ();

    }




    protected String getPageName () {
        return "LinkedInLoginPage";
    }
}
