package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class Login {
    WebDriver wd;


    @BeforeMethod
    public void preConditions(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void login1() {
        click(By.cssSelector("[href='/login']"));
        pause(2000);
        type(By.cssSelector("#user"), "juliakliot.jk@gmail.com");
        click(By.cssSelector("#login"));
        pause(2000);
        type(By.cssSelector("#password"), "misha240613");
        click(By.cssSelector("#login-submit"));
        pause(2000);

        //[data-testid='header-member-menu-button']
        //[data-testid='header-member-menu-logout']
        //#logout-submit"

    }


    private void type(By locator, String text) {
        click(locator);
        wd.findElement(By.cssSelector("#user")).clear();
        wd.findElement(By.cssSelector("#user")).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }


    public void pause(int millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void postConditions(){
        wd.close();
        wd.quit();
    }
}