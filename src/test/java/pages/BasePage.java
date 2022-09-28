package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Helper;

public class BasePage {
	
	protected WebDriver driver;
	private Integer timeOut = Integer.parseInt(Helper.getData("timeout"));
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickElement(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}
	
	public void sendText(WebElement element, String value) {
		waitForElementToBeVisible(element);
		element.sendKeys(value);
	}
	
	public String getText(WebElement element) {
		waitForElementToBeVisible(element);
		return element.getText();
	}
	
	private void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	private void waitForElementToBeVisible(WebElement element) {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
		action.moveToElement(element).build().perform();
	}

}
