package pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.qameta.allure.Description;
import utilities.BaseClass;

public class Homepage extends BaseClass {

	public Homepage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	By Amount = By.xpath("//input[@id='amount']");
	By FromCurrency = By.xpath("//input[@id='midmarketFromCurrency']");
	By ToCurrency = By.xpath("//input[@id='midmarketToCurrency']");
	By ConvertButton = By.xpath("//button[text()='Convert']");
	By ConvertTab = By.xpath("//span[text()='Convert']");
	By CookiesAgreeButton = By.xpath("//button[text()='Accept']");
	By popupClose = By.xpath("//button[@aria-label='close']");
	By convertedFromtext = By.xpath("//div[contains(@class,'unit-rates')]/p");

	public void AcceptCookies() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(CookiesAgreeButton));
		driver.findElement(CookiesAgreeButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(FromCurrency));

	}

	public void selectFromCurrency(String fromCurrency) throws Exception {

		WebElement fc = driver.findElement(FromCurrency);
		WebElement popUp = driver.findElement(popupClose);

		wait.until(ExpectedConditions.elementToBeClickable(fc));
		JavaScriptExecutor("window.scrollBy(0,200);");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SendKeys(fc, fromCurrency);
		wait.until(ExpectedConditions.elementToBeClickable(fc));
		SendKeys(fc, Keys.ENTER);
		wait.until(ExpectedConditions.invisibilityOf(popUp));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (popUp.isDisplayed()) {
			popUp.click();
		}

	}

	public void selectToCurrency(String toCurrency) throws Exception {

		WebElement tc = driver.findElement(ToCurrency);
		wait.until(ExpectedConditions.elementToBeClickable(tc));
		SendKeys(tc, toCurrency);
		SendKeys(tc, Keys.ENTER);
	}

	public void enterAmount(String amount) throws Exception {
		WebElement amountTextField = driver.findElement(Amount);
		amountTextField.click();
		amountTextField.clear();
		SendKeys(amountTextField, amount);

	}

	public void submitConvert() throws Exception {
		driver.findElement(ConvertButton).click();
	}

	@Description("Verify the result on the proceeding page")
	public void result(String askedAmount) {
		WebElement icon = driver.findElement(convertedFromtext);
		JavaScriptExecutor("arguments[0].scrollIntoView();", icon);
		String[] furl = GetText(icon).split("=");
		String[] value = furl[1].split(" ");
		double rates = Double.parseDouble(value[1]) * Double.parseDouble(askedAmount);
		String expectedValue = String.format("%.2f", rates);
		String[] actualValue = driver.findElement(By.xpath("//p[contains(@class,'result__Big')]")).getText().split(" ");
		String actualVal = String.format("%.2f", Double.parseDouble(actualValue[0]));
		Assert.assertEquals(expectedValue, actualVal, "Not matching");

	}

}
