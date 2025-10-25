package Auth_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestData;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() throws InterruptedException {
        driver.findElement(By.id("inputUsername")).sendKeys(TestData.USERNAME);
        driver.findElement(By.name("inputPassword")).sendKeys(TestData.PASSWORD);
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(2000); // Wait for page to load

        String successMsg = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(successMsg, "You are successfully logged in.");
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {
        driver.findElement(By.id("inputUsername")).sendKeys(TestData.INVALID_USERNAME);
        driver.findElement(By.name("inputPassword")).sendKeys(TestData.INVALID_PASSWORD);
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(2000);

        String errorMsg = driver.findElement(By.cssSelector("p.error")).getText();
        Assert.assertTrue(errorMsg.contains("Incorrect username or password"));
    }
}
