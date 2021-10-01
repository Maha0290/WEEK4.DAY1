package week4.day1.assignment;



	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class CherCher {

		public static void main(String[] args) {
			
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
			String title=driver.getTitle();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			System.out.println(title);
			
			WebElement Frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
			driver.switchTo().frame(Frame1);
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Frames In Selenium");
			WebElement Frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
			driver.switchTo().frame(Frame3);
			
			driver.findElement(By.xpath("//input[@id='a']")).click();
			
			driver.switchTo().defaultContent();
			
			
			WebElement Frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
			driver.switchTo().frame(Frame2);
			
			WebElement Dropdownselect = driver.findElement(By.xpath("//select[@id='animals']"));
			Select drop=new Select(Dropdownselect);
			drop.selectByIndex(2);
			
		
		
		}

	}