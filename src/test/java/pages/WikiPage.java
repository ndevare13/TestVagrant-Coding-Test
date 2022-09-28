package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WikiPage extends BasePage {
	
	public WikiPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='searchInput']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//input[@id='searchButton']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[@id='content']/h1/i")
	private WebElement movieTitleHeader;
	
	@FindBy(xpath = "//tr[./th/div[contains(text(), 'Release date')]]/td")
	private WebElement releaseDateValue;
	
	@FindBy(xpath = "//tr[./th[contains(text(), 'Country')]]/td")
	private WebElement countryValue;
	
	public Map<String, String> fetchMovieDetailsFromWiki(String movieTitle) {
		
		sendText(searchBar, movieTitle);
		clickElement(searchButton);
		
		Assert.assertTrue(getText(movieTitleHeader).trim().contains(movieTitle), "Movie page is opened successfully");
		
		String releaseDate = getText(releaseDateValue);
		String country = getText(countryValue);
		
		Map<String, String> movieDetails = new HashMap<String, String>();
		movieDetails.put("Release Date", formattedReleaseDate(releaseDate));
		movieDetails.put("Country", country);
		
		return movieDetails;
	}
	
	private String formattedReleaseDate(String releaseDate) {
		String formattedReleaseDate;
		formattedReleaseDate = releaseDate.substring(0, releaseDate.length() - 5) + ", " + 
				releaseDate.substring(releaseDate.length() - 4);
		
		return formattedReleaseDate;
	}

}
