package tests;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest1;
import pages.IMDBPage;
import pages.WikiPage;
import utils.Helper;

public class ValidateMovieDetails extends BaseTest1 {

	@Test
	@Parameters({"movieName"})
	public void validateImdb(String movieName) throws ParseException {

		IMDBPage imdbPage = new IMDBPage(driver);
		Map<String, String> imdbDetails = imdbPage.fetchMovieDetailsFromIMDB(movieName);

		driver.get(Helper.getData("wikiUrl"));

		WikiPage wikiPage = new WikiPage(driver);
		Map<String, String> wikiDetails = wikiPage.fetchMovieDetailsFromWiki(movieName);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		Date date = sdf.parse(wikiDetails.get("Release Date"));
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM dd, yyyy");
		String wikiDate = sdf1.format(date);
		
		Assert.assertEquals(imdbDetails.get("Release Date"), wikiDate);
		Assert.assertEquals(imdbDetails.get("Country"), wikiDetails.get("Country"));
	}

}
