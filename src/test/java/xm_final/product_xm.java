package xm_final;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class product_xm {
	
	WebDriver driver;
	
	@Given("User is on home page")
	public void user_is_on_home_page() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\TRAINING_B6B.00.10\\Desktop\\Browsers_and_Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		String url="http://10.232.237.143:443/TestMeApp/fetchcat.htm";
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("SignIn")).click();
	}
	
	@When("User enters username and password and click on Login button")
	public void user_enters_username_and_password_and_click_on_Login_button() {
		driver.findElement(By.name("userName")).sendKeys("lalitha");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Then("User should be logged in and Verified")
	public void user_should_be_logged_in_and_Verified() {
		Assert.assertEquals("Home", driver.getTitle());
		System.out.println("Login Page is displayed and Verified the user");
	}
	
	@Given("Navigate to All categories - electronics and Head phone")
	public void navigate_to_All_categories_electronics_and_Head_phone() throws InterruptedException {
		Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a"))).perform();
		Thread.sleep(1000);
		act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a"))).click().perform();
		Thread.sleep(1000);
		act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a"))).click().build().perform();
		Thread.sleep(2000);
	}
	
	@Given("Add product into shopping cart")
	public void add_product_into_shopping_cart() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
		Thread.sleep(2000);
	}
	
	@When("proceed to Checkout")
	public void proceed_to_Checkout() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("ShippingAdd")).sendKeys("Bengaluru");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		Thread.sleep(5000);
	}
	
	@When("select bank and add credentials")
	public void select_bank_and_add_credentials() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
		driver.findElement(By.id("btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("123456");
		//driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("123456");
		driver.findElement(By.name("password")).sendKeys("Pass@456");
		//driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("Pass@456");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		//driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();
		Thread.sleep(2000);
	    System.out.println("It is redirected to Order details Page as purchase is complete");
	    driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
	    Thread.sleep(2000);
	}
	
	@Then("redirected to the thank you page")
	public void redirected_to_the_thank_you_page() {
		System.out.println("Thank you Page is displayed");
		driver.close();
	}

}
