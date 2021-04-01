package Week3Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitElementsAppear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Lanch URL
		driver.get("http://www.leafground.com/pages/appear.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement until = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//b[contains(text(),'Voila')]"))));
		String text = until.getText();
		System.out.println("The appread button text is : " + text);

	}

}
