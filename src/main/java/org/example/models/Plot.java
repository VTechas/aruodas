package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Plot {
    public WebDriver driver;
    public String region;
    public String district;
    public String quartal;
    public String street;
    public String objNum;
    public String rcNum;
    public String areaSize;
    public int[] intendancies;
    public int[] specials;
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
    public boolean cbDontShowInAds;
    public boolean cbDontWantChat;
    public int accountType;
    public boolean cbAgreeToRules;


    public Plot(WebDriver driver, String region, String district, String quartal, String street, String objNum, String rcNum, String areaSize, int[] intendancies, int[] specials, boolean interestedChange, boolean auction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phoneNum, String email, boolean cbDontShowInAds, boolean cbDontWantChat, int accountType, boolean cbAgreeToRules) {
        this.driver = driver;
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.objNum = objNum;
        this.rcNum = rcNum;
        this.areaSize = areaSize;
        this.intendancies = intendancies;
        this.specials = specials;
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
        this.cbDontShowInAds = cbDontShowInAds;
        this.cbDontWantChat = cbDontWantChat;
        this.accountType = accountType;
        this.cbAgreeToRules = cbAgreeToRules;
    }

    public void fill() {
        fillUpToObjNum();
        fillRcNumToSpecials();
        fillNotesToEnd();
    }

    public void fillUpToObjNum() {
        fillRegion();
        fillDistrict();
        fillQuartal();
        fillStreet();
        fillObjNum();
    }

    public void fillRcNumToSpecials() {
        fillRcNum();
        fillAreaSize();
        fillIntendancies();
        fillSpecials();
    }

    public void fillNotesToEnd() {
        fillNotesLt();
        fillNotesEn();
        fillNotesRu();
        fillPhotos();
        fillVideo();
        fillTour3d();
        fillPrice();
        fillPhoneNum();
        fillEmail();
        fillCbDontShowInAds();
        fillCbDontWantChat();
        fillAccountType();
        fillAgreeToRules();
    }

    private void fillAgreeToRules() {
        if (this.cbAgreeToRules) {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[41]/span[1]/div/div/label/span")).click();
        }
    }

    private void fillAccountType() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[39]/div[1]/div[" + this.accountType + "]")).click();

    }

    private void fillCbDontWantChat() {
        if (this.cbDontWantChat) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[37]/div/div/div/label/span")).click();
        }
    }

    private void fillCbDontShowInAds() {
        if (this.cbDontShowInAds) {
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
        StringBuilder filePaths = new StringBuilder();

        for (String photo : this.photos) {
            filePaths.append(photo).append("\n");
        }

        String filePathsToSend = filePaths.toString().trim();
        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input"));
        fileInput.sendKeys(filePathsToSend);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Wait for up to 20 seconds
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("upload-loader")));
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

    private void fillSpecials() {
        driver.findElements(By.className("input-style-change-object")).get(1).click();
        for (int i = 0; i < this.specials.length; i++) {
            int index = this.specials[i];
            try {
                driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[" + index + "]/label/span")).click();
            } catch (Exception e) {
            }
        }
        if (interestedChange) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/div/div/div/label/span")).click();
        }
        if (auction) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/div/div/div/label/span")).click();
        }
    }

    private void fillIntendancies() {
        for (int i = 0; i < this.intendancies.length; i++) {
            int index = this.intendancies[i];
            try {
                driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[" + index + "]/label/span")).click();
            } catch (Exception e) {
            }
        }
    }


    private void fillAreaSize() {
        driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.areaSize);
    }

    private void fillRcNum() {
        driver.findElement(By.name("RCNumber")).sendKeys(this.rcNum);
    }

    private void fillObjNum() {
        driver.findElement(By.name("FHouseNum")).sendKeys(this.objNum);
    }

    private void fillStreet() {
        driver.findElements(By.className("dropdown-input-value-title")).get(3).click();
        wait(500);
        driver.findElements(By.className("dropdown-input-search-value")).get(4).sendKeys(this.street);
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(4).sendKeys(Keys.ENTER);
    }

    private void fillQuartal() {
        driver.findElements(By.className("dropdown-input-value-title")).get(2).click();
        wait(500);
        driver.findElements(By.className("dropdown-input-search-value")).get(1).sendKeys(this.quartal);
        wait(500);
        driver.findElements(By.className("dropdown-input-search-value")).get(1).sendKeys(Keys.ENTER);
    }

    private void fillDistrict() {
    }

    private void fillRegion() {
        driver.findElements(By.className("dropdown-input-value-title")).get(0).click();
        wait(500);
        driver.findElements(By.className("dropdown-input-search-value")).get(0).sendKeys(this.region);
        wait(500);
        driver.findElements(By.className("dropdown-input-search-value")).get(0).sendKeys(Keys.ENTER);
    }

    public void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }

}
