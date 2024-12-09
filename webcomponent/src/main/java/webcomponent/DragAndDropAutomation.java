package webcomponent;


	import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class DragAndDropAutomation {
	    public static void main(String[] args) {
	        
	        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

	        WebDriver driver = new ChromeDriver();

	        try {
	           
	            driver.manage().window().maximize();
	            driver.get("https://jqueryui.com/droppable/");

	           

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            
	            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe")));

	            
	            WebElement sourceElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("draggable")));
	            WebElement targetElement = driver.findElement(By.id("droppable"));

	            
	            Actions actions = new Actions(driver);
	            actions.dragAndDrop(sourceElement, targetElement).perform();

	        
	            String targetText = targetElement.getText();
	            if ("Dropped!".equals(targetText)) {
	                System.out.println("Drag and drop operation was successful!");
	            } else {
	                System.out.println("Drag and drop operation failed.");
	            }

	         
	            String colorAfterDrop = targetElement.getCssValue("background-color");
	            System.out.println("Background color of target after drop: " + colorAfterDrop);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            
	            driver.quit();
	        }
	    }
	}



