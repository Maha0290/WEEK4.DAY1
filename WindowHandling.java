package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leaftaps.com/opentaps/control/login");
	
	String title=driver.getTitle();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	System.out.println(title);
	WebElement username=driver.findElement(By.id("username"));
	username.sendKeys("demosalesmanager");
	WebElement password=driver.findElement(By.id("password"));
	password.sendKeys("crmsfa");
	
	WebElement loginbutton=driver.findElement(By.className("decorativeSubmit"));
	loginbutton.click();
	WebElement crmsfa=driver.findElement(By.linkText("CRM/SFA"));
	crmsfa.click();
	WebElement contacts=driver.findElement(By.linkText("Contacts"));
	contacts.click();
	WebElement mergeContact=driver.findElement(By.linkText("Merge Contacts"));
	mergeContact.click();
	driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
	
	
	Set<String> windowHandlesOfMerge = driver.getWindowHandles();
	List<String> listWinHandle=new ArrayList<String>(windowHandlesOfMerge);
	driver.switchTo().window(listWinHandle.get(1));
	System.out.println("Control Transferred to new window");
	String title2 = driver.getTitle();
	System.out.println(title2);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(listWinHandle.get(0));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']//following-sibling::a")).click();
	
	Set<String> windowHandlesSecond = driver.getWindowHandles();
	List<String> listWinHandle2=new ArrayList<String>(windowHandlesSecond);
	driver.switchTo().window(listWinHandle2.get(1));
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
	driver.switchTo().window(listWinHandle.get(0));
	
	driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	
	Alert alert=driver.switchTo().alert();
	alert.accept();
	
	String title3 = driver.getTitle();
	System.out.println("Title Of The Page after merging the contacts      "+title3);
	if(title3.equalsIgnoreCase("View Contact | opentaps CRM"))
	{
		System.out.println("Successfully Merged");
	}
	else
		System.out.println("Merge Unsuccessful");
}

}
