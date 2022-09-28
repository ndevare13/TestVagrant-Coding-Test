package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IMDBPage extends BasePage {
	
	public IMDBPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='suggestion-search']")
	private WebElement searchBar;
	
	@FindBy(xpath="//button[@id='suggestion-search-button']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//ul[@role='listbox']")
	private WebElement searchDropdown;
	
	@FindBy(xpath = "//section//h1")
	private WebElement movieTitleHeader;
	
	@FindBy(xpath = "//li[./a[contains(text(), 'Release date')]]//li/a")
	private WebElement releaseDateValue;
	
	@FindBy(xpath = "//li[./span[contains(text(), 'Country of origin')]]//a")
	private WebElement countryValue;
	
	private String movieLink = "//a[contains(text(), '%s')]";
	
	public Map<String, String> fetchMovieDetailsFromIMDB(String movieTitle) {
		
		sendText(searchBar, movieTitle);
		clickElement(searchButton);
		
		WebElement movieLinkElement = driver.findElement(By.xpath(String.format(movieLink, movieTitle)));
		clickElement(movieLinkElement);
		
		Assert.assertTrue(getText(movieTitleHeader).trim().contains(movieTitle), "Movie page is opened successfully");
		
		String releaseDate = getText(releaseDateValue);
		String country = getText(countryValue);
		
		Map<String, String> movieDetails = new HashMap<String, String>();
		movieDetails.put("Release Date", extractReleseDate(releaseDate));
		movieDetails.put("Country", country);
		
		return movieDetails;
	}
	
	private String extractReleseDate(String releaseDate) {
		String extractedReleaseDate = releaseDate;
		
		if (releaseDate.contains("(")) {
			extractedReleaseDate = releaseDate.substring(0, releaseDate.indexOf("("));
		}
		
		return extractedReleaseDate.trim();
	}

}
