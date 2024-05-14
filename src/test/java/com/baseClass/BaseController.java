package com.baseClass;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.controllerInterface.ControllerInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utility.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseController implements ControllerInterface {
	static Readconfig readconfig = new Readconfig();
	public static String baseURL = readconfig.getApplicationURL();
	public static WebDriver driver;
	public WebDriverWait wait;
	public static String browserName = readconfig.getbrowser();
	public static String loginURL = readconfig.getLoginUrl();

	public void Initialization() {
		browserName = System.getProperty("browser") != null ? System.getProperty("browser") : readconfig.getbrowser();

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

	}

	public void teardown() {
		driver.close();
	}

	public WebDriver getDriver() {
		return driver;

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap- Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	@Override
	public boolean click(WebDriver driver, WebElement element) {
		try {
			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
			
			if(ele.isDisplayed()) {
				if(ele.isEnabled()) {
					try {
						ele.click();
						Actions action = new Actions(driver);
						action.moveToElement(ele);
						action.click(ele);				
						return true;
					}
					catch(Exception e) {
						JavascriptExecutor js = ((JavascriptExecutor) driver);
						js.executeScript("arguments[0].click();", ele);
					}	
				}
				else {
					throw new Exception("Element is not enabled");
				}
			}
			else {
				throw new Exception("Element is not displayed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getText(WebElement element) {
		String textValue = "";
		try {
			if (element.isDisplayed()) {
				textValue = element.getText();
				System.out.println("Text value:- " + textValue);
			} else {
				System.out.println("Element is not visible");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textValue;
	}

	@Override
	public boolean type(WebElement element, String text) {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {

				element.clear();
				element.sendKeys(text);
				flag = true;
				System.out.println("Successfully entered value");

			} else {
				flag = false;
				System.out.println("Unable to enter value");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {
				flag = true;
				System.out.println("The element is Displayed" + element);

			} else {
				flag = false;
				System.out.println("The element is not Displayed" + element);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean isSelected(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			if (element.isSelected()) {
				flag = true;
				System.out.println("The element is Selected");

			} else {
				flag = false;
				System.out.println("The element is not Selected");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean isEnabled(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			if (element.isEnabled()) {
				flag = true;
				System.out.println("The element is Enabled");

			} else {
				flag = false;
				System.out.println("The element is not Enabled");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean selectByIndex(WebElement element, int index) {
		Select select;
		boolean flag = false;
		try {
			if (element.isDisplayed()) {

				select = new Select(element);
				select.selectByIndex(index);
				flag = true;
				System.out.println("Option selected by Index");

			} else {
				flag = false;
				System.out.println("Option not selected by Index");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean selectByValue(WebElement element, String value) {
		Select select;
		boolean flag = false;
		try {
			if (element.isDisplayed()) {

				select = new Select(element);
				select.selectByValue(value);
				flag = true;
				System.out.println("Option selected by value");

			} else {
				flag = false;
				System.out.println("Option not selected by value");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean selectByVisibleText(String visibletext, WebElement element) {
		Select select;
		boolean flag = false;
		try {
			if (element.isDisplayed()) {

				select = new Select(element);
				select.selectByVisibleText(visibletext);
				flag = true;
				System.out.println("Option selected by visibletext");

			} else {
				flag = false;
				System.out.println("Option not selected by visibletext");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			driver.switchTo().frame(index);
			flag = true;

			if (flag) {
				System.out.println("Frame is selected");
			} else {
				System.out.println("Frame is not selected");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean switchToFrameById(WebDriver driver, String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;

			if (flag) {
				System.out.println("Frame is selected");
			} else {
				System.out.println("Frame is not selected");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean switchToFrameByName(WebDriver driver, String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;

			if (flag) {
				System.out.println("Frame is selected");
			} else {
				System.out.println("Frame is not selected");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;

			if (flag) {
				System.out.println("Frame is selected");
			} else {
				System.out.println("Frame is not selected");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Override
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		try {
			action.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void rightclick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		try {
			action.contextClick(element).perform();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void Alert(WebDriver driver) {
		try {
			driver.switchTo().alert();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	@Override
	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();

	}

}
