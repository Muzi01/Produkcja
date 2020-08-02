
import bindings.cucumber.pages.produkcja.ProdukcjaKonto;
import bindings.driver.WebDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {

    private final ProdukcjaKonto produkcjaKonto;






    public WebDriver driver;

    public MyStepdefs(ProdukcjaKonto produkcjaKonto, WebDriverFactory driverFactory) {

        this.produkcjaKonto = produkcjaKonto;
    }

    @When("Customer is opening store homepage")
    public void customerIsOpeningStoreHomepage() {
        produkcjaKonto.openMojeKontoFakeshop();
    }

    @Then("Customer is registering into Store")
    public void customerIsRegisteringIntoStore() throws InterruptedException {
        produkcjaKonto.registractionProdukcja();
    }

    @And("I login with following hardcoded credentials")
    public void iLoginWithFollowingHardcodedCredentials(DataTable dataTable) {
        {
            produkcjaKonto.loginProcessFakeshop2(dataTable);
        }
    }
}
