package tests;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.testng.Assert;
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		Date date = sdf.parse(wikiDetails.get("Release Date"));
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM dd, yyyy");
		String wikiDate = sdf1.format(date);
		
		Assert.assertEquals(imdbDetails.get("Release Date"), wikiDate);
		Assert.assertEquals(imdbDetails.get("Country"), wikiDetails.get("Country"));
	}

}
