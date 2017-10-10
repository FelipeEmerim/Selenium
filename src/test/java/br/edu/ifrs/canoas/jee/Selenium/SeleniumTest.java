package br.edu.ifrs.canoas.jee.Selenium;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass(){
		
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDownClass() throws InterruptedException{
		
		Thread.sleep(3000);
		driver.close();
	}
	
	@Before
	public void setUp(){
		
		driver.get("http://www.seleniumhq.org/");
		
	}
	
	@Test
	public void checkPageTitle(){
		
		String expected = "Selenium - Web Browser Automation";
		String actual = driver.getTitle();
		assertThat(expected).as(actual);
	}
	
	@Test
	public void findAndClickOnElement(){
		
		
		WebElement downloadLink = driver.findElement(By.id("menu_download"));
		
		String expectedLinkText = "download";
		
		assertThat(expectedLinkText).as(downloadLink.getText());
		
		downloadLink.click();
		
		String expected = "Downloads";
		
		assertThat(expected).as(driver.getTitle());
	}
	
	@Test
	public void downloadChromeDriver(){
		
		driver.findElement(By.id("menu_download")).click();
		
		
		String expected = "Downloads";
		
		assertThat(expected).as(driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainContent\"]/table[2]/tbody/tr[2]/td[2]/a")));
		element.click();
		
		expected = "http://chromedriver.storage.googleapis.com/index.html?path=2.33/";
		
		assertThat(expected).as(driver.getCurrentUrl());
		
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/table/tbody/tr[7]/td[2]/a")));
		element.click();
		
		
		
	}


}
