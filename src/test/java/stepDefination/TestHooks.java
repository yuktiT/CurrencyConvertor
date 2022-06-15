package stepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyReader;

public class TestHooks {
	
	public static WebDriver driver;

	@Before
	public void setup() throws Exception {
			 if(PropertyReader.getValue("browser").equals("Chrome")) {
				 WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
			        options.addArguments("--chrome", "--window-size=1440,768", "--disable-gpu","--disable-notifications");
	    	         driver = new ChromeDriver(options);
	       }
	       else if(PropertyReader.getValue("browser").equals("Edge")) {
	    	    WebDriverManager.edgedriver().setup();
	    	   driver= new EdgeDriver();
	       }
	    
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}
