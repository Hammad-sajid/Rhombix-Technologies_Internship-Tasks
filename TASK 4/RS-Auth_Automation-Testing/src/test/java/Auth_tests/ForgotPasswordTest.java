package Auth_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestData;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void testForgotPasswordFlow() throws InterruptedException {
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(TestData.FORGOT_PASSWORD_NAME);
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(TestData.FORGOT_PASSWORD_EMAIL);
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys(TestData.FORGOT_PASSWORD_NUMBER);

        driver.findElement(By.className("reset-pwd-btn")).click();

        Thread.sleep(1000);

        String message = driver.findElement(By.className("infoMsg")).getText();
        Assert.assertTrue(message.contains("Please use temporary password"));
    }
}
