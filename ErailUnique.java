package Week3Assignments;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

//	Set the system property and Launch the URL	
//	Click the 'sort on date' checkbox	
//	clear and type in the from station text field	
//	clear and type in the to station text field	
//	Add a java sleep for 2 seconds	
//	Store all the train names in a list	
//	Get the size of it	
//	Add the list into a new Set	
//	And print the size of it

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		System.out.println("Browser Launched Sucessfully");

		driver.manage().window().maximize();

		// clear and type in the source station
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("txtStationFrom"))));
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Mgr Ch");
		
		driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("Source: Chennai selected sucessfully");

		// clear and type in the destination station
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("txtStationTo"))));
		driver.findElement(By.id("txtStationTo")).clear();	
		driver.findElement(By.id("txtStationTo")).sendKeys("Coimba");
		Thread.sleep(2000);
		driver.findElement(By.id("txtStationTo")).sendKeys(Keys.TAB);
		System.out.println("Destination: Coimbatore selected sucessfully");

		// Find all the train names using xpath and store it in a list
		List<WebElement> trainlist = driver
				.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]/a"));
		System.out.println("The Total train size from list : " + trainlist.size());
		
		Set<String> unique = new HashSet<String>();
		for (WebElement trains : trainlist) {
			String names = trains.getText();
			unique.add(names);
		}

		System.out.println("The Unique Train size from set: " + unique.size());

	}

}
