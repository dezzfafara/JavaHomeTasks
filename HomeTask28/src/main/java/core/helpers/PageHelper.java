package core.helpers;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class PageHelper {

	public void closeNotUsedTabs(WebDriver driver) {
		String currentTab = driver.getWindowHandle();
		driver.getWindowHandles().stream().filter(t -> !currentTab.equals(t))
				.forEach(t -> driver.switchTo().window(t).close());
		driver.switchTo().window(currentTab);
	}

	public void switchToCurrentTab(WebDriver driver) {
		ArrayList<String> tabsList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabsList.get(tabsList.size() - 1));
	}

}
