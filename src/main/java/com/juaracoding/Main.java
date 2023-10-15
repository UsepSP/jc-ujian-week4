package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
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

        //instance Android driver
        AndroidDriver driver = new AndroidDriver<>(url,desiredCapabilities);

        delay(5);
        MobileElement izin = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        izin.click();
        delay(2);
        MobileElement start = (MobileElement) driver.findElementById("android:id/button2");
        start.click();
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click();
        driver.findElementById("com.chad.financialrecord:id/btnIncome").click();
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
////        MobileElement selectKtg = (MobileElement) driver.findElementById("com.chad.financialrecord:id/spCategory");
//        MobileElement nominal = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
////        MobileElement nominal = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
//        MobileElement ket = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
//        MobileElement save = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");



//        input.click();
//        inputMasuk.click();
//        inputKtg.click();
//        nominal.sendKeys("200000");
//        ket.sendKeys("ok");
//        save.click();

//        MobileElement hasil = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
//        String txtHasil = hasil.getText();
//        System.out.println(txtHasil);
//        if (txtHasil.equals("3")){
//            System.out.println("Passes");
//        } else {
//            System.out.println("Failed");
//        }
//        assertEquals(txtHasil,"3");

        // 3-4
//        MobileElement tiga = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
//        MobileElement empat = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
//        MobileElement kurang = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@content-desc,\"kura\")]");
//        tiga.click();
//        kurang.click();
//        empat.click();
//        samaDengan.click();
//        MobileElement hasilKurang = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
//        String txtHasilKurang = hasilKurang.getText();
//        System.out.println(txtHasilKurang);
//        if (txtHasilKurang.equals("−1")){
//            System.out.println("Passes");
//        } else {
//            System.out.println("Failed");
//        }
//        assertEquals(txtHasilKurang,"−1");

//        driver.quit();
    }

//    public static void assertEquals(String actual, String expected){
//        if (actual.equals(expected)){
//            System.out.println("Passes");
//        } else {
//            System.out.println("Failed");
//        }
//    }
static void delay (long detik) {
    try {
        Thread.sleep(detik * 1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

}