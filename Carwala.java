package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Carwala {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.carwale.com/");
		driver.findElement(By.xpath("//span[@data-unique-key='used']")).click();
		
		
		WebElement city=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		city.sendKeys("Chennai",Keys.ENTER);
		Thread.sleep(2000);
		WebElement selectCity = driver.findElement(By.xpath("//div[@class='o-fznJzu o-fznJPk o-OAYdd o-dbKqqe o-cpnuEd o-bUVylL o-eMXLyl o-GFmfi']"));
		Actions builder=new Actions(driver);
		builder.doubleClick(selectCity).perform();
		WebElement Slider1 = driver.findElement(By.xpath("(//button[@role='slider'])[1]"));
		WebElement Slider2 = driver.findElement(By.xpath("(//button[@role='slider'])[2]"));
		Point location=Slider1.getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println(x);
		System.out.println(y);
		
		builder.dragAndDropBy(Slider1, 60, 0).perform();
		builder.dragAndDropBy(Slider2,-129, 0).perform();
	}

}