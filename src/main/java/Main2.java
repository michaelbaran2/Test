import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main2 {

    private static String accessKey = "eyJ4cC51IjoyOTAwNDUwLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVM05ESTBNemcwTkRZMk5nIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4ODk2MDM4NDQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.Ti-FFGyC11-m8H-FIMn8cVUVvJvqkh9rGOKGQJYg3vk";
    protected static AndroidDriver<AndroidElement> driver = null;
    protected static DesiredCapabilities dc = new DesiredCapabilities();


    @BeforeClass
    public static void setUp() throws IOException {
        dc.setCapability("testName", "Quick Start Android Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("reservationDuration", "600");
        dc.setCapability("deviceQuery", "@serialNumber='031603c437ba1901'");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
//        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver = new AndroidDriver<>(new URL("https://mastercloud.experitest.com/wd/hub"), dc);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }

    @Test
    public void openClosePanelTest() {
//        for (int i = 30; i < 600; i+=10) {
//            System.out.println("@@@@@@@ " + i);
//            driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
//            try {
//                driver.findElement(By.xpath("//*[@text='There is no such button']"));
//            } catch (NoSuchElementException e) {
//
//            }
//        }
        driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
        try {
                driver.findElement(By.xpath("//*[@text='There is no such button']"));
        }
        catch (NoSuchElementException e) {}
    }
}
