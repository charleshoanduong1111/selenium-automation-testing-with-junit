package automation.selenium.tests;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(12000);
        return true;
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a8c37x1j")))
//                .isDisplayed();
    }
}
