package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void switchWindowToChild()
	{
		Set<String> win = driver.getWindowHandles();
		Iterator<String> iter = win.iterator();
		iter.hasNext();
		String parentwindow = iter.next();
		String childwindow = iter.next();
		driver.switchTo().window(childwindow);
	}

}
