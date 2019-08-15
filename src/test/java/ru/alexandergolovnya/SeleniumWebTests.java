package ru.alexandergolovnya;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ITConfig.class)
public class SeleniumWebTests {

    @Autowired
    private WebDriver driver;

    private static final String BASE_URL = "http://localhost:8081/";

    /**
     * Method checks header on the home page
     */
    @Test
    public void checkHeaderTextOnHomePage() {
        driver.get(BASE_URL);
        WebElement working = driver.findElement(By.className("header-text"));
        Assert.assertThat(working.getText(), is(equalTo("Электронный университет")));
    }

    /**
     * Method checks site title
     */
    @Test
    public void checkSiteTitle() {
        driver.get(BASE_URL);
        Assert.assertEquals("university-spa-frontend-v2", driver.getTitle());
        System.out.println(driver.getTitle());
    }

    /**
     * Method checks process of sign in for a user
     */
    @Test
    public void checkLoginMethod() {
        driver.get(BASE_URL);
        driver.findElement(By.className("auth-button")).click();
        List<WebElement> webElements = driver.findElements(By.className("login-element-input"));
        webElements.forEach(webElement -> webElement.sendKeys("admin"));
        driver.findElement(By.className("login-element-button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement welcomeHeaderText = driver.findElement(By.className("home2"));
        Assert.assertThat(welcomeHeaderText.getText(), is(containsString("Добро пожаловать в университет")));
    }

    /**
     * Method checks process of creating new user and login method for this user
     *
     * @throws InterruptedException
     */
    @Test
    public void checkSignUpMethod() throws InterruptedException {
        driver.get(BASE_URL);
        List<WebElement> authButtons = driver.findElements(By.className("auth-button"));
        authButtons.get(1).click();

        String email = RandomStringUtils.randomAlphanumeric(10) + "@test.com";

        List<WebElement> formElements = driver.findElements(By.className("login-element-input"));
        formElements.get(0).sendKeys(email);
        formElements.get(1).sendKeys("password");
        formElements.get(2).sendKeys("Владимир");
        formElements.get(3).sendKeys("Ильич");
        formElements.get(4).sendKeys("Ленин");
        WebElement signUpButton = driver.findElement(By.className("login-element-button"));
        Assert.assertThat(signUpButton.getText(), is(equalTo("Зарегистрироваться")));
        signUpButton.submit();
        Thread.sleep(5000);

        List<WebElement> formLoginElements = driver.findElements(By.className("login-element-input"));
        formLoginElements.get(0).sendKeys(email);
        formLoginElements.get(1).sendKeys("password");
        driver.findElement(By.className("login-element-button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeHeaderText = driver.findElement(By.className("h1"));
        Assert.assertThat(welcomeHeaderText.getText(), is(containsString("Добро пожаловать в университет")));
    }

    /**
     * Method checks path to faculties home page after login
     */
    @Test
    public void checkFacultyPage() {
        checkLoginMethod();
        driver.findElement(By.linkText("Факультеты")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement pageHeader = driver.findElement(By.className("h1"));
        Assert.assertThat(pageHeader.getText(), is(equalTo("Факультеты")));
    }

    /**
     * Methods checks process of creating and editing faculty,
     * starting from faculty index page
     *
     * @throws InterruptedException
     */
    @Test
    public void checkFacultyCreateAndEdit() throws InterruptedException {
        checkFacultyPage();
        driver.navigate().refresh();
        driver.findElement(By.className("button-create")).click();

        final String facultyName = "Факультет " + RandomStringUtils.randomAlphanumeric(10);
        final String facultyDescription = "Описание факультета " + RandomStringUtils.randomAlphanumeric(40);

        WebElement form = driver.findElement(By.tagName("form"));

        form.findElement(By.id("entityName")).sendKeys(facultyName);
        form.findElement(By.id("entityDescription")).sendKeys(facultyDescription);
        form.submit();

        Thread.sleep(3000);

        // Got to the edit page
        List<WebElement> facultyCardButtons = getNewFacultyBody().findElements(By.className("card-button"));
        facultyCardButtons.get(0).click();

        WebElement facultyEditHeader = driver.findElement(By.className("jumbotron"));

        WebElement facultyEditHeaderText = facultyEditHeader.findElement(By.tagName("h1"));
        Assert.assertThat(facultyEditHeaderText.getText(), is(containsString(facultyName)));

        WebElement facultyEditDescriptionText = facultyEditHeader.findElement(By.tagName("p"));
        Assert.assertThat(facultyEditDescriptionText.getText(), is(containsString(facultyDescription)));

        final String newFacultyName = facultyName + " [EDITED]";
        final String newFacultyDescription = facultyDescription + " [EDITED]";

        // Edit faculty name and description
        driver.findElement(By.id("facultyName")).clear();
        driver.findElement(By.id("facultyName")).sendKeys(newFacultyName);
        driver.findElement(By.id("facultyDescription")).clear();
        driver.findElement(By.id("facultyDescription")).sendKeys(newFacultyDescription);

        driver.findElement(By.tagName("form")).submit();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(5000);

        // Check that user have been redirected from edit page to faculties main page
        WebElement pageHeader = driver.findElement(By.className("h1"));
        Assert.assertThat(pageHeader.getText(), is(equalTo("Факультеты")));

        // Check faculty edited header
        List<WebElement> newFacultyCardsHeaders = driver.findElements(By.className("card-header"));
        WebElement newFacultyHeader = newFacultyCardsHeaders.get(newFacultyCardsHeaders.size() - 1);
        Assert.assertThat(newFacultyHeader.getText(), is(containsString(newFacultyName)));

        // Check faculty edited description
//        List<WebElement> newFacultyCardsBody = driver.findElements(By.className("card-body"));
//        WebElement newFacultyBody = newFacultyCardsBody.get(newFacultyCardsBody.size() - 1);
        Assert.assertThat(getNewFacultyBody().getText(), is(containsString(newFacultyDescription)));
    }

    /**
     * Returns last created faculty body from the list
     *
     * @return faculty body
     */
    public WebElement getNewFacultyBody() throws InterruptedException {
        List<WebElement> facultyCardsBody = driver.findElements(By.className("card-body"));
        return facultyCardsBody.get(facultyCardsBody.size() - 1);
    }

    /**
     * Method checks path to departments home page after login
     */
    @Test
    public void checkDepartmentPage() {
        checkLoginMethod();
        driver.findElement(By.linkText("Кафедры")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement pageHeader = driver.findElement(By.className("h1"));
        Assert.assertThat(pageHeader.getText(), is(equalTo("Кафедры")));
    }

    /**
     * Method checks path to specialties home page after login
     */
    @Test
    public void checkSpecialtyPage() {
        checkLoginMethod();
        driver.findElement(By.linkText("Специальности")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement pageHeader = driver.findElement(By.className("h1"));
        Assert.assertThat(pageHeader.getText(), is(equalTo("Специальности")));
    }


}
