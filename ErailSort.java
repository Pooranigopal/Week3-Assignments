package Week3Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	/*
	 * // Launch the browser // Launch the URL - https://erail.in/ // Uncheck the
	 * check box - sort on date // clear and type in the source station // clear and
	 * type in the destination station // Find all the train names using xpath and
	 * store it in a list // Use Java Collections sort to sort it and then print it
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		System.out.println("Browser Launched Sucessfully");

		driver.manage().window().maximize();

		// Uncheck the check box - sort on date

		driver.findElement(By.id("chkSelectDateOnly")).click();
		System.out.println("Unchecked the checkbox");
		Thread.sleep(2000);

		// clear and type in the source station	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("txtStationFrom"))));
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Mgr Ch");
		Thread.sleep(2000);
		driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.ENTER);
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
		ArrayList<String> trainnames = new ArrayList<String>();

		for (WebElement trains : trainlist) {
			String names = trains.getText();
			trainnames.add(names);

		}

		// Use Java Collections sort to sort it and then print it
		Collections.sort(trainnames);
		System.out.println("The Total Trains are : " + trainnames.size());

		System.out.println("The Train Names are: " + trainnames);

	}

}
