package org.example.models;

import org.example.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class RealEstate {
    public WebDriver driver;
    public String region;
    public String district;
    public String quartal;
    public String street;
    public String houseNum;
    public boolean showHouseNum;
    public String rcNum;
    public boolean showRcNum;
    public boolean interestedChange;
    public boolean auction;
    public String notes_lt;
    public String notes_en;
    public String notes_ru;
    public String[] photos;
    public String video;
    public String tour3d;
    public String price;
    public String phoneNum;
    public String email;
    public boolean dontShowInAds;
    public boolean dontWantChat;
    public int accountType;
    public boolean agreeToRules;
    public String[] specials;

    public RealEstate() {
    }

    public RealEstate(String region, String district, String quartal, String street, String houseNum, boolean showHouseNum, String rcNum, boolean showRcNum, boolean interestedChange, boolean auction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phoneNum, String email, boolean dontShowInAds, boolean dontWantChat, int accountType, boolean agreeToRules, String[] specials) {
        this.driver = Helper.driver;
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.houseNum = houseNum;
        this.showHouseNum = showHouseNum;
        this.rcNum = rcNum;
        this.showRcNum = showRcNum;
        this.interestedChange = interestedChange;
        this.auction = auction;
        this.notes_lt = notes_lt;
        this.notes_en = notes_en;
        this.notes_ru = notes_ru;
        this.photos = photos;
        this.video = video;
        this.tour3d = tour3d;
        this.price = price;
        this.phoneNum = phoneNum;
        this.email = email;
        this.dontShowInAds = dontShowInAds;
        this.dontWantChat = dontWantChat;
        this.accountType = accountType;
        this.agreeToRules = agreeToRules;
        this.specials = specials;
    }

    public void fill() {
        fillLocation();
        fillSpecials();
        fillRest();
    }

    public void fillLocation() {
        fillRegion();
        if (this.region != null && !this.region.trim().isEmpty()) {
            fillDistrict();

            if (this.district != null && !this.district.trim().isEmpty()) {
                fillQuartal();

                if (this.street != null && !this.street.trim().isEmpty()) {
                    fillStreet();
                }
            }
        }
        fillHouseNum();
        fillShowHouseNum();
        fillRcNum();
        fillShowRcNum();
    }

    public void fillRest() {
        fillInterestedChange();
        fillAuction();
        fillNotesLt();
        fillNotesEn();
        fillNotesRu();
        fillPhotos();
        fillVideo();
        fillTour3d();
        fillPrice();
        fillPhoneNum();
        fillEmail();
        fillDontShowInAds();
        fillDontWantChat();
        fillAccountType();
        fillAgreeToRules();
    }

    private void fillAuction() {
        if (this.auction) {
            driver.findElement(By.xpath("//label[contains(., 'Varžytynės/aukcionas')]")).click();
        }
    }

    private void fillInterestedChange() {
        if (this.interestedChange) {
            driver.findElement(By.xpath("//label[contains(., 'Domina keitimas')]")).click();
        }
    }

    private void fillShowRcNum() {
        if (!this.showRcNum) {
            driver.findElement(By.cssSelector("label[for='cbshow_rc_number'] span")).click();
        }
    }

    private void fillRcNum() {
        driver.findElement(By.name("RCNumber")).sendKeys(this.rcNum);
    }

    private void fillShowHouseNum() {
        if (!this.showHouseNum) {
            driver.findElement(By.cssSelector("label[for='cbshow_house_num'] span")).click();
        }
    }

    private void fillHouseNum() {
        driver.findElement(By.name("FHouseNum")).sendKeys(this.houseNum);
    }

    private void fillStreet() {
        if (this.street == null || this.street.trim().isEmpty()) return;

        try {
            WebElement streetInput = driver.findElement(By.id("streetTitle"));
            streetInput.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//ul[contains(@id, 'streets') and not(contains(@class,'hide'))]//input[contains(@class, 'dropdown-input-search-value')]")
            ));

            searchInput.sendKeys(this.street);
            wait(1000);
            searchInput.sendKeys(Keys.ENTER);

        } catch (Exception e) {}
    }

    private void fillQuartal() {
        if (this.quartal == null || this.quartal.trim().isEmpty()) return;

        try {
            WebElement quartalInput = driver.findElement(By.xpath("//input[contains(@class, 'dropdown-input-value-title') and @id='quartalTitle']"));
            quartalInput.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//ul[contains(@id, 'quartals') and not(contains(@class,'hide'))]//input[contains(@class, 'dropdown-input-search-value')]")
            ));

            searchInput.sendKeys(this.quartal);
            Thread.sleep(1000); // or wait for suggestions explicitly
            searchInput.sendKeys(Keys.ENTER);

        } catch (Exception e) {}
    }

    private void fillDistrict() {
    }

    private void fillRegion() {
        if (this.region == null || this.region.trim().isEmpty()) return;

        WebElement regionInput = driver.findElement(By.xpath("//input[contains(@class, 'dropdown-input-value-title') and @readonly]"));
        regionInput.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@id='regionDropdown']//input[contains(@class, 'dropdown-input-search-value')]")
        ));

        searchInput.sendKeys(this.region);
        wait(1000);
        searchInput.sendKeys(Keys.ENTER);
    }

    private void fillAgreeToRules() {
        if (this.agreeToRules) {
            driver.findElement(By.cssSelector("label[for='cbagree_to_rules'] span")).click();
        }
    }

    private void fillAccountType() {
        if (this.accountType <= 0) return;
        driver.findElement(By.xpath("//div[@class='input-button' and @data-value='" + this.accountType + "']")).click();
    }

    private void fillDontWantChat() {
        if (this.dontWantChat) {
            driver.findElement(By.xpath("//label[starts-with(@for, 'cbdont_want_chat')]")).click();
        }
    }

    private void fillDontShowInAds() {
        if (this.dontShowInAds) {
            driver.findElement(By.xpath("//label[starts-with(@for, 'cbdont_show_in_ads')]")).click();
        }
    }

    private void fillEmail() {
        driver.findElement(By.name("email")).sendKeys(this.email);
    }

    private void fillPhoneNum() {
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(this.phoneNum);
    }

    private void fillPrice() {
        driver.findElement(By.id("priceField")).sendKeys(this.price);
    }

    private void fillTour3d() {
        driver.findElement(By.name("tour_3d")).sendKeys(this.tour3d);
    }

    private void fillVideo() {
        driver.findElement(By.name("Video")).sendKeys(this.video);
    }

    private void fillPhotos() {
        if (this.photos == null || this.photos.length == 0) {
            return; //
        }

        StringBuilder filePaths = new StringBuilder();
        for (String photo : this.photos) {
            if (photo != null && !photo.trim().isEmpty()) {
                filePaths.append(photo).append("\n");
            }
        }

        String filePathsToSend = filePaths.toString().trim();
        if (filePathsToSend.isEmpty()) {
            return; //
        }

        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input"));
        fileInput.sendKeys(filePathsToSend);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("upload-loader")));
        } catch (Exception e) {}
    }

    private void fillNotesRu() {
        driver.findElement(By.className("lang-ru-label")).click();
        wait(500);
        driver.findElement(By.name("notes_ru")).sendKeys(this.notes_ru);
    }

    private void fillNotesEn() {
        driver.findElement(By.className("lang-en-label")).click();
        wait(500);
        driver.findElement(By.name("notes_en")).sendKeys(this.notes_en);
    }

    private void fillNotesLt() {
        driver.findElement(By.name("notes_lt")).sendKeys(this.notes_lt);
    }

    public void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }

    public void fillSpecials(){
        driver.findElement(By.id("showMoreFields")).click();
        wait(200);
        for (int i = 0; i < this.specials.length; i++) {
            driver.findElement(By.xpath(
                    "//label[contains(translate(normalize-space(string()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽąčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzaceeisuuz'), '" + normalizeSpecial(specials[i]) +"')]"
            )).click();
        }
    }

    public String normalizeSpecial(String text) {
        return text.toLowerCase()
                .replace("ą", "a")
                .replace("č", "c")
                .replace("ę", "e")
                .replace("ė", "e")
                .replace("į", "i")
                .replace("š", "s")
                .replace("ų", "u")
                .replace("ū", "u")
                .replace("ž", "z");
    }

    public static String generateRandomLetters(int length) {

        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String text = "";

        for (int i = 0; i < length; i++) {
            text += symbols.charAt((int) (Math.random() * symbols.length()));
        }
        return text;
    }

    public static String generateRandomNumbers(int length) {
        Random random = new Random();
        StringBuilder number = new StringBuilder();

        // First digit should not be 0
        number.append(random.nextInt(9) + 1);

        for (int i = 1; i < length; i++) {
            number.append(random.nextInt(10));
        }

        return number.toString();
    }
}
