package moodle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoodleBuscarAutomation {

	WebDriver driver;

	public MoodleBuscarAutomation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void scrollear() {
		//Scroleamos, para ello es necesario ejecutar funcionalidad Javascript
		JavascriptExecutor js = (JavascriptExecutor)driver;

		boolean findElement=false;
		while (findElement == false) {
			js.executeScript("window.scrollBy(0,350)", ""); //scrolleamos
			try {
				WebDriverWait wait = new WebDriverWait(driver, 8000);
				WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Automation")));
				findElement = true;
				element.click();
			}
			catch(Exception e){
				findElement = false;
			}
		}

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
