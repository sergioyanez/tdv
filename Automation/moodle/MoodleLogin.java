package moodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoodleLogin {

	WebDriver driver;
	
	public MoodleLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement userInput = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		userInput.sendKeys(username);
		WebElement passwordInput = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordInput.sendKeys(password);
		WebElement button = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbtn")));
		button.click();
	}
}
