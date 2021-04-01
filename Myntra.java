package Week3Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	/*
	 * 1) Open https://www.myntra.com/ 2) Mouse over on WOMEN 3) Click Jackets &
	 * Coats 4) Find the total count of item 5) Validate the sum of categories count
	 * matches 6) Check Coats 7) Click + More option under BRAND 8) Type MANGO and
	 * click checkbox 9) Close the pop-up x 10) Confirm all the Coats are of brand
	 * MANGO 11) Sort by Better Discount 12) Find the price of first displayed item
	 * 13) Mouse over on size of the first item 14) Click on WishList Now 15) Close
	 * Browser
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		System.out.println("Browser Launched Sucessfully");
		driver.manage().window().maximize();

		Actions actions = new Actions(driver);

		WebElement womenMenu = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[@href='/shop/women']"));
		actions.moveToElement(womenMenu).build().perform();
		// actions.moveToElement(womenMenu).perform();
		driver.findElement(By.linkText("Jackets & Coats")).click();
		System.out.println("Navigated to Women Menu and clicked on Jacket and coats");

		// Find the total count of item

		WebElement totalelement = driver.findElement(By.xpath("//span[@class='title-count']"));
		String Text = totalelement.getText();
		String count = Text.replaceAll("[^0-9]", "");
		int TotalCount = Integer.parseInt(count);

		// Validate the sum of categories count matches

		WebElement jackets = driver.findElement(By.xpath("//input[@value='Jackets']/following-sibling::span"));
		String jackcount = jackets.getText();
		String jacketscount = jackcount.replaceAll("[^0-9]", "");
		System.out.println("The JacketCount is: " + jacketscount);
		int count2 = Integer.parseInt(jacketscount);

		WebElement coats = driver.findElement(By.xpath("//input[@value='Coats']/following-sibling::span"));
		String coatText = coats.getText();
		String coatscount = coatText.replaceAll("[^0-9]", "");
		System.out.println("The Coat Count is: " + coatscount);
		int count3 = Integer.parseInt(coatscount);
		int Sum = count2 + count3;
		System.out.println("The sum of jackets & coats are: " + Sum);

		if (TotalCount == Sum) {

			System.out.println("The Counts are matching");

		} else {

			System.out.println("The Counts are not matching");

		}

		// Check Coats
		driver.findElement(By.xpath("//ul[@class='categories-list']/li[2]//div")).click();

		// Click + More option under BRAND
		driver.findElement(By.className("brand-more")).click();

		// Type MANGO and click checkbox
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("MANGO");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='FilterDirectory-panel FilterDirectory-expanded']//div[2]//div"))
				.click();
		Thread.sleep(5000);

		// Close the pop-up
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']//span")).click();

		// Confirm all the Coats are of brand MANGO
		List<WebElement> name = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		int brandsize = name.size();
		List<String> productname = new ArrayList<String>();

		for (WebElement eachname : name) {
			String brandname = eachname.getText();
			productname.add(brandname);
		}

		if (productname.contains("MANGO")) {
			System.out.println("All Listed Coats are belongs to MANGO");
		} else {
			System.out.println("Any coat listed is not part of MANGO Brand");

		}

		// Sort by Better Discount
		WebElement sortby = driver
				.findElement(By.xpath("//div[@class='horizontal-filters-sortContainer']//div//div[1]"));
		actions.moveToElement(sortby).build().perform();

		WebElement betterdiscount = driver
				.findElement(By.xpath("//div[@class='horizontal-filters-sortContainer']//ul//li[3]//label"));
		Thread.sleep(2000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOf(betterdiscount));
		betterdiscount.click();
		System.out.println("Clicked on Better Discount");

		// Mouse over on size of the first item
		WebElement overimage = driver.findElement(By.xpath("//ul[@class='results-base']/li[1]//div[@class='product-imageSliderContainer']"));
		Thread.sleep(2000);
		actions.moveToElement(overimage).build().perform();

		// Click on WishList Now
		WebElement whishlist = driver.findElement(By.xpath("//ul[@class='results-base']/li[1]//div[@class='product-actions ']//span"));
		whishlist.click();
		System.out.println("The whishlist selected");

		// Close Broswer
		driver.close();
		System.out.println("The Browser Closed Sucessfully");

	}
}
