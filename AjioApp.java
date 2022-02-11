package week3.day2.assignment4;
	
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AjioApp
{
	public static void main(String[] args) throws InterruptedException {	
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.ajio.com/");
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);
        driver.findElement(By.xpath("//label[@for='Men']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//label[contains(@class,'facet-linkname facet-linkname-l1l3nestedcategory')])[3]")).click();
        Thread.sleep(2000);
        String totalItems = driver.findElement(By.className("length")).getText();
		System.out.println("Total number of items : " + totalItems);
		System.out.println(" List of Brands");
		//print the list of travelBags Brands
		List<WebElement>bagBrandList =  driver.findElements(By.className("brand"));
		System.out.println(" Size :" + bagBrandList.size());
        for (WebElement list : bagBrandList) {
			String text =list.getText();
			System.out.println(text);
		}
        List<WebElement>OccasionList = driver.findElements(By.xpath("//span[text()='occasion']"));
        System.out.println(" Size :" + OccasionList.size());

   for (WebElement occasion : OccasionList) 
		{
	   String text=occasion.getText();
	   System.out.println(text);
			
		}
//   List<WebElement>sizeList = driver.findElements(By.xpath("//div[@id='facets']/div[2]/ul[1]/li[8]/div[1]/div[1]/div[1]"));
//	System.out.println(" Size :" +sizeList.size());
//for (WebElement fit : sizeList) 
//	{
//	String text =fit.getText();
//  System.out.println(text);
//		
//	}
   
   
}
}