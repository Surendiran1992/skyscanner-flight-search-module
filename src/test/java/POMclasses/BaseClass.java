package POMclasses;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass  {
	FlightsPage_Object_Repository repo;
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream input;
	String dir = System.getProperty("user.dir");
	private static final Logger log = LogManager.getLogger(BaseClass.class);

	public WebDriver initializeBrowser() {

		try {
			prop = new Properties();
			input= new FileInputStream(dir+"\\src\\test\\resources\\cucumber.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.setProperty("webdriver.gecko.driver",dir+ prop.getProperty("gecko_driver"));
		driver = new FirefoxDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		//handlingrobopage();
		return driver;
	}


	public void closeTheBrowser() throws IOException {
		driver.quit();
		input.close();
		log.info("All opened files are closed");
	}

	public void getscreenshot() throws IOException {

		String filename = getRandomfileName(4)+".png";
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File(dir+"\\screenshots\\"+filename));
	}

	public String getRandomfileName(int lenOfFile) {
		StringWriter str = new StringWriter();
		String character = "abcdefghijklmnopqrstuvwxyz1234567890";

		for(int i=0; i<lenOfFile; i++) {
			int randomNo = (int)(Math.random()* character.length());  
			str.append(character.charAt(randomNo));
		}
		return str.toString();
	}
	
	/*
	 * public void handlingrobopage() throws InterruptedException {
	 * 
	 * String pagetitle= driver.getTitle(); System.out.println(pagetitle);
	 * System.out.println("pagetitle form properties file "+
	 * prop.getProperty("RoboPage_Title"));
	 * if(pagetitle.equalsIgnoreCase(prop.getProperty("RoboPage_Title")) ) {
	 * log.info("Inside the rob page"); Actions act = new Actions(driver);
	 * //WebDriverWait wait =new WebDriverWait(driver, 10);
	 * System.out.println("WebEle is found"); repo= new
	 * FlightsPage_Object_Repository(driver);
	 * 
	 * act.clickAndHold(repo.roboPageElement); Thread.sleep(5000);
	 * //wait.until(ExpectedConditions.invisibilityOf(repo.roboPageElement));
	 * act.release(); log.info("Successfully authenticated the robo page"); } }
	 */
}
