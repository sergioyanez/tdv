package moodle;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Moodle_TEST {

	static WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver();
	}
	
	@Test (priority=1)

	public void loadPage() {
		driver.navigate().to("https://moodle.exa.unicen.edu.ar/login/index.php");
		System.out.println(driver.getTitle());
		//Se comprueba que se está en la página correcta
		assertEquals(driver.getTitle(), "Moodle - Facultad de Ciencias Exactas: Iniciar sesión en el sitio");
	}
	
	@Test (priority=2)
	public void login() {
		MoodleLogin moodlelogin =  PageFactory.initElements(driver, MoodleLogin.class);
		moodlelogin.login("33111285", "Rauch2020"); 
	}
	
	@Test (priority=3)
	public void tdv() {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div/div/section/div/div/div/aside/section[1]/div/div/div[1]/div[2]/div/div/div[1]/div/ul/li[2]/div/div[1]/div/a")));
		element.click();
		element.click();
	}
	
	@Test (priority=4)
	public void automation() {
		MoodleBuscarAutomation buscarAutomation = PageFactory.initElements(driver, MoodleBuscarAutomation.class);
		buscarAutomation.scrollear();
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/section/div/div/div/div/ul/li[14]/div[3]/ul/li[3]/div/div/div[2]/div/a")));
		element.click();
	}
	
	@Test (priority=5)
	public void closeDriver() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(driver!=null)
			driver.close();
		System.out.println("Termino satisfactoriamente");
	}
}
