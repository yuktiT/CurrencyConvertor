package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Homepage;
import utilities.PropertyReader;

public class StepDefs {
	private WebDriver driver = TestHooks.driver;
	private WebDriverWait wait;
	String Amount;
	Homepage HP = new Homepage(driver, wait);

	@Given("the user launch the currency converter application")
	public void the_user_launch_the_currency_converter_application() throws Exception {
		PropertyReader propertiesReader = new PropertyReader();
		driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get(PropertyReader.getValue("url"));
	}

	@When("the user enter the from {} currency to {} currency")
	public void the_user_enter_the_from_currency_to_currency(String fromCurrency, String toCurrency) throws Exception {
		HP.AcceptCookies();
		HP.selectFromCurrency(fromCurrency);
		HP.selectToCurrency(toCurrency);
	}

	@When("enters the {}")
	public void enters_the(String amount) throws Exception {
		Amount = amount;
		HP.enterAmount(amount);

	}

	@When("the user click on convert button")
	public void the_user_click_on_convert_button() throws Exception {
		HP.submitConvert();
	}

	@Then("the user verifies the conversion rates")
	public void the_user_verifies_the_conversion_rates() {
		HP.result(Amount);

	}

}
