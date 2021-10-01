package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		String title=driver.getTitle();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println(title);
		WebElement Frame1 = driver.findElement(By.xpath("//div[@id='wrapframe']/iframe[1]"));
		driver.switchTo().frame(Frame1);
		WebElement Button1 = driver.findElement(By.xpath("//button[@id='Click']"));
		File src=Button1.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snaps/button.png");
		FileUtils.copyFile(src, dst);
		Button1.click();
	
		System.out.println("Clicking  Button 1  :  "+Button1.getText());
		 driver.switchTo().parentFrame();
		 WebElement framenes1 = driver.findElement(By.xpath("//iframe[@src='page.html']"));
			driver.switchTo().frame(framenes1);
			WebElement framenes2 = driver.findElement(By.xpath("//iframe[@src='nested.html']"));
			driver.switchTo().frame(framenes2);
			System.out.println("clicking Button nested Frame    ");
			driver.findElement(By.id("Click1")).click();
			 //driver.switchTo().parentFrame();
			 driver.switchTo().defaultContent();
		
		List<WebElement> noOfFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("The Number Of Frames In The Given Page Is :"+noOfFrames.size());

	}

}