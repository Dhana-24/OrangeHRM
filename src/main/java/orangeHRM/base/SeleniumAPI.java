package orangeHRM.base;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface SeleniumAPI {
	
	//**********************This function closes the browser****************************************
	void close();
	
	//**********************This function quits the driver******************************************
	void quit();
	
	//**********************This function switches to next window************************************
	void switchToWindow(int i);
	
	//**********************This function selects value from drop down using value*******************
	void selectValue(WebElement element, String value);
	
	//**********************This function selects value from drop down using text***********************
	void selectText(WebElement element, String text);
	
	//**********************This function selects value from drop down using index**********************
	void selectIndex(WebElement element, int position);
	
	//**********************This function clicks the given element***************************************
	void click(WebElement ele);
	
	//**********************This function appends the given text to the given field**********************
	void appendText(WebElement ele,String text);
	
	//**********************This function accepts the alert***********************************************
	void acceptAlert();
	
	//**********************This function types the given text in the given field and clicks enter********
	void typeEnter(WebElement ele,String input, Keys keys);
	
	//**********************This function checks whether the drop down value is selected******************
	void isDropdownSelected(WebElement ele);
	
	//**********************This function returns the title of the tab************************************
	String getTitle(String expectedTitle);
	
	//**********************This function returns the URL of the tab**************************************
	String getURL(String expectedURL);
	
	//**********************This function checks whether the given element is displayed*******************
	Boolean isDisplayed(WebElement ele,String elementName) throws InterruptedException;

	//**********************This function types the given text in the given field*************************
	void type(WebElement element, String input, String fieldName);
	
	

}
