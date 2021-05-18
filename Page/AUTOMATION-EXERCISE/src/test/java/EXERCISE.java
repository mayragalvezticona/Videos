/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.time.Clock.system;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Usuario
 */
public class EXERCISE {
    
    public static WebDriver driver;
    
    public static WebDriver accessPage() throws Exception {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://automationpractice.com");
    // AUTENTICACION
    driver.findElement(By.xpath("//nav/div/a")).click();
    driver.findElement(By.xpath("//div[2]/form/div/div/input")).click();
    driver.findElement(By.xpath("//div[2]/form/div/div/input")).clear();
    TimeUnit.MILLISECONDS.sleep(7000);
    driver.findElement(By.xpath("//div[2]/form/div/div/input")).sendKeys("mayragalvezticona@gmail.com");
    TimeUnit.MILLISECONDS.sleep(1000);
    driver.findElement(By.xpath("//span/input")).clear();
    driver.findElement(By.xpath("//span/input")).sendKeys("6064742Lp");
    TimeUnit.MILLISECONDS.sleep(2000);
    driver.findElement(By.id("login_form")).submit();
    TimeUnit.MILLISECONDS.sleep(1000);
    return driver;
    }
      
       
    @Test    
    public void testSimple() throws Exception {
    driver = accessPage();
    driver.findElement(By.xpath("//p[2]/button/span")).click();
    TimeUnit.MILLISECONDS.sleep(1000);
    driver.findElement(By.xpath("(//a[contains(text(),'Dresses')])[5]")).click();
    TimeUnit.MILLISECONDS.sleep(3000);
    driver.findElement(By.xpath("//div[@id='center_column']/ul/li/div/div[2]/div[2]/a/span")).click();
    TimeUnit.MILLISECONDS.sleep(3000);
    driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/a/span")).click();
    //CONFIRMACION DE LA COMPRA
    TimeUnit.MILLISECONDS.sleep(1000);
    driver.findElement(By.xpath("//div[@id='center_column']/p[2]/a/span")).click();
    TimeUnit.MILLISECONDS.sleep(1000);
    driver.findElement(By.xpath("//div[@id='center_column']/form/p/button/span")).click();
    TimeUnit.MILLISECONDS.sleep(1000);
    driver.findElement(By.id("cgv")).click();
    TimeUnit.MILLISECONDS.sleep(1000);
    driver.findElement(By.xpath("//form[@id='form']/p/button/span")).click();
    TimeUnit.MILLISECONDS.sleep(1000);
    driver.findElement(By.xpath("//div[@id='HOOK_PAYMENT']/div/div/p/a/span")).click();
    TimeUnit.MILLISECONDS.sleep(1000);
    driver.findElement(By.xpath("//p[@id='cart_navigation']/button/span")).click();
    // VERIFICACION DE LA COMPRA Y ASSERT
    TimeUnit.MILLISECONDS.sleep(1000);
    String bodyText;
    bodyText = driver.findElement(By.xpath("//div[@id='center_column']/div")).getText();
    System.out.println(bodyText);
    assertTrue(bodyText.contains("Your order on My Store is complete."));
    }    
}
