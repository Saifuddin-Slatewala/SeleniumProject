package tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumApiCommands {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "");
		// we need firefox driver "gecko" driver.
		
		//System.setProperty("webdriver.ie.driver", "");
		// we need ie driver "ie" driver.
		
		//System.setProperty("webdriver.edge.driver", "");
		// we need edge driver "edge" driver.
		
		//System.setProperty("webdriver.chrome.driver", "");
		// we need chrome driver "chrome" driver.
		
		
		String browser = "Chrome";
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\SeleniumProject\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\eclipse-workspace\\SeleniumProject\\drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\User\\eclipse-workspace\\SeleniumProject\\drivers\\msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		
		
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		String a = driver.getTitle(); //title of page,High Level -->> Falls under ChromeDriver 
		String b = driver.getCurrentUrl(); //for current page url,in case of redirection.
		driver.close(); // closing the main browser window.
		
		
		
		//Thread.sleep(3000);
		
		String el = driver.findElement(By.xpath("//input[@id='alert1']")).getText(); //To Find Elements on the Page. Falls under WebElement., to get text
		String att = driver.findElement(By.id("textbox1")).getAttribute("name"); // to get Attribute 
		//getText() works for when text is covered by html tags on both side.
		//getAttribute() works when text is within an HTML element's attribute.
		boolean bl = driver.findElement(By.id("but2")).isDisplayed(); //if element is displayed or not.
		boolean en = driver.findElement(By.id("but2")).isEnabled(); // if element is enabled or not.
		boolean ch = driver.findElement(By.id("checkbox1")).isSelected();	// if element is checked or not(checkbox).
		//Thread.sleep(2000);
		driver.navigate().to("https://www.google.com");// to navigate to other page.
		driver.navigate().back(); //navigate back
		driver.navigate().forward(); //navigate forward
		driver.navigate().refresh(); //refresh page.
		
		driver.getPageSource(); // html code.
		//Login Page Example..
		driver.findElement(By.id("")).sendKeys(""); //username
		driver.findElement(By.linkText("")).sendKeys(""); //password
		driver.findElement(By.xpath("")).click(); // click submit buton
		driver.findElement(By.id("")).submit(); // only work for forms..
		
		driver.findElement(By.id("")).getTagName(); //get tag name.
		driver.findElement(By.id("but2")).getCssValue("text-align"); // particular css value
		Dimension size = driver.findElement(By.id("")).getSize(); // dimensions of element.
		Point loc = driver.findElement(By.id("")).getLocation(); // coordinates of element.
		// loc.x and loc.y..
		driver.findElement(By.id("")).getClass();
		driver.manage().window().fullscreen(); // fullscreen window
		List<WebElement> els = driver.findElements(By.tagName("input")); //finding all input elements
		
		for(WebElement i:els) {
			System.out.println(i.getText());
		}
		
		//Multiple Working Windows
		driver.findElement(By.linkText("open a popup window")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> w = windows.iterator();
		String mainwindow = w.next();
		String childwindow = w.next();
		driver.switchTo().window(childwindow);
		String txt = driver.findElement(By.id("para1")).getText();
		System.out.println(txt);
		driver.close();
		driver.switchTo().window(mainwindow);
		driver.close();
		
		//multiple child windows
		
		driver.findElement(By.linkText("open a popup window")).click();
		driver.findElement(By.linkText("blogger")).click();
		
		Set<String> windowss = driver.getWindowHandles();
		
		Iterator<String> windowids = windowss.iterator();
		while(windowids.hasNext()) {
		
		if(driver.getTitle().equals("Basic Web Page title")) {
			driver.findElement(By.id("para1"));
			//Some Operations
		}
		else if(driver.getTitle().equals("Basic Web Page title")){
			driver.findElement(By.id("para2"));
			//Some operations
		}
	}
		
		//Waiting Mechanism 
		
		
		driver.findElement(By.linkText("")).click();
		//Thread.sleep(4000);    !!!! NOT PRODUCTIVE !!!!
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //waiting Time until element get loaded. ---- GLOBAL WAIT----
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30)); //explicit wait for particular element.
		WebElement fwait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("facebook"))); //particular fb element..
		//polling time : time for every 500 milisconds(fixed) it will check if element loaded or not..
		// polling time can be customised in FluentWait()
		fwait.click();
		
		
		
		//Alert
		
		
		
		
		
		//Drop Down
		
		
		
		
		
		driver.quit();// close all windows.
	}
	

}
