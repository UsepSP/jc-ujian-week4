import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestApp {
    //instance Android driver
    private AndroidDriver driver;
    private MobileElement samaDengan;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        //DesiredCapabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "SM_M236B");
        desiredCapabilities.setCapability("udid","RRCT303G9VB");
        desiredCapabilities.setCapability("platforName","android");
        desiredCapabilities.setCapability("appPackage","com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("noreset",true);

        //URL
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<>(url,desiredCapabilities);


    }
    @AfterClass
    public void finish(){
        driver.quit();
    }

    @Test
    public void testAdd(){
        MobileElement satu = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement dua = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement tambah = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_add");
        samaDengan = (MobileElement) driver.findElementById("com.google.android.calculator:id/eq");
        satu.click();
        tambah.click();
        dua.click();
        samaDengan.click();
        MobileElement hasil = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        String txtHasil = hasil.getText();
        System.out.println(txtHasil);
        Assert.assertEquals(txtHasil,"3");
    }

    @Test
    public void testSub(){
        MobileElement tiga = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement empat = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement kurang = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@content-desc,\"kura\")]");
        tiga.click();
        kurang.click();
        empat.click();
        samaDengan.click();
        MobileElement hasilKurang = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        String txtHasilKurang = hasilKurang.getText();
        System.out.println(txtHasilKurang);
        Assert.assertEquals(txtHasilKurang,"−1");
    }
}
