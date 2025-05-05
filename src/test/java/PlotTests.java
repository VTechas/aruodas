import org.example.Helper;
import org.example.models.Plot;
import org.example.models.RealEstate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite savivaldybę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankQuartalTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", false, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, true,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 0, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
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
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 0, false, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//span[@class='error-arrow' and text()='Prašome sutikti su portalo taisyklėmis']"));
        String expected = "Prašome sutikti su portalo taisyklėmis";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankSpecialsTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{""},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 1, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite bendrą plotą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void blankIntendencesTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false, 1, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{""});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite paskirtį";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersRegionTest() {
        Plot p = new Plot("!@#$%^", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite savivaldybę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersQuartalTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "!@#$%^", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersStreetTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "!@#$%^",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "!@#$%^", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "!@#$%^", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersNotesLtTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "!@#$%^", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersNotesEnTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "!@#$%^", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersNotesRuTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "!@#$%^",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "!@#$%^", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Blogas embed kodas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "!@#$#%^", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Bloga nuoroda";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "!@#$%^",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "!@#$%^", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "!@#$%^&@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void specialCharactersAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "!@#$%^", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite bendrą plotą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterRegionTest() {
        Plot p = new Plot(" ", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Pasirinkite savivaldybę";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterQuartalTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", " ", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterStreetTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", " ",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                " ", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, " ", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterNotesLtTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, " ", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterNotesEnTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", " ", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterNotesRuTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", " ",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                " ", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Blogas embed kodas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", " ", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Bloga nuoroda";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", " ",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                " ", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", " ", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                " ", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite bendrą plotą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void negativeNumberHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "-1", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void negativeNumberRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "-300", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='RCNumber']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingas numerio formatas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void negativeNumberAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "-255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Įveskite bendrą plotą";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void lettersOnlyHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "abcde", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void numbersWithOneLetterHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15C", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void fourNumbersHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "1515", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void fiveNumbersHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15151", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        String expected = "Užsakyti";
        String actual = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")).getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void fourNumbersAndOneLetterHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "1515C", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void fiveNumbersAndOneLetterHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15151C", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        String expected = "Užsakyti";
        String actual = driver.findElement(By.xpath("//input[@name='FHouseNum']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")).getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void number0AsHouseNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "0", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void randomLettersRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, RealEstate.generateRandomLetters(10), true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        String expected = "Neteisingas numerio formatas";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random11NumbersRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, RealEstate.generateRandomNumbers(11), true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='RCNumber']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingas numerio formatas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random13NumbersRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, RealEstate.generateRandomNumbers(13), true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='RCNumber']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']"));
        String expected = "Neteisingas numerio formatas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random16NumbersRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, RealEstate.generateRandomNumbers(16), true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random17NumbersRcNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, RealEstate.generateRandomNumbers(16), true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void randomLettersPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", RealEstate.generateRandomLetters(10),
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void negativeNumbersPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "-" + RealEstate.generateRandomNumbers(10),
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Neteisinga kaina";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void number0AsPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "0",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisinga kaina";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void singleNumberNotZeroPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "5",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Kaina per maža";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void randomTwoNumbersPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", RealEstate.generateRandomNumbers(2),
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Kaina per maža";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random3NumbersPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", RealEstate.generateRandomNumbers(3),
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random256NumbersPriceTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", RealEstate.generateRandomNumbers(256),
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Neteisinga kaina";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random7NumbersWithLithuanianPrefixPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+370" + RealEstate.generateRandomNumbers(7), "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random9NumbersWithLithuanianPrefixPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+370" + RealEstate.generateRandomNumbers(9), "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random6NumbersPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+" + RealEstate.generateRandomNumbers(6), "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random7NumbersPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+" + RealEstate.generateRandomNumbers(7), "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random16NumbersPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+" + RealEstate.generateRandomNumbers(16), "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random17NumbersPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+" + RealEstate.generateRandomNumbers(17), "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void randomNumbersWithoutPlusSignPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                RealEstate.generateRandomNumbers(15), "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void randomNumbersWithMultiplePlusSignsPhoneNumTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+" + RealEstate.generateRandomNumbers(10) + "+", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='phone']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Neteisingas telefono numeris";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void randomLettersAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                RealEstate.generateRandomLetters(10), new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite bendrą plotą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void number0AsAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "0", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Įveskite bendrą plotą";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void singleNumberNot0AreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "1", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random7NumbersWithout0AtTheStartAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "1" + RealEstate.generateRandomNumbers(6), new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random8NumbersWithout0AtTheStartAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "1" + RealEstate.generateRandomNumbers(7), new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void randomNumbersWith0AndACommaStartAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "0," + RealEstate.generateRandomNumbers(7), new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Užsakyti";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random8NumbersWithout0AtTheStartAndACommaAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "1," + RealEstate.generateRandomNumbers(8), new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random9NumbersWithout0AtTheStartAndACommaAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "1," + RealEstate.generateRandomNumbers(9), new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void randomNumbersMultipleCommasAreaSizeTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                ("1," + RealEstate.generateRandomNumbers(2) + "," + RealEstate.generateRandomNumbers(2)), new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.has-error span.error-arrow")));
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Neteisingai įvesta reikšmė";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void noAtSymbolEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(8) + "gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void multipleAtSymbolsEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(4) + "@" + RealEstate.generateRandomLetters(4) + "@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void subdomainEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(10) + "@gmail.subdomain.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void invalidDomainEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(4) + "@gmail", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void spaceCharacterWithinEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(4) + " @gmail", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random255CharactersEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(245) + "@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random256CharactersEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(247) + "@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void singleCharacterInDomainAfterDotEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(10) + "@gmail." + RealEstate.generateRandomLetters(1), true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email']/ancestor::li[contains(@class,'has-error')]//span[@class='error-arrow']")));
        String expected = "Blogas el. pašto adresas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random2CharactersInDomainAfterDotEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(10) + "@gmail." + RealEstate.generateRandomLetters(2), true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void singleCharacterEmailTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", RealEstate.generateRandomLetters(1) + "@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random1000CharactersNotesLtTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, RealEstate.generateRandomLetters(1000), "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random1000CharactersNotesEnTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodam", RealEstate.generateRandomLetters(1000), "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void random1000CharactersNotesRuTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodam", "Property for sale", RealEstate.generateRandomLetters(1000),
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void valid36PhotoUploadTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void valid37PhotoUploadTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg", "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg",
                        "C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\13.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Galima įdėti ne daugiau nei 36 nuotraukas";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void gifPhotoUploadTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\14.gif"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Klaida. Neteisingas nuotraukos formatas";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void mp4PhotoUploadTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\2.mp4"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Klaida. Neteisingas nuotraukos formatas";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void ddsPhotoUploadTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\10.dds"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Klaida. Neteisingas nuotraukos formatas";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void file31MBPhotoUploadTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\31mb.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void file40MBPhotoUploadTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\40mb.jpg"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Nuotraukos dydis per didelis";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void noHttpsVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "www.youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void noWwwVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "youtube.com/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void notYoutubeLinkVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.instagram.com/reel/DHxlT27sR8L/?igsh=MTVic2E4cHRyenh3NA==", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.xpath("//input[@name='Video']/ancestor::li[contains(@class, 'has-error')]//span[@class='error-arrow']"));
        String expected = "Blogas embed kodas";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void noDomainVideoTest() {
        Plot p = new Plot("Vilnius", "Vilniaus", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "youtube/watch?v=5EpyN_6dqyk", "https://www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Blogas embed kodas";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void noHttpsTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "www.google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void noWwwTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "google.com/maps", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void randomSiteLinkTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "twitch.tv", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btPlanChooseOrder")));
        String expected = "Užsakyti";
        String actual = driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void noDomainTour3dTest() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Bajorai", "Paeglines sodu 5",
                "15", true, "1234-1234-1234", true, true,
                false, "Parduodu sklypa", "Property for sale", "Paruski ne bum bum",
                new String[]{"C:\\Users\\rimsa\\IdeaProjects\\aruodas\\pics\\15.png"},
                "https://www.youtube.com/watch?v=5EpyN_6dqyk", "twitch", "452000",
                "+37064610123", "ThomasShelby@gmail.com", true, false,
                2, true, new String[]{"Elektra", "Greta misko", "be pastatu", "vanduo"},
                "255", new String[]{"Namų valda", "Daugiabučių statyba", "Miškų ūkio"});
        p.fill();
        driver.findElement(By.id("submitFormButton")).click();
        WebElement errorSpan = driver.findElement(By.cssSelector("li.has-error span.error-arrow"));
        String expected = "Bloga nuoroda";
        String actual = errorSpan.getText().trim();
        Assert.assertEquals(actual, expected);
    }

}
