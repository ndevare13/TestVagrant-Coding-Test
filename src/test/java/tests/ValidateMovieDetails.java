package tests;

import java.text.ParseException;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.IMDBPage;
import pages.WikiPage;
import utils.Helper;

public class ValidateMovieDetails extends BaseTest {

	@Test
	public void validateImdb() throws ParseException {

		IMDBPage imdbPage = new IMDBPage(driver);
		Map<String, String> imdbDetails = imdbPage.fetchMovieDetailsFromIMDB("Pushpa: The Rise");

		driver.get(Helper.getData("wikiUrl"));

		WikiPage wikiPage = new WikiPage(driver);
		Map<String, String> wikiDetails = wikiPage.fetchMovieDetailsFromWiki("Pushpa: The Rise");
	}

}
