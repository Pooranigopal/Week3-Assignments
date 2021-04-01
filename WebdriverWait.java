package Week3Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch the URL
		driver.get("http://leafground.com/pages/disapper.html");

		// maximize the window
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement disapperbtn = driver.findElement(By.xpath("//button[@id='btn']"));
		wait.until(ExpectedConditions.invisibilityOf(disapperbtn));
		
		
		//get the disappeared text
		WebElement text = driver.findElement(By.xpath("//div[@id='show']//strong"));
		String disaapertext = text.getText();
		System.out.println(disaapertext);
		
		//verify the btn is disappeared or not
		System.out.println(disapperbtn.isDisplayed());

	}
}
