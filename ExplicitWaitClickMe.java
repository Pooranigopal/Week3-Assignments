package Week3Assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitClickMe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch the URL
		driver.get("http://leafground.com/pages/TextChange.html");

		// maximize the window
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement until = wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Click')]"))));
		String text1 = until.getText();
		until.click();
		System.out.println(text1);

		Alert alert = driver.switchTo().alert();
		String text2 = alert.getText();
		System.out.println(text2);

		if (text2.contains(text1)) {

			System.out.println("Click ME! is same for button and popup");

		} else {

			System.out.println("Click ME! is different for button and popup");
		}

	}

}
