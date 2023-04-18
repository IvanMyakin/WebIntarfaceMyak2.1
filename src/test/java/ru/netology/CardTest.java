package ru.netology;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


class CardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;


    }

    @Test
    public void positiveTestForm() {

        driver.get("http://localhost:9999/");
        driver.findElements(By.cssSelector("[data-test-id=name]input)")).sendKeys("Иван");
        driver.findElements(By.cssSelector("[data-test-id=phone]input)")).sendKeys("+79059657495");
        driver.findElements(By.cssSelector("[data-test-id=agreement]input)")).click();
        driver.findElements(By.cssSelector("button.button")).click();


    }


}