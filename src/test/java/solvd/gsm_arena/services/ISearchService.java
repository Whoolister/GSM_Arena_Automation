package solvd.gsm_arena.services;

import org.openqa.selenium.WebDriver;
import solvd.gsm_arena.HomePage;
import solvd.gsm_arena.SearchPage;

public interface ISearchService {
	default SearchPage goToSearch(WebDriver driver, String query) {
		HomePage home = new HomePage(driver);
		home.fillSearchField(query);
		return home.performSearch();
	}
}
