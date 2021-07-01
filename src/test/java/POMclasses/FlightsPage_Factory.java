package POMclasses;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class FlightsPage_Factory extends FlightsPage_Object_Repository {
	private static final Logger log = LogManager.getLogger(FlightsPage_Factory.class);
	public boolean bol;
	public FlightsPage_Factory(WebDriver dvr) { 
		super(dvr);
	}

	public void setOriginFld(String origin) { 
		originInputFld.sendKeys(Keys.DELETE);
		originInputFld.sendKeys(origin);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		originInputFld.sendKeys(Keys.ENTER);
		log.info("Origin Field is entered");
	}

	public void setDestFld(String dest) { 
		//destInputFld.sendKeys(Keys.DELETE);
		destInputFld.sendKeys(dest);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		destInputFld.sendKeys(Keys.ENTER);
		log.info("Desparture Field is entered");
	}

	public void clicktravellersDropDown() {
		travellersDropDown.click();
		log.info("Traveller Drop Down is clicked");
	}

	public void clickDoneBtn() {
		travellersDone.click();
		log.info("Done button is clicked in travellers Drop Down Menu");
	}
	public void setdepartmonth(String month) {
		departDate.click(); 
		Select select = new Select(departmonthselector);
		select.selectByValue(month);
		log.info("Departure month and year is selected");
	}

	public void setdepartDate(String date) {
		List<WebElement> Dates =  datePickerContainer.findElements(By.xpath("//button[contains(@class,'calendar-date')]/span"));
		for (WebElement X : Dates) {
			if (X.getText().equals(date)) {
				X.click();
				break;
			}
		}
		log.info("Departure date is selected");
	}

	public void setreturnmonth(String month) {
		returnDate.click();
		Select select = new Select(returnmonthselector);
		select.selectByValue(month);
		log.info("Return month and year is selected");
	}
	public void setreturnDate(String date) {

		List<WebElement> Dates = datePickerContainer.findElements(By.xpath("//button[contains(@class,'calendar-date')]/span"));

		for (WebElement X : Dates) {
			if (X.getText().equals(date)) {
				X.click();
				break;
			}
		}
		log.info("Return date is selected");
	}

	public void increaseAdults(int number) {
		for(int i=1;i<number;i++){
			adultsIncrease.click();
		}
	}

	public void increeasechild(int number) {
		for(int i=0;i<number;i++){
			childIncrease.click();
		}
	}

	public void selectchild1Age(int age) {
		Select select = new Select(childAgeSelectDrpDown1);
		if(age>0 & age<=15) {
			select.selectByVisibleText(String.valueOf(age));
			log.info("1st child age is selected");
		}else {System.out.println("Enter age of child is not valid; enter age between 0 and 15");}
	}

	public void selectchild2Age(int age) {
		//travellersDropDown.click();
		Select select = new Select(childAgeSelectDrpDown2);
		if(age>0 & age<=15) {
			select.selectByVisibleText(String.valueOf(age));
			log.info("1st child age is selected");
		}else {System.out.println("Enter age of child is not valid; enter age between 0 and 15");}
		log.info("2nd child age is selected");
	}

	//Result page methods
	public boolean searchresultboxisDisplayed() {
		bol=searchresultbox.isDisplayed();
		log.info("Flight search text box is displayed in result page? "+ bol);
		return bol;
	}

	public boolean nooftravellers5isDisplayed() {
		bol=nooftravellers5.isDisplayed();
		log.info("No of travellers is displayed in result page? "+ bol);
		return bol;
	}
	public boolean nooftravellers3isDisplayed() {
		bol=nooftravellers3.isDisplayed();
		log.info("No of travellers is displayed in result page? "+ bol);
		return bol;
	}
	public boolean everywheredestisDisplayed() {
		bol=everywheredest.isDisplayed();
		log.info("Everywhere in destination country field is displayed in result page? " + bol);
		return bol;
	}
	public boolean errorisDisplayed() {
		bol=errortext.isDisplayed();
		log.info("'Choosen age of all child' is displayed in flight page? "+ bol);
		return bol;
	}
	public void clicksearchBtn(WebDriver dvr) { 
		searchbtn.click(); 
		log.info("Search Button is clicked");
		//for handling the human or robot authentication page

		try {
			Thread.sleep(2000);
			String pagetitle= dvr.getTitle(); 
			if(pagetitle.equalsIgnoreCase("Skyscanner")) { 
				log.info("Inside the robo page");
				Actions act = new Actions(dvr); 
				act.clickAndHold(roboPageElement).build().perform();
				Thread.sleep(5000);
				act.release().perform();
				log.info("Successfully authenticated the robo page"); }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
