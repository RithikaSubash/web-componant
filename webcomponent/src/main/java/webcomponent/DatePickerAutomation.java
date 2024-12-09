package webcomponent;


	import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class DatePickerAutomation {
	    public static void main(String[] args) {
	        
	        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

	        WebDriver driver = new ChromeDriver();

	        try {
	            
	            driver.manage().window().maximize();
	            driver.get("https://iquervui.com/datepicker/");

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            WebElement frame = (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe")));

	           
	            WebElement nextMonthButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-datepicker-next")));
	            nextMonthButton.click();

	           
	            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='22']")));
	            dateElement.click();

	          
	            String selectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");
	            System.out.println("Selected Date: " + selectedDate);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           
	            driver.quit();
	        }
	    }
	}



