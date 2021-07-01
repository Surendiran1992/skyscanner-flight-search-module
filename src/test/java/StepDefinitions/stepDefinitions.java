package StepDefinitions;

import org.testng.Assert;
import POMclasses.BaseClass;
import POMclasses.FlightsPage_Factory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions extends BaseClass {

	private FlightsPage_Factory obj;

	@Given("User is on fights search page")
	public void user_is_on_fights_search_page() {
		driver = initializeBrowser();
		obj = new FlightsPage_Factory(driver);

	}

	@Given("User enters {} and {}")
	public void user_enters_chennai_and_mumbai(String arg0, String arg1) {
		obj.setOriginFld(arg0);
		obj.setDestFld(arg1);
	}

	@And("User selects the depart year and month {string}")
	public void user_selects_the_depart_year_and_month(String arg0) {
		obj.setdepartmonth(arg0);
	}

	@And("User enters the from date {string}")
	public void user_enters_the_from_date(String arg0) {
		obj.setdepartDate(arg0);
	}

	@And("User selects the return year and month {string}")
	public void user_selects_the_return_year_and_month(String arg0) {
		obj.setreturnmonth(arg0);
	}

	@And("User enters the return date {string}")
	public void returndate(String arg0) {
		obj.setreturnDate(arg0);
	}

	@When("User clicks searchflights button")
	public void user_clicks_searchflights_button() throws InterruptedException {
		obj.clicksearchBtn(driver);
	}

	@Then("user must see the search result in next page")
	public void asserting_scenario_1() {
		obj.searchresultboxisDisplayed();
		Assert.assertTrue(obj.searchresultboxisDisplayed());
	}

	// 2Scenarios StepDef
	@Given("User sets the origin city {string} and destination city {string}")
	public void input_field(String arg0, String arg1) {
		obj.setOriginFld(arg0);
		obj.setDestFld(arg1);
	}

	@When("User clicks travellers and increases the no.of adults to {int}")
	public void increasing_adults(Integer int1) throws InterruptedException {
		obj.clicktravellersDropDown();
		obj.increaseAdults(int1);
		obj.clickDoneBtn();

	}

	@Then("user must see the search result page with selected no of travellers")
	public void asserting_scenario_2() {
		obj.nooftravellers5isDisplayed();
		Assert.assertTrue(obj.nooftravellers5isDisplayed());
	}

	// 3rdScenario StepDef
	@When("User clicks travellers and increases the no.of child to {int}")
	public void increasing_Child(Integer int1) {
		obj.clicktravellersDropDown();
		obj.increeasechild(int1);

	}

	@And("User select the age of childs as {int} and {int}")
	public void selecting_child_age(Integer int1, Integer int2) {
		obj.selectchild1Age(int1);
		obj.selectchild2Age(int2);
		obj.clickDoneBtn();
	}

	@Then("user must see the search result page with selected no of travellers as {int}")
	public void asserting_scenario_3(Integer int1) {
		obj.nooftravellers3isDisplayed();
		Assert.assertTrue(obj.nooftravellers3isDisplayed());
	}

	//4th scenario
	@And("User select the age of child as {int}")
	public void user_select_the_age_of_child_as(Integer int1) {
		obj.clicktravellersDropDown();
		obj.selectchild1Age(int1);
		obj.clickDoneBtn();
	}
	@Then("user must get error msg to select children age.")
	public void error_msg() {
		obj.errorisDisplayed();
	}
}
