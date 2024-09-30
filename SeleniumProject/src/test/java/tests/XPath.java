package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

	public static void main(String[] args) {
		
		/* absolute xpath --> Full Path to the required element from root .  /html/body/tagName[@attribute='value'][@attribute='value'] also accepts multiple conditions.
		axpath-- not reliable bcoz of change of expression in case of  elements position change in code # faster to find */
		
		/* relative xpath --> direct or shortcut path    //tagName[@attribute='value'] # slower to find  
		 *  reliable bcoz of no change in expression in case of change of position of elements in code*/
		
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.xpath("//p[@id='para1']")); //use pipe "|"in case of different tags in selecting multiple elements.. not required in case of same tags..
														 // for same tage: //p[@id='para1'or @id='para2']
		
	
	
	
	
	
	
	
	}

}
