package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IMDBPage {
	
	@FindBy(xpath = "input[@id='suggestion-search']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//ul[@role='listbox']")
	private WebElement searchDropdown;
	
	@FindBy(xpath = "//section//h1")
	private WebElement movieTitle;
	
	@FindBy(xpath = "//li[./a[contains(text(), 'Release date')]]//li/a")
	private WebElement releaseDateValue;
	
	@FindBy(xpath = "//li[./span[contains(text(), 'Country of origin')]]//a")
	private WebElement countryValue;

}
