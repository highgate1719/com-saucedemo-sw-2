package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * <p>
 * 1. LoginTest
 * <p>
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValid Credentials
 * <p>
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * <p>
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on
 * page
 */


public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);

    }
    @Test

    public void userShouldLoginWithValidCredentials() throws InterruptedException {

        //Enter username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on 'Login' button
        driver.findElement(By.id("login-button")).click();

        //verify the text 'Products'
        String expectedMessage = "Products";
        WebElement message = driver.findElement(By.xpath("//div[@class='header_secondary_container']//span[@class='title']"));
        String actualMessage = message.getText();//converting webElement into string
        Assert.assertEquals(expectedMessage, actualMessage);//verifying using the assert method
        Thread.sleep(4000);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {

        //Enter username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on 'Login' button
        driver.findElement(By.id("login-button")).click();

        //Verify that six products are displayed on page

        List<WebElement> count = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int totalcount = count.size();
        System.out.println("Total Products are : " + totalcount);
        Thread.sleep(4000);
    }
    @After
    public void TearDown() {
        closeBrowser();
    }
}
