package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiPage {
	
	@FindBy(xpath = "//input[@id='searchInput']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//div[@id='content']/h1/i")
	private WebElement movieTitle;
	
	@FindBy(xpath = "//tr[./th/div[contains(text(), 'Release date')]]/td")
	private List<WebElement> releaseDateValue;
	
	@FindBy(xpath = "//tr[./th[contains(text(), 'Country')]]/td")
	private List<WebElement> countryValue;

}
