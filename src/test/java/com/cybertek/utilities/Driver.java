package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
    Creating the private constructor so this classes object is not reachable from outside
     */
    private Driver(){}

    /*
    Making out driver instance private so that it is not reachable from the outside of th class.
    We make it static, because we want it to run before everything else, and also we will use it in static method
     */
   private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

   public static WebDriver getDriver(){
       if (driverPool.get() == null) {
           synchronized (Driver.class) {
           /*
           We read our browser type from configuration.properties file using .getProperty method we creating in
           ConfigurationReader class.
            */
               String browserType = ConfigurationReader.getProperty("browser");
           /*
           Depending on the browser type our switch statement will determine to open a specific type of browser/driver
            */
               switch (browserType) {
                   case "chrome":
                       WebDriverManager.chromedriver().setup();
                       driverPool.set(new ChromeDriver());
                       driverPool.get().manage().window().maximize();
                       driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                       break;
                   case "firefox":
                       WebDriverManager.firefoxdriver().setup();
                       driverPool.set(new FirefoxDriver());
                       driverPool.get().manage().window().maximize();
                       driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                       break;
               }
           }
       }
       /*
       Same driver instance will be returned every time we call Driver.getDriver(); method
        */
       return driverPool.get();
   }

   public static void closeDriver(){
        if(driverPool !=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
