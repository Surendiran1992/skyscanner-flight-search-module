package StepDefinitions;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import POMclasses.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;


public class Hooks extends BaseClass {
	private static final Logger log = LogManager.getLogger(Hooks.class);

	@After
	public void tearDown(Scenario scenario)  {
		
		if(scenario.isFailed()) {
			log.error("The scenario got failed : "+scenario.getName()+" Line: "+scenario.getLine());
			try {
			getscreenshot();	
			}catch(IOException e) {
				e.printStackTrace();}}
		
		try {
			closeTheBrowser();
		} catch (IOException e) {
			System.out.println("Something went wrong while closing the browser");}}
	
	
	
	
}
