import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasicTest {
public static String userName = "karthikadeveloper";
public static String accessKey = "LT_ToiGOg9prrrKJ0DODrl7mwunzMCh5YrM4TfiXLcXQKZzLvY";
public static String APP_URL = "https://" +userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub";
private static AppiumDriver driver;

public static void main(String args[]) throws MalformedURLException, InterruptedException {

try {
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("deviceName", "Galaxy S20");
capabilities.setCapability("platformVersion", "11");
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("isRealMobile", true);
capabilities.setCapability("app", APP_URL);
capabilities.setCapability("deviceOrientation", "PORTRAIT");
capabilities.setCapability("build", "Java Vanilla - Android");
capabilities.setCapability("name", "Sample Test Java");
capabilities.setCapability("console", true);
capabilities.setCapability("network", false);
capabilities.setCapability("visual", true);
capabilities.setCapability("devicelog", true);

driver = new AppiumDriver(new URL(APP_URL), capabilities);

WebElement color = (WebElement) driver.findElement(By.id("com.lambdatest.proverbial:id/color"));
color.click();

WebElement text = (WebElement) driver.findElement(By.id("com.lambdatest.proverbial:id/Text"));
//Changes the text to proverbial
text.click();

//toast is visible
WebElement toast = (WebElement) driver.findElement(By.id("com.lambdatest.proverbial:id/toast"));
toast.click();

//notification is visible
WebElement notification = (WebElement) driver.findElement(By.id("com.lambdatest.proverbial:id/notification"));
notification.click();

//Open the geolocation page
WebElement geo = (WebElement) driver.findElement(By.id("com.lambdatest.proverbial:id/geoLocation"));
geo.click();
Thread.sleep(5000);

driver.navigate().back();

//Opens the browser
WebElement browser = (WebElement) driver.findElement(By.id("Browser"));
browser.click();

WebElement url = (WebElement) driver.findElement(By.id("com.lambdatest.proverbial:id/url"));
url.sendKeys("https://www.lambdatest.com");
WebElement find = (WebElement) driver.findElement(By.id("com.lambdatest.proverbial:id/find"));
find.click();

} catch (AssertionError a) {
((JavascriptExecutor) driver).executeScript("lambda-status=failed");
a.printStackTrace();
}
// The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.
driver.quit();
}
}

