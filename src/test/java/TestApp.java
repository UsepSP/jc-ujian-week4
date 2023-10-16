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
    private static MobileElement tambah;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        //DesiredCapabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "SM_M236B");
        desiredCapabilities.setCapability("udid","RRCT303G9VB");
        desiredCapabilities.setCapability("platforName","android");
        desiredCapabilities.setCapability("appPackage","com.chad.financialrecord");
        desiredCapabilities.setCapability("appActivity","com.rookie.catatankeuangan.feature.splash.SplashActivity");
        desiredCapabilities.setCapability("noreset",true);

        //URL
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url,desiredCapabilities);

        delay(2);
        driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
        delay(2);
        driver.findElementById("android:id/button2").click();


    }
    @AfterClass
    public void finish(){
        driver.quit();
    }

    @Test
    public void testAdd(){
        tambah = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@bounds,\"891\")]");
        tambah.click();
        delay(2);
        MobileElement input = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        MobileElement nominal = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        MobileElement note = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        MobileElement save = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");

        //step pemasukan
        input.click();
        nominal.sendKeys("10000");
        note.sendKeys("test input pemasukan");
        save.click();
        delay(1);
        MobileElement hasil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@bounds,\"922\")]");
        String txtHasil = hasil.getText();
        System.out.println(txtHasil);
        Assert.assertEquals(txtHasil,"10.000");

    }

    @Test
    public void testSub(){
        //input pengeluaran
        delay(2);
        tambah.click();
        delay(2);
        MobileElement  input2 = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnExpense");
        MobileElement nominal2 = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        MobileElement note2 = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        MobileElement save2 = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");

        //step keluar
        input2.click();
        nominal2.sendKeys("5000");
        note2.sendKeys("test input pengeluaran");
        save2.click();
        delay(1);
        MobileElement pengeluaran = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@bounds,\"935\")]");
        String txtPengeluaran = pengeluaran.getText();
        System.out.println(txtPengeluaran);
        Assert.assertEquals(txtPengeluaran,"5.000");

    }

    static void delay (long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
