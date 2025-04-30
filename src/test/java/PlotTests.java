import org.example.Helper;
import org.example.models.Plot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlotTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        Helper.setUp();
        driver = Helper.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        Helper.acceptCookies();
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
    }

    @Test
    public void positiveTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankRegionTest() {
        Plot p = new Plot("", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ErrorDiv")));
        String expected = "Patikrinkite, ar teisingai užpildėte laukus, pažymėtus raudonai";
        String actual = errorElement.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankQuartalTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankStreetTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void hideHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", false, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void hideRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", false, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void notInterestedChangeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, false,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void auctionAgreeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                true, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankNotesLtTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankNotesEnTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankNotesRuTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankPhotoUploadTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{""},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Nurodykite el. pašto adresą, kad vėliau galėtumėte redaguoti arba pašalinti skelbimą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void showInAdsTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", false, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void wantChatTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, true,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankAccountTypeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 0 , true, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Prašome pasirinkti paskyros tipą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankAgreeToRulesTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\16.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 0 , false, new String[]{"Elektra", "Greta misko", "be pastatu" , "vanduo"},
                "255",new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//span[@class='error-arrow' and text()='Prašome sutikti su portalo taisyklėmis']"));
        String expected = "Prašome sutikti su portalo taisyklėmis";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

}
