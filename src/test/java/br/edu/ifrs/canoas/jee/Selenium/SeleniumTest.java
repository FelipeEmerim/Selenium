package br.edu.ifrs.canoas.jee.Selenium;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass(){
		
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
	}
	
	@AfterClass
	public static void tearDownClass(){
		driver.close();
	}
	
	@Before
	public void setUp(){
		
		driver = new ChromeDriver();
		driver.get("http://www.seleniumhq.org/");
	}
	
	@Test
	public void checkPageTitle(){
		
		String expected = "Selenium - Web Browser Automation";
		String actual = driver.getTitle();
		
		assertThat(expected).as(actual);
	}


}
