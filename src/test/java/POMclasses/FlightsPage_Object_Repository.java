package POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FlightsPage_Object_Repository {

	protected WebDriver dvr;
	WebElement element;

	@FindBy(id = "fsc-trip-type-selector-return")
	WebElement returnRadioBtn;
	@FindBy(id = "fsc-trip-type-selector-one-way")
	WebElement oneWayRadioBtn;
	@FindBy(id = "fsc-trip-type-selector-multi-destination")
	WebElement multiCityRadioBtn;
	@FindBy(id = "fsc-origin-search")
	protected WebElement originInputFld;
	@FindBy(id = "fsc-destination-search")
	protected WebElement destInputFld;
	@FindBy(id = "depart-fsc-datepicker-button")
	protected WebElement departDate;
	@FindBy(id = "return-fsc-datepicker-button")
	protected WebElement returnDate;
	@FindBy(xpath = "//button[@aria-label='Search flights']")
	protected WebElement searchbtn;
	@FindBy(id = "depart-calendar__bpk_calendar_nav_select")
	protected WebElement departmonthselector;
	@FindBy(id = "return-calendar__bpk_calendar_nav_select")
	protected WebElement returnmonthselector;
	@FindBy(className = "FlightDatepicker_fsc-datepicker__container__Nm0eA")
	protected WebElement datePickerContainer;
	@FindBy(id = "CabinClassTravellersSelector_fsc-class-travellers-trigger__LeM38")
	WebElement travellersDropDown;
	@FindBy(xpath = "//button[@title='Increase number of adults']")
	WebElement adultsIncrease;
	@FindBy(xpath = "//button[@title='Increase number of children']")
	WebElement childIncrease;
	@FindBy(id = "children-age-dropdown-0")
	protected WebElement childAgeSelectDrpDown1;
	@FindBy(id = "children-age-dropdown-1")
	protected WebElement childAgeSelectDrpDown2;
	@FindBy(xpath = "//button[text()='Done']")
	WebElement travellersDone;
	@FindBy(name = "originFlexible")
	WebElement origincheckbox;
	@FindBy(name = "destinationFlexible")
	WebElement destcheckbox;
	@FindBy(name = "directOnly")
	WebElement directOnlycheckbox;
	@FindBy(name = "flexibleTicket")
	WebElement flexibletcktcheckbox;
	@FindBy(xpath = "//section[@role ='searchbox']")

	//result Page
	protected WebElement searchresultbox;
	@FindBy(xpath = "//span[text()='5']")
	WebElement nooftravellers5;
	@FindBy(xpath = "//span[text()='3']")
	WebElement nooftravellers3;
	@FindBy(xpath = "//span[text()='Everywhere']")
	WebElement everywheredest;
	@FindBy(xpath = "//div[text()='Please specify ages for all children.']")
	WebElement errortext;
	
	//robot Autentication Page
	@FindBy(xpath="//section[@class='App_App__captcha__3Ls-v']")
	WebElement roboPageElement;


	public FlightsPage_Object_Repository(WebDriver dvr) { 
		this.dvr = dvr;
		PageFactory.initElements(new AjaxElementLocatorFactory(dvr, 5), this); }

}