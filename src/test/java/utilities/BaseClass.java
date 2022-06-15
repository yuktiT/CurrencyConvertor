package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	JavascriptExecutor js;

	public BaseClass(WebDriver driver, WebDriverWait wait) {

		BaseClass.driver = driver;
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 20);
		BaseClass.wait = wait;

	}

	public void JavaScriptExecutor(String dom) {
		js.executeScript(dom);
	}

	public void JavaScriptExecutor(String dom, WebElement ele) {
		js.executeScript(dom, ele);
	}

	public void SendKeys(WebElement we, String text) {
		we.sendKeys(text);
	}

	public void SendKeys(WebElement webEle, Keys enter) {
		webEle.sendKeys(enter);

	}

	public String GetText(WebElement element) {
		return element.getText();
	}

}
