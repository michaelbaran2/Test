import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;


import java.io.IOException;
import java.net.URL;

public class Main {

    private static AltUnityDriver altdriver;
    private static String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo4NTA5MjEsInhwLnAiOjIsInhwLm0iOjE2MDc4NzA0MDcyNTQsImV4cCI6MTkyMzIzMDQwNywiaXNzIjoiY29tLmV4cGVyaXRlc3QifQ.bJbLAoXUpJcg4yoZW5cqTC1Fsok2ma7gkSCpa9-p3lI";
    protected static AndroidDriver<AndroidElement> driver = null;
    protected static DesiredCapabilities dc = new DesiredCapabilities();


    @BeforeClass
    public static void setUp() throws IOException {
        dc.setCapability("testName", "Quick Start Android Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@serialNumber='03157df345891f29'");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.moonactive.coinmaster/com.moon.coinmaster.android.GameActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.moonactive.coinmaster");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.moon.coinmaster.android.GameActivity");
        driver = new AndroidDriver<>(new URL("https://demo.experitest.com/wd/hub"), dc);

        AltUnityDriver.setupPortForwarding("android", "03157df345891f29", 13000, 13000);
        altdriver = new AltUnityDriver();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        altdriver.stop();
        AltUnityDriver.removePortForwarding();
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }

    @Test
    public void openClosePanelTest() {
        try {
            Thread.sleep(1000);
            AltFindObjectsParameters parameters = new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//SOMETHING").build();
//            AltFindObjectsParameters parameters = new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//*[@contentDescription='Game view']").build();
            AltUnityObject element = altdriver.findObject(parameters);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
