package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class SeleniumStarter {
    public String seleniumStart(String url){
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        // Создание экземпляра WebDriver
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(1000000, TimeUnit.SECONDS);

        driver.get(url);
        // Ожидание загрузки страницы
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".kdslYa")));

        // Получение HTML-кода страницы
        String html = driver.getPageSource();
        driver.quit();
        return html;
    }
}
