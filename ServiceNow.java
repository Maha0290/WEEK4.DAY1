package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev112523.service-now.com");
		String title=driver.getTitle();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println(title);
		Thread.sleep(1000);
		
		
		
		WebElement Frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(Frame1);
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("bfpfFW5RxP0W");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incidents");
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		
		WebElement Frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(Frame2);
		
		driver.findElement(By.xpath("//b[text()='All']")).click();
		driver.findElement(By.xpath("//button[@class='selected_action action_context btn btn-primary']")).click();
		WebElement instanceNum = driver.findElement(By.id("incident.number"));
		String Nume=instanceNum.getAttribute("value");
		System.out.println("The Instance Created Is :  "+Nume);
		
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']/span")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> WindHand=new ArrayList<String>(windowHandles);
		driver.switchTo().window(WindHand.get(1));
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("System Adminstrator",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		/*
		 * //driver.findElement(By.linkText("System Administrator")).click();
		 * //driver.close(); //driver.switchTo().defaultContent(); //WebElement frame3 =
		 * driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		 * //driver.switchTo().frame(frame3);
		 * //driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']"
		 * )).sendKeys("System Administrator"); //driver.close();
		 */		
		driver.switchTo().window(WindHand.get(0));
		String title3 = driver.getTitle();
		System.out.println(title3);
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame3);
		
		
		
		//driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys("System Administrator");
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Sys Admin");
		driver.findElement(By.xpath("//button[@class='form_action_button  action_context btn btn-default'][1]")).click();
		//driver.findElement(By.xpath("//input[@name='5c1ae6b21bb630102e66a8e5604bcbfa_text']")).sendKeys(Nume);
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(Nume+Keys.ENTER);
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snaps/incident.png");
		FileUtils.copyFile(src, dst);
	}
	

}